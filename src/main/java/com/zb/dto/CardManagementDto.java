package com.zb.dto;

/**
 * Created by bzheng on 2019/1/9.
 * 卡号信息表
 */
public class CardManagementDto extends BaseDto{

    /**
     * 卡号
     */
    private String cardNum;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
