package com.ctsi.sddx.bestpay.sdk.dto;

import java.io.Serializable;

public class SplitDelayQueryResponse implements Serializable {

    private String outTradeNo;

    private String tradeNo;

    private Long tradeAmt;

    private String tradeStatus;

    private String reason;

    private String resultCode;

    private String resultMsg;

    public SplitDelayQueryResponse() {
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
