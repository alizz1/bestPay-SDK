package com.ctsi.sddx.bestpay.sdk.dto;

import java.io.Serializable;

public class RefundQueryResponse implements Serializable {

    private String outTradeNo;

    private String tradeNo;

    private Long refundAmt;

    private String refundStatus;

    private String outRefundNo;

    private String resultCode;

    private String resultMsg;

    public RefundQueryResponse() {
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

    public Long getRefundAmt() {
        return refundAmt;
    }

    public void setRefundAmt(Long refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
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
