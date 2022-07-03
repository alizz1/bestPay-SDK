package com.ctsi.sddx.bestpay.sdk.dto;

import com.ctsi.sddx.bestpay.sdk.CommVairs;

import java.io.Serializable;

public class SplitDelayedResponse implements Serializable {

    private String merchantNo;

    private String tradeNo;

    private Long tradeAmt;

    private String outTradeNo;

    private CommVairs.TradeStatus tradeStatus;

    public SplitDelayedResponse() {
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Long getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(Long tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public CommVairs.TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(CommVairs.TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }
}
