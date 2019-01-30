package com.zb.common;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface Constant {

    /**
     * 默认佣金对应的商家ID
     */
    Integer DEFAULT_COMMISSION_BUSINESS_ID = 0;

    /**
     * token属性
     */
    String X_Auth_Token = "X-Auth-Token";

    /**
     * 默认密码
     */
    String DEFAULT_PWD = "a123456";

    /**
     * 用户类型，0：普通用户，1：管理员
     */
    interface UserType {

        int GENERAL = 0;

        int ADMINISTRATOR = 1;
    }
}
