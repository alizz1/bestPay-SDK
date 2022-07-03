package com.ctsi.sddx.bestpay.sdk.dto;

import java.io.Serializable;


public class InnerResponse<T> implements Serializable {

    private boolean success;

    private T result;

    private String errorCode;

    private String errorMsg;

    private String sign;

    public InnerResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public InnerResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getResult() {
        return result;
    }

    public InnerResponse<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public InnerResponse setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public InnerResponse setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public InnerResponse setSign(String sign) {
        this.sign = sign;
        return this;
    }
}
