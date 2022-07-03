package com.ctsi.sddx.bestpay.sdk.dto;

import java.io.Serializable;

public class RefundResponse implements Serializable {
    /**
     * 退款交易订单号
     */
    private String tradeNo;
    /**
     *
     */
    private Long refundAmt;
    /**
     *
     */
    private String outTradeNo;
    /**
     * 商户系统内部的退款单号
     */
    private String outRefundNo;
    /**
     *
     */
    private String refundStatus;
    /**
     * 如非空,为交易标识
     */
    private String resultCode;
    /**
     * 如非空,为错误原因
     */
    private String resultMsg;

    public RefundResponse() {
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public RefundResponse setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    public Long getRefundAmt() {
        return refundAmt;
    }

    public RefundResponse setRefundAmt(Long refundAmt) {
        this.refundAmt = refundAmt;
        return this;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public RefundResponse setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public RefundResponse setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
        return this;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public RefundResponse setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public RefundResponse setResultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public RefundResponse setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
        return this;
    }
}
