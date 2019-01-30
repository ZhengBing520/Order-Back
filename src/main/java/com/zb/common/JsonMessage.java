package com.zb.common;

/**
 * Created by bzheng on 2018/3/16.
 */

import io.swagger.annotations.ApiModelProperty;

/**
 * 接口返回对象
 *
 * @param <T> 返回数据泛型
 */
public class JsonMessage<T> {
    @ApiModelProperty(value = "返回码(0:正常 ,其它：异常)")
    private int code;

    @ApiModelProperty(value = "说明信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public JsonMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonMessage(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public JsonMessage(int code) {
        this.code = code;
    }

    public JsonMessage() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
