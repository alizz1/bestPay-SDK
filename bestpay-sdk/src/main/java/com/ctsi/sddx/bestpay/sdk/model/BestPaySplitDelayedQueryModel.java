package com.ctsi.sddx.bestpay.sdk.model;

public class BestPaySplitDelayedQueryModel extends BestPayCommonModel<BestPaySplitDelayedQueryModel> {


    private String merchantNo;

    private String outTradeNo;

    private String tradeDate;

    public BestPaySplitDelayedQueryModel() {
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

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Override
    public BestPaySplitDelayedQueryModel build() {
        return null;
    }
}
