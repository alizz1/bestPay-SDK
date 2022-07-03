package com.ctsi.sddx.bestpay.sdk.model;

/**
 * 翼支付退款请求体
 *
 * @author zxqy
 */
public class BestPayRefundModel extends BestPayCommonModel<BestPayRefundModel> {

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 商户订单号，原下单商户订单号
     */
    private String outTradeNo;
    /**
     * 交易日期，yyyy-MM-dd
     */
    private String tradeDate;
    /**
     * 退款单号，商户系统内部的退款单号
     */
    private String outRefundNo;
    /**
     * 退款金额，支持部分退款，需要退款的金额
     * 该金额不能大于订单金额，单位（分）
     */
    private Long refundAmt;
    /**
     * 退款原因
     */
    private String refundCause;
    /**
     * 受理终端唯一编号
     */
    private String terminalCode;
    /**
     * 受理终端唯一流水号
     */
    private String terminalNo;
    /**
     * 省、市、区请传实际中文字符，如不传值则对账文件不推送该字段。
     */
    private String provinceCode;
    /**
     * 省、市、区请传实际中文字符，如不传值则对账文件不推送该字段。
     */
    private String cityCode;
    /**
     * 省、市、区请传实际中文字符，如不传值则对账文件不推送该字段。
     */
    private String areaCode;
    /**
     * 营业厅编号
     */
    private String storeCode;
    /**
     * 营业厅名称
     */
    private String storeName;

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

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Long getRefundAmt() {
        return refundAmt;
    }

    public void setRefundAmt(Long refundAmt) {
        this.refundAmt = refundAmt;
    }

    public String getRefundCause() {
        return refundCause;
    }

    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause;
    }

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public BestPayRefundModel build() {

        return null;
    }
}
