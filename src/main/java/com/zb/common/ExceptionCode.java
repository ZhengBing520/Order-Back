package com.zb.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gongdezhi on 2017/2/14.
 */
public class ExceptionCode {

    //参数错误
    public static final int PARAM_ERROR_CODE = 10041000;
    public static final String PARAM_ERROR_MSG = "参数错误或缺少参数";

    //账号或密码错误
    public static final int LOGIN_ERROR_CODE = 10041001;
    public static final String LOGIN_ERROR_MSG = "账号或密码错误";

    //账号被禁用
    public static final int ACCOUNT_DISABLED_CODE = 10041002;
    public static final String ACCOUNT_DISABLED_MSG = "账号已禁用";

    //无访问权限
    public static final int UNAUTHORIZED_CODE = 10041003;
    public static final String UNAUTHORIZED_MSG = "无访问权限";

    //未登录
    public static final int NOT_LOGIN_CODE = 1004104;
    public static final String NOT_LOGIN_MSG = "未登录";

    //会话超时
    public static final int SESSION_TIMEOUT_CODE = 1004105;
    public static final String SESSION_TIMEOUT_MSG = "会话过期";

    //系统内部错误
    public static final int SYS_ERROR_CODE = 10041500;
    public static final String SYS_ERROR_MSG = "系统错误,请稍后再试";

    private static Map<Integer, String> messageMap = new ConcurrentHashMap<>();

    static {
        messageMap.put(PARAM_ERROR_CODE, PARAM_ERROR_MSG);
        messageMap.put(LOGIN_ERROR_CODE, LOGIN_ERROR_MSG);
        messageMap.put(ACCOUNT_DISABLED_CODE, ACCOUNT_DISABLED_MSG);
        messageMap.put(UNAUTHORIZED_CODE, UNAUTHORIZED_MSG);
        messageMap.put(NOT_LOGIN_CODE, NOT_LOGIN_MSG);
        messageMap.put(SESSION_TIMEOUT_CODE, SESSION_TIMEOUT_MSG);
        messageMap.put(SYS_ERROR_CODE, SYS_ERROR_MSG);

    }

    public static String getMessage(Integer code) {
        return messageMap.get(code);
    }

}
