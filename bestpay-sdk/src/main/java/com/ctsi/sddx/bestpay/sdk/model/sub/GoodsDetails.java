package com.ctsi.sddx.bestpay.sdk.model.sub;

import java.io.Serializable;

public class GoodsDetails implements Serializable {

    private String id;

    private String name;

    private Long quantity;

    private Long unitPrice;

    public GoodsDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
