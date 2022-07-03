package com.ctsi.sddx.bestpay.sdk.model;

public class BestPayOrderQueryModel extends BestPayCommonModel<BestPayOrderQueryModel> {

    private String merchantNo;

    private String tradeDate;

    private String outTradeNo;

    public BestPayOrderQueryModel() {
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public BestPayOrderQueryModel build() {
        return null;
    }
}
