package com.ctsi.sddx.bestpay.sdk.model;

import com.ctsi.sddx.bestpay.sdk.CommVairs;
import com.ctsi.sddx.bestpay.sdk.model.sub.SplitDelayMerchantInfo;

import java.util.List;


public class BestPaySplitDelayedModel extends BestPayCommonModel<BestPaySplitDelayedModel> {

    private String merchantNo;

    private String outTradeNo;

    private String originalOutTradeNo;

    private CommVairs.ConfirmType confirmType;

    private String originalTradeDate;

    private String tradeAmt;

    private String requestDate;

    private List<SplitDelayMerchantInfo> splitDelayMerchantInfo;

    private String reason;

    public BestPaySplitDelayedModel() {
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOriginalOutTradeNo() {
        return originalOutTradeNo;
    }

    public void setOriginalOutTradeNo(String originalOutTradeNo) {
        this.originalOutTradeNo = originalOutTradeNo;
    }

    public CommVairs.ConfirmType getConfirmType() {
        return confirmType;
    }

    public void setConfirmType(CommVairs.ConfirmType confirmType) {
        this.confirmType = confirmType;
    }

    public String getOriginalTradeDate() {
        return originalTradeDate;
    }

    public void setOriginalTradeDate(String originalTradeDate) {
        this.originalTradeDate = originalTradeDate;
    }

    public String getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(String tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public List<SplitDelayMerchantInfo> getSplitDelayMerchantInfo() {
        return splitDelayMerchantInfo;
    }

    public void setSplitDelayMerchantInfo(List<SplitDelayMerchantInfo> splitDelayMerchantInfo) {
        this.splitDelayMerchantInfo = splitDelayMerchantInfo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public BestPaySplitDelayedModel build() {
        return null;
    }
}
