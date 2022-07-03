package com.ctsi.sddx.bestpay.sdk.model;

public class BestPayRefundQueryModel extends BestPayCommonModel<BestPayRefundQueryModel> {


    private String merchantNo;

    private String outRefundNo;

    public BestPayRefundQueryModel() {
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    @Override
    public BestPayRefundQueryModel build() {
        return null;
    }
}
