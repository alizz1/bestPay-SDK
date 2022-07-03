package com.ctsi.sddx.bestpay.sdk.model.sub;

import com.ctsi.sddx.bestpay.sdk.CommVairs;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder(value = {
        "boby", "goods_count", "product_type", "service_cardno", "service_identify", "subject"
})
public class RiskInfo implements Serializable {

    private CommVairs.ServiceIdentify service_identify;

    private String subject;

    private CommVairs.ProductType product_type;

    private String boby;

    private String goods_count;

    private String service_cardno;

    public RiskInfo() {
    }

    public CommVairs.ServiceIdentify getService_identify() {
        return service_identify;
    }

    public void setService_identify(CommVairs.ServiceIdentify service_identify) {
        this.service_identify = service_identify;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CommVairs.ProductType getProduct_type() {
        return product_type;
    }

    public void setProduct_type(CommVairs.ProductType product_type) {
        this.product_type = product_type;
    }

    public String getBoby() {
        return boby;
    }

    public void setBoby(String boby) {
        this.boby = boby;
    }

    public String getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(String goods_count) {
        this.goods_count = goods_count;
    }

    public String getService_cardno() {
        return service_cardno;
    }

    public void setService_cardno(String service_cardno) {
        this.service_cardno = service_cardno;
    }
}
