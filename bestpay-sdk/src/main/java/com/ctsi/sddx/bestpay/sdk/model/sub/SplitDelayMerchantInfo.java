package com.ctsi.sddx.bestpay.sdk.model.sub;

import java.io.Serializable;

public class SplitDelayMerchantInfo implements Serializable {

    private String merchantNo;

    private Long amount;

    private String memo;

    public SplitDelayMerchantInfo() {
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
