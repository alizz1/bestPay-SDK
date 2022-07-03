package com.ctsi.sddx.bestpay.sdk.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 验签，加签
 *
 * @author zxqy
 */
public abstract class VerifyUtils {
    private static final Logger log = LoggerFactory.getLogger(VerifyUtils.class);

    /**
     * 函数功能：使用商户私钥加签
     * 参数：tobeSigned，待加签的字符串，V3，版为json字符串，V4，V5版为用&连接起来的key=value键值对
     * 参数：algorithm,加签算法，V3，V4版本为SHA1withRSA，V5版本为SHA256withRSA
     */
    public static TreeMap<String, String> sign(JsonNode jsonParams, PrivateKey merchantPrivateKey) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, IOException {
        TreeMap<String, String> params = new TreeMap<>();
        ObjectNode on = (ObjectNode) jsonParams;
        on.fieldNames().forEachRemaining(key -> {
            JsonNode te = on.findValue(key);
            if (!te.isNull()) {
                if (te.isContainerNode()) {
                    params.put(key, te.toString());
                } else {
                    params.put(key, te.asText());
                }
            }
        });
        String tobeSigned = params.entrySet().stream()
                .map(entry -> entry.getKey().concat("=").concat(entry.getValue()))
                .collect(Collectors.joining("&"));
        log.debug("代签名字符串 {}", tobeSigned);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(merchantPrivateKey);
        signature.update(tobeSigned.getBytes(StandardCharsets.UTF_8));
        byte[] signBytes = signature.sign();
        String signed = new String(Base64.encode(signBytes));
        params.put("sign", signed);
        return params;
    }

    /**
     * 验签操作
     *
     * @param response
     * @param publicKey
     * @return
     */
    public static boolean doVerifySHA256withRSA(JsonNode response, PublicKey publicKey) {
        StringBuffer sb = new StringBuffer();
        String sign = null;
        TreeMap<String, String> map = new TreeMap<>();
        response.fieldNames().forEachRemaining(key -> {
            JsonNode te = response.findValue(key);
            if (!te.isNull()) {
                if (te.isContainerNode()) {
                    map.put(key, te.toString());
                } else {
                    map.put(key, te.asText());
                }
            }
        });
        for (Object mapKey : map.keySet()) {
            Object mapValue = map.get(mapKey);
            if ("sign".equals(mapKey)) {
                sign = (String) mapValue;
            } else {
                sb.append("&").append(mapKey).append("=").append(mapValue);
            }
        }
        String tobeVerify = sb.substring(1);
        log.info("待验签tobeVerify：" + tobeVerify);
        try {
            return verify(tobeVerify, sign, publicKey);
        } catch (Exception e) {
            log.error("verify sign error: ", e);
            return false;
        }
    }

    private static boolean verify(String plainText, String sign, PublicKey publicKey) {
        try {
            Signature verify = Signature.getInstance("SHA1withRSA");
            verify.initVerify(publicKey);
            verify.update(plainText.getBytes(StandardCharsets.UTF_8));
            return verify.verify(Base64.decode(sign));
        } catch (Exception e) {
            throw new RuntimeException("验签失败", e);
        }
    }

}
