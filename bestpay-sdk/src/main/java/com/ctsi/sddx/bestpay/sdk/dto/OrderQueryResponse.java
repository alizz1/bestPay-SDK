package com.ctsi.sddx.bestpay.sdk.dto;

import com.ctsi.sddx.bestpay.sdk.CommVairs;

import java.io.Serializable;

public class OrderQueryResponse implements Serializable {

    private String outTradeNo;

    private String tradeNo;

    private String tradeAmt;

    private String payAmt;

    private String discountAmt;

    private CommVairs.TradeStatus tradeStatus;

    private String merchantNo;

    private String buyerLogonId;

    private String payFinishedDate;

    private String bankRequestNo;

    private String bankCode;

    private String perEntFlag;

    private CommVairs.PayTool payTool;

    private String remark;

    private String resultCode;

    private String resultMsg;

    public OrderQueryResponse() {
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

    public String getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(String tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public String getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }

    public String getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(String discountAmt) {
        this.discountAmt = discountAmt;
    }

    public CommVairs.TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(CommVairs.TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getPayFinishedDate() {
        return payFinishedDate;
    }

    public void setPayFinishedDate(String payFinishedDate) {
        this.payFinishedDate = payFinishedDate;
    }

    public String getBankRequestNo() {
        return bankRequestNo;
    }

    public void setBankRequestNo(String bankRequestNo) {
        this.bankRequestNo = bankRequestNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPerEntFlag() {
        return perEntFlag;
    }

    public void setPerEntFlag(String perEntFlag) {
        this.perEntFlag = perEntFlag;
    }

    public CommVairs.PayTool getPayTool() {
        return payTool;
    }

    public void setPayTool(CommVairs.PayTool payTool) {
        this.payTool = payTool;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
