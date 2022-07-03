package com.ctsi.sddx.bestpay.sdk;

import java.util.Locale;

public class CommVairs {


    /**
     * 延迟分账确认 or 取消
     */
    public enum ConfirmType {
        SUCCESS,
        CANCEL;

        @Override
        public String toString() {
            return super.toString().toUpperCase(Locale.ROOT);
        }
    }

    /**
     * 交易状态
     */
    public enum TradeStatus {
        /**
         * 交易成功
         */
        SUCCESS,
        /**
         * 交易失败
         */
        FAIL,
        /**
         * 未支付
         */
        NOTPAY;

        @Override
        public String toString() {
            return super.toString().toUpperCase(Locale.ROOT);
        }
    }

    public enum PayTool {
        BANKPAY,    //网银支付
        BESTPAY,    //翼支付
        ALIPAY,     //支付宝
        WECHAT,     //微信
        CREDITPAY;  //白条


        @Override
        public String toString() {
            return super.toString().toUpperCase(Locale.ROOT);
        }
    }

    public enum PayType {
        BESTPAY,
        WECHAT,
        ALIPAY,
        WEBCASHIER,
        MOBILECASHIER;

        @Override
        public String toString() {
            return super.toString().toUpperCase(Locale.ROOT);
        }
    }

    public enum ProductType {
        SW("1", "实物商品"),
        XN("2", "虚拟商品"),
        SWXN("3", "实物+虚拟");

        private final String val;
        private final String desc;

        ProductType(String val, String desc) {
            this.val = val;
            this.desc = desc;
        }

        public String getVal() {
            return val;
        }

        public String getDesc() {
            return desc;
        }

        public String toString() {
            return getVal();
        }
    }

    public enum ServiceIdentify {
        JYK("10000000", "加油卡"),
        XFSC("10000001", "消费商城"),
        BXFW("10000002", "保险服务"),
        WLFW("10000003", "物流服务"),
        DFCZ("10000004", "党费充值"),
        HFCZ("MOBILE _RECHARGE", "话费充值");

        private final String val;
        private final String desc;

        ServiceIdentify(String val, String desc) {
            this.val = val;
            this.desc = desc;
        }

        public String getVal() {
            return val;
        }

        public String getDesc() {
            return desc;
        }

        public String toString() {
            return getVal().toUpperCase();
        }
    }

    public enum PaySence {
        WEBCASHIER,    //PC版企业收银台
        MOBILECASHIER, //移动版企业收银台
        SMALLPAY,      // 小程序（线上）
        JSAPI,         // 公众号（线上）
        NATIVE,        // 订单二维码（线上）
        APP,           // app支付（线上）
        MWEB,          // h5支付（线上）
        SMALLPAYOUT;   //小程序外置支付

        @Override
        public String toString() {
            return super.toString().toUpperCase();
        }
    }

}
