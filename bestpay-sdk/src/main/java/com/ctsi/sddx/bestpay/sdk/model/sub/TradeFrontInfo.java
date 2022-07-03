package com.ctsi.sddx.bestpay.sdk.model.sub;

import java.io.Serializable;
import java.util.Locale;

public class TradeFrontInfo implements Serializable {

    private PayTermType payerTermType;
    private String payerTermCode;
    private String payerTermIP;
    private String payerTermMAC;
    private String payerTermWIFIMAC;
    private String payerTermIMEI;
    private String payerTermIMSI;
    private String payerTermSIMmobnum;
    private String payerTermICCID;
    private String payerTermGPS;
    private String payerScanType;
    private PayTermType payeeTermType;
    private String payeeTermCode;

    public TradeFrontInfo() {
    }

    public PayTermType getPayerTermType() {
        return payerTermType;
    }

    public void setPayerTermType(PayTermType payerTermType) {
        this.payerTermType = payerTermType;
    }

    public String getPayerTermCode() {
        return payerTermCode;
    }

    public void setPayerTermCode(String payerTermCode) {
        this.payerTermCode = payerTermCode;
    }

    public String getPayerTermIP() {
        return payerTermIP;
    }

    public void setPayerTermIP(String payerTermIP) {
        this.payerTermIP = payerTermIP;
    }

    public String getPayerTermMAC() {
        return payerTermMAC;
    }

    public void setPayerTermMAC(String payerTermMAC) {
        this.payerTermMAC = payerTermMAC;
    }

    public String getPayerTermWIFIMAC() {
        return payerTermWIFIMAC;
    }

    public void setPayerTermWIFIMAC(String payerTermWIFIMAC) {
        this.payerTermWIFIMAC = payerTermWIFIMAC;
    }

    public String getPayerTermIMEI() {
        return payerTermIMEI;
    }

    public void setPayerTermIMEI(String payerTermIMEI) {
        this.payerTermIMEI = payerTermIMEI;
    }

    public String getPayerTermIMSI() {
        return payerTermIMSI;
    }

    public void setPayerTermIMSI(String payerTermIMSI) {
        this.payerTermIMSI = payerTermIMSI;
    }

    public String getPayerTermSIMmobnum() {
        return payerTermSIMmobnum;
    }

    public void setPayerTermSIMmobnum(String payerTermSIMmobnum) {
        this.payerTermSIMmobnum = payerTermSIMmobnum;
    }

    public String getPayerTermICCID() {
        return payerTermICCID;
    }

    public void setPayerTermICCID(String payerTermICCID) {
        this.payerTermICCID = payerTermICCID;
    }

    public String getPayerTermGPS() {
        return payerTermGPS;
    }

    public void setPayerTermGPS(String payerTermGPS) {
        this.payerTermGPS = payerTermGPS;
    }

    public String getPayerScanType() {
        return payerScanType;
    }

    public void setPayerScanType(String payerScanType) {
        this.payerScanType = payerScanType;
    }

    public PayTermType getPayeeTermType() {
        return payeeTermType;
    }

    public void setPayeeTermType(PayTermType payeeTermType) {
        this.payeeTermType = payeeTermType;
    }

    public String getPayeeTermCode() {
        return payeeTermCode;
    }

    public void setPayeeTermCode(String payeeTermCode) {
        this.payeeTermCode = payeeTermCode;
    }

    public static enum PayTermType {
        PC("电脑", "51"),
        MOBILE("手机", "52"),
        IPAD("平板", "53"),
        WEARABLEDEVICE("可穿戴设备", "54"),
        IPTV("数字电视", "55"),
        SCANCODE("条码支付受理终端", "56"),
        OTHER("其他", "99");

        private final String termName;
        private final String termCode;

        PayTermType(String termName, String termCode) {
            this.termName = termName;
            this.termCode = termCode;
        }

        public String getTermName() {
            return termName;
        }

        public String getTermCode() {
            return termCode;
        }

        @Override
        public String toString() {
            return getTermCode().toUpperCase(Locale.ROOT);
        }
    }
}
