package com.zb.entity;

/**
 * Created by bzheng on 2019/1/9.
 */
public class CardManagement extends BaseEntity{

    /**
     * 卡号
     */
    private String cardNum;

    /**
     * 卡号信息
     */
    private String cardName;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
