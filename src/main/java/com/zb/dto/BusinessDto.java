package com.zb.dto;

/**
 * Created by bzheng on 2019/1/6.
 * 商家表
 */
public class BusinessDto extends BaseDto{

    /**
     * 商家名称
     */
    private String name;

    /**
     * 卡号ID
     */
    private Integer cardId;

    /**
     * 卡号信息
     */
    private String cardNum;

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

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
