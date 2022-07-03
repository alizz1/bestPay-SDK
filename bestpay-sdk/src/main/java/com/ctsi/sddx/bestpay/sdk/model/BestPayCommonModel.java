package com.ctsi.sddx.bestpay.sdk.model;

import java.io.Serializable;

/**
 * 翼支付公共参数
 *
 * @author zxqy
 */
public abstract class BestPayCommonModel<T extends BestPayCommonModel> implements Serializable {
    /**
     * 签约类型
     * 固定参数，不需要改动
     */
    private final String signType = "S002";

    /**
     * 签约商户号
     * 条件必填，表示加签使用的CA证书对应的商户号
     * 如果交易商户为父商户，可不填
     * 如果交易商户为子商户，可不填或填父商户号（一般用于父商户代理子商户发起交易的情况）
     */
    private String signMerchantNo;
    /**
     * 签约商户号
     * 与signMerchantNo传值一致
     */
    private String institutionCode;
    /**
     * 签约ID
     */
    private String agreeId;

    public String getSignType() {
        return signType;
    }

    public String getSignMerchantNo() {
        return signMerchantNo;
    }

    public void setSignMerchantNo(String signMerchantNo) {
        this.signMerchantNo = signMerchantNo;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getAgreeId() {
        return agreeId;
    }

    public void setAgreeId(String agreeId) {
        this.agreeId = agreeId;
    }

    public abstract T build();
}
