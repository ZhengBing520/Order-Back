package com.zb.exception;

/**
 * Created by bzheng on 2019/1/30.
 * 未登录异常
 */
public class UnauthenticatedException extends RuntimeException{

    public UnauthenticatedException(String msg) {
        super(msg);
    }
}
