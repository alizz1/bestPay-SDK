package com.ctsi.sddx.bestpay.sdk.dto;

import java.io.Serializable;

/**
 * 翼支付接口响应
 *
 * @author zxqy
 */
public class BestPayResult<T> implements Serializable {

    /**
     * 响应代码
     */
    private final String code;

    /**
     * 响应文本
     */
    private final String msg;
    /**
     * 是否请求成功
     */
    private final boolean success;
    /**
     * 响应数据
     */
    private final T data;

    private BestPayResult(String code, String msg, boolean success, T data) {
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public static <T> BestPayResult<T> success() {
        return new BestPayResult<>("200", "请求成功", true, null);
    }

    public static <T> BestPayResult<T> success(T data) {
        return new BestPayResult<>("200", "请求成功", true, data);
    }

    public static <T> BestPayResult<T> error(String code, String msg, T data) {
        return new BestPayResult<>(code, msg, false, data);
    }

    public static <T> BestPayResult<T> error(String code, String msg) {
        return new BestPayResult<>(code, msg, false, null);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}
