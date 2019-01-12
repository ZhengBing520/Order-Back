package com.zb.entity;

import java.math.BigDecimal;

/**
 * Created by bzheng on 2019/1/9.
 */
public class Referrer extends BaseEntity{

    /**
     * 介绍人姓名
     */
    private String nameReferrer;

    /**
     * 提成
     */
    private BigDecimal pushMoney;

    public String getNameReferrer() {
        return nameReferrer;
    }

    public void setNameReferrer(String nameReferrer) {
        this.nameReferrer = nameReferrer;
    }

    public BigDecimal getPushMoney() {
        return pushMoney;
    }

    public void setPushMoney(BigDecimal pushMoney) {
        this.pushMoney = pushMoney;
    }
}
