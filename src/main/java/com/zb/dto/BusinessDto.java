package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by bzheng on 2019/1/6.
 * 商家表
 */
public class BusinessDto extends BaseDto{

    /**
     *
     */
    @ApiModelProperty("商家名称")
    private String name;

    /**
     *
     */
    @ApiModelProperty("卡号ID")
    private Integer cardId;

    /**
     *
     */
    @ApiModelProperty("卡号信息")
    private String cardName;

    @ApiModelProperty("介绍人ID")
    private Integer referrerId;

    @ApiModelProperty("介绍人")
    private String referrerName;

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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(Integer referrerId) {
        this.referrerId = referrerId;
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }
}
