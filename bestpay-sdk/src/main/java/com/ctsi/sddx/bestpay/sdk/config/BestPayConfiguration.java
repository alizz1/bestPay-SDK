package com.ctsi.sddx.bestpay.sdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "best-pay")
public class BestPayConfiguration {

    private boolean enabled = false;

    /**
     * 是否打印翼支付请求报文和响应报文
     */
    private boolean debug = false;
    /**
     * 翼支付访问域名，仅域名部分
     */
    private String requestUrl;
    /**
     * 翼支付证书路径
     */
    private String bestPayCertPath;

    private String merchantCertPath;

    private String certIv;

    private String certPwd;

    private Long payTimeOut = 300L;

    public Long getPayTimeOut() {
        return payTimeOut;
    }

    public void setPayTimeOut(Long payTimeOut) {
        this.payTimeOut = payTimeOut;
    }

    public boolean isDebug() {
        return debug;
    }

    public BestPayConfiguration setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public BestPayConfiguration setRequestUrl(String requestURL) {
        this.requestUrl = requestURL;
        return this;
    }

    public String getBestPayCertPath() {
        return bestPayCertPath;
    }

    public BestPayConfiguration setBestPayCertPath(String bestPayCertPath) {
        this.bestPayCertPath = bestPayCertPath;
        return this;
    }

    public String getMerchantCertPath() {
        return merchantCertPath;
    }

    public BestPayConfiguration setMerchantCertPath(String merchantCertPath) {
        this.merchantCertPath = merchantCertPath;
        return this;
    }

    public String getCertIv() {
        return certIv;
    }

    public BestPayConfiguration setCertIv(String certIv) {
        this.certIv = certIv;
        return this;
    }

    public String getCertPwd() {
        return certPwd;
    }

    public BestPayConfiguration setCertPwd(String certPwd) {
        this.certPwd = certPwd;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
