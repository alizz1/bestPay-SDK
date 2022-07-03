package com.ctsi.sddx.bestpay.sdk;

import com.ctsi.sddx.bestpay.sdk.config.BestPayConfiguration;
import com.ctsi.sddx.bestpay.sdk.dto.*;
import com.ctsi.sddx.bestpay.sdk.model.*;
import com.ctsi.sddx.bestpay.sdk.utils.VerifyUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * 翼支付操作入口
 */
public class BestPay implements ResourceLoaderAware, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(BestPay.class);
    private final ObjectMapper objectMapper;
    private final RestTemplateBuilder restTemplateBuilder;
    private final BestPayConfiguration bestPayConfiguration;

    private RestTemplate restTemplate;
    private PrivateKey merchantPrivateKey;
    private PublicKey bestpayPublicKey;
    private String iv;

    private ResourceLoader resourceLoader;

    public BestPay(ObjectMapper objectMapper, RestTemplateBuilder restTemplateBuilder, BestPayConfiguration bestPayConfiguration) {
        this.objectMapper = objectMapper;
        this.bestPayConfiguration = bestPayConfiguration;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    /**
     * 加载交易证书
     */
    private void loadTradeCert(BestPayConfiguration configuration) throws IOException {
        String merchantCertPath = configuration.getMerchantCertPath();
        String certPwd = configuration.getCertPwd();
        String bestPayCertPath = configuration.getBestPayCertPath();
        String iv = configuration.getCertIv();

        if (!StringUtils.hasText(merchantCertPath)) {
            log.error("best-pay config for [best-pay.merchant-cert-path] can not be null");
            throw new RuntimeException("best-pay config for [best-pay.merchant-cert-path] can not be null");
        }

        if (!StringUtils.hasText(certPwd)) {
            log.error("best-pay config for [best-pay.cert-pwd] can not be null");
            throw new RuntimeException("best-pay config for [best-pay.cert-pwd] can not be null");
        }

        if (!StringUtils.hasText(bestPayCertPath)) {
            log.error("best-pay config for [best-pay.best-pay-cert-path] can not be null");
            throw new RuntimeException("best-pay config for [best-pay.best-pay-cert-path] can not be null");
        }

        if (!StringUtils.hasText(iv)) {
            log.error("best-pay config for [best-pay.iv] can not be null");
            throw new RuntimeException("best-pay config for [best-pay.iv] can not be null");
        }

        Resource merchantCert = resourceLoader.getResource(merchantCertPath);
        Resource bestPayCert = resourceLoader.getResource(bestPayCertPath);

        if (!merchantCert.exists()) {
            log.error("can not find merchantCert, please check [best-pay.merchant-cert-path]");
            throw new RuntimeException("can not find merchantCert, please check [best-pay.merchant-cert-path]");
        }

        if (!bestPayCert.exists()) {
            log.error("can not find bestPayCert, please check [best-pay.best-pay-cert-path]");
            throw new RuntimeException("can not find bestPayCert, please check [best-pay.best-pay-cert-path]");
        }
        this.iv = iv;
        this.bestpayPublicKey = getBestpayPublicKey(bestPayCert.getInputStream());
        this.merchantPrivateKey = getMerchantPrivateKey(merchantCert.getInputStream(), certPwd, "PKCS12");
    }

    private PrivateKey getMerchantPrivateKey(InputStream priKey, String keyPassword, String keyStoreType) {
        String keyAlias;
        PrivateKey privateKey = null;
        try {
            KeyStore ks = KeyStore.getInstance(keyStoreType);
            ks.load(priKey, keyPassword.toCharArray());
            Enumeration<?> myEnum = ks.aliases();
            while (myEnum.hasMoreElements()) {
                keyAlias = (String) myEnum.nextElement();
                if (ks.isKeyEntry(keyAlias)) {
                    privateKey = (PrivateKey) ks.getKey(keyAlias, keyPassword.toCharArray());
                    break;
                }
            }
        } catch (Exception e) {
            if (priKey != null) {
                try {
                    priKey.close();
                } catch (IOException e1) {
                    throw new RuntimeException("流关闭异常", e1);
                }
            }
            throw new RuntimeException("加载私钥失败", e);
        }

        if (privateKey == null) {
            throw new RuntimeException("私钥不存在");
        }
        return privateKey;
    }

    private PublicKey getBestpayPublicKey(InputStream pubKey) {
        X509Certificate x509cert = null;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            x509cert = (X509Certificate) cf.generateCertificate(pubKey);
        } catch (CertificateException e) {
            if (pubKey != null) {
                try {
                    pubKey.close();
                } catch (IOException e1) {
                    throw new RuntimeException("文件流关闭异常", e1);
                }
            }
            throw new RuntimeException("初始化公钥异常", e);
        }
        return x509cert.getPublicKey();
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 加载证书
        loadTradeCert(this.bestPayConfiguration);
        // 创建http客户端
        if (!StringUtils.hasText(bestPayConfiguration.getRequestUrl())) {
            log.error("best-pay config for [best-pay.request-url] can not be null");
            throw new RuntimeException("best-pay config for [best-pay.request-url] can not be null");
        }
        this.restTemplate = restTemplateBuilder
                .setBufferRequestBody(true)
                .rootUri(bestPayConfiguration.getRequestUrl())
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .additionalInterceptors((request, body, execution) -> {
                    if (bestPayConfiguration.isDebug()) {
                        log.debug("===========================request begin================================================");
                        log.debug("URI         : {}", request.getURI());
                        log.debug("Method      : {}", request.getMethod());
                        log.debug("Headers     : {}", request.getHeaders());
                    }
                    // 加签操作
                    byte[] newBody = null;

                    if (body.length > 0) {
                        try {
                            JsonNode jsonParams = objectMapper.readTree(body);
                            String newBodyStr = objectMapper.writeValueAsString(VerifyUtils.sign(jsonParams, merchantPrivateKey));
                            newBody = newBodyStr.getBytes(StandardCharsets.UTF_8);
                            if (bestPayConfiguration.isDebug()) {
                                log.debug("Request body: {}", newBodyStr);
                                log.debug("==========================request end================================================");
                            }
                        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
                            log.error("加签错误，url: {}", request.getURI());
                            throw new RuntimeException("sign error");
                        }
                    }

                    ClientHttpResponse response = execution.execute(request, newBody == null ? body : newBody);
                    InputStream inputStream = response.getBody();
                    String copyedBodyStr = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
                    if (bestPayConfiguration.isDebug()) {
                        log.debug("============================response begin==========================================");
                        log.debug("Status code  : {}", response.getStatusCode());
                        log.debug("Status text  : {}", response.getStatusText());
                        log.debug("Headers      : {}", response.getHeaders());
                        log.debug("Response body: {}", copyedBodyStr);
                        log.debug("=======================response end=================================================");
                    }
                    /**
                     * 验签操作
                     */
                    JsonNode toBeVerify = objectMapper.readTree(response.getBody());
                    if (toBeVerify.path("success").asBoolean() && !VerifyUtils.doVerifySHA256withRSA(toBeVerify, bestpayPublicKey)) {
                        log.error("verify sign data failed");
                        throw new RuntimeException("verify sign data failed");
                    }
                    return response;
                }).build();

    }


    /**
     * 退款请求
     *
     * @param model
     * @return
     */
    public BestPayResult<RefundResponse> refund(BestPayRefundModel model) {
        model.build();
        HttpEntity<BestPayRefundModel> entity = new HttpEntity<>(model);
        ParameterizedTypeReference<InnerResponse<RefundResponse>> parameterizedTypeReference = new ParameterizedTypeReference<InnerResponse<RefundResponse>>() {
        };
        ResponseEntity<InnerResponse<RefundResponse>> responseEntity = restTemplate.exchange("/gapi/integrate/refund", HttpMethod.POST, entity, parameterizedTypeReference);
        InnerResponse<RefundResponse> response = responseEntity.getBody();
        if (response.isSuccess()) {
            return BestPayResult.success(response.getResult());
        }
        return BestPayResult.error(response.getErrorCode(), response.getErrorMsg(), response.getResult());
    }

    /**
     * 统一下单接口
     *
     * @param model
     * @return
     */
    public BestPayResult<TradeCreateResponse> tradeCreate(BestPayTradeCreateModel model) {
        model.build();
        model.setTimeOut(bestPayConfiguration.getPayTimeOut());
        HttpEntity<BestPayTradeCreateModel> entity = new HttpEntity<>(model);
        ParameterizedTypeReference<InnerResponse<TradeCreateResponse>> parameterizedTypeReference = new ParameterizedTypeReference<InnerResponse<TradeCreateResponse>>() {
        };
        ResponseEntity<InnerResponse<TradeCreateResponse>> responseEntity = restTemplate.exchange("/gapi/pay/tradeCreate", HttpMethod.POST, entity, parameterizedTypeReference);
        InnerResponse<TradeCreateResponse> response = responseEntity.getBody();
        if (response.isSuccess()) {
            return BestPayResult.success(response.getResult());
        }
        return BestPayResult.error(response.getErrorCode(), response.getErrorMsg(), response.getResult());
    }

    /**
     * 延迟分账确认、取消
     *
     * @param model
     * @return
     */
    public BestPayResult<SplitDelayedResponse> splitDelayedConfirm(BestPaySplitDelayedModel model) {
        model.build();
        HttpEntity<BestPaySplitDelayedModel> entity = new HttpEntity<>(model);
        ParameterizedTypeReference<InnerResponse<SplitDelayedResponse>> parameterizedTypeReference = new ParameterizedTypeReference<InnerResponse<SplitDelayedResponse>>() {
        };
        ResponseEntity<InnerResponse<SplitDelayedResponse>> responseEntity = restTemplate.exchange("/gapi/integrate/splitDelayedConfirm", HttpMethod.POST, entity, parameterizedTypeReference);
        InnerResponse<SplitDelayedResponse> response = responseEntity.getBody();
        if (response.isSuccess()) {
            return BestPayResult.success(response.getResult());
        }
        return BestPayResult.error(response.getErrorCode(), response.getErrorMsg(), response.getResult());
    }

    /**
     * 订单查询
     *
     * @param model
     * @return
     */
    public BestPayResult<OrderQueryResponse> orderQuery(BestPayOrderQueryModel model) {
        model.build();
        HttpEntity<BestPayOrderQueryModel> entity = new HttpEntity<>(model);
        ParameterizedTypeReference<InnerResponse<OrderQueryResponse>> parameterizedTypeReference = new ParameterizedTypeReference<InnerResponse<OrderQueryResponse>>() {
        };
        ResponseEntity<InnerResponse<OrderQueryResponse>> responseEntity = restTemplate.exchange("/gapi/integrate/orderQuery", HttpMethod.POST, entity, parameterizedTypeReference);
        InnerResponse<OrderQueryResponse> response = responseEntity.getBody();
        if (response.isSuccess()) {
            return BestPayResult.success(response.getResult());
        }
        return BestPayResult.error(response.getErrorCode(), response.getErrorMsg(), response.getResult());
    }

    /**
     * 退款查询
     *
     * @param model
     * @return
     */
    public BestPayResult<RefundQueryResponse> refundQuery(BestPayRefundQueryModel model) {
        model.build();
        HttpEntity<BestPayRefundQueryModel> entity = new HttpEntity<>(model);
        ParameterizedTypeReference<InnerResponse<RefundQueryResponse>> parameterizedTypeReference = new ParameterizedTypeReference<InnerResponse<RefundQueryResponse>>() {
        };
        ResponseEntity<InnerResponse<RefundQueryResponse>> responseEntity = restTemplate.exchange("/gapi/integrate/refundQuery", HttpMethod.POST, entity, parameterizedTypeReference);
        InnerResponse<RefundQueryResponse> response = responseEntity.getBody();
        if (response.isSuccess()) {
            return BestPayResult.success(response.getResult());
        }
        return BestPayResult.error(response.getErrorCode(), response.getErrorMsg(), response.getResult());
    }

    /**
     * 延迟分账查询接口
     *
     * @param model
     * @return
     */
    public BestPayResult<SplitDelayQueryResponse> splitDelayQuery(BestPaySplitDelayedQueryModel model) {
        model.build();
        HttpEntity<BestPaySplitDelayedQueryModel> entity = new HttpEntity<>(model);
        ParameterizedTypeReference<InnerResponse<SplitDelayQueryResponse>> parameterizedTypeReference = new ParameterizedTypeReference<InnerResponse<SplitDelayQueryResponse>>() {
        };
        ResponseEntity<InnerResponse<SplitDelayQueryResponse>> responseEntity = restTemplate.exchange("/gapi/integrate/splitDelayedQuery", HttpMethod.POST, entity, parameterizedTypeReference);
        InnerResponse<SplitDelayQueryResponse> response = responseEntity.getBody();
        if (response.isSuccess()) {
            return BestPayResult.success(response.getResult());
        }
        return BestPayResult.error(response.getErrorCode(), response.getErrorMsg(), response.getResult());
    }

}
