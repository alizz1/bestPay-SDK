package com.ctsi.sddx.bestpay.sdk.model;

import com.ctsi.sddx.bestpay.sdk.CommVairs;
import com.ctsi.sddx.bestpay.sdk.model.sub.GoodsDetails;
import com.ctsi.sddx.bestpay.sdk.model.sub.RiskInfo;
import com.ctsi.sddx.bestpay.sdk.model.sub.TradeFrontInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 翼支付创建订单
 *
 * @author zxqy
 */
public class BestPayTradeCreateModel extends BestPayCommonModel<BestPayTradeCreateModel> {

    //商户号
    private String merchantNo;
    //商户订单号
    private String outTradeNo;
    //订单超时时间
    private Long timeOut;
    //交易金额
    private Long tradeAmt;
    //操作人
    private String operator;
    //支付平台类型
    private CommVairs.PayType tradeType;
    //订单主题
    private String subject;
    //请求时间
    private final String requestDate;
    //回调通知地址
    private String notifyUrl;
    //商品信息
    private String goodsInfo;
    //风控信息
    private List<RiskInfo> riskInfo;
    //请求IP
    private String reqIp;
    //交易前端信息
    private TradeFrontInfo tradeFrontInfo;
    //交易场景
    private CommVairs.PaySence tradeScene;
    //应用ID
    private String appId;
    //商品详情
    private List<GoodsDetails> goodsDetails;
    //用户ID
    private String userCode;
    //备注信息
    private String remark;
    //产品模式
    private final String productMode = "DELAYED_SPLIT";
    //支付成功回调地址
    private String returnUrl;


    public BestPayTradeCreateModel() {
        this.requestDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public Long getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(Long tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public CommVairs.PayType getTradeType() {
        return tradeType;
    }

    public void setTradeType(CommVairs.PayType tradeType) {
        this.tradeType = tradeType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public List<RiskInfo> getRiskInfo() {
        return riskInfo;
    }

    public void setRiskInfo(List<RiskInfo> riskInfo) {
        this.riskInfo = riskInfo;
    }

    public TradeFrontInfo getTradeFrontInfo() {
        return tradeFrontInfo;
    }

    public void setTradeFrontInfo(TradeFrontInfo tradeFrontInfo) {
        this.tradeFrontInfo = tradeFrontInfo;
    }

    public CommVairs.PaySence getTradeScene() {
        return tradeScene;
    }

    public void setTradeScene(CommVairs.PaySence tradeScene) {
        this.tradeScene = tradeScene;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<GoodsDetails> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetails> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProductMode() {
        return productMode;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    @Override
    public BestPayTradeCreateModel build() {
        return null;
    }
}
