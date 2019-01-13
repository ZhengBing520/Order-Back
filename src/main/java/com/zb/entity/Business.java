package com.zb.entity;

/**
 * Created by bzheng on 2019/1/6.
 * 商家表
 */
public class Business extends BaseEntity{

    /**
     * 商家名称
     */
    private String name;

    /**
     * 卡号ID
     */
    private Integer cardId;

    /**
     * 介绍人ID
     */
    private Integer referrerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(Integer referrerId) {
        this.referrerId = referrerId;
    }
}
