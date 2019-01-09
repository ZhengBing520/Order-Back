package com.zb.dto;

/**
 * Created by bzheng on 2019/1/9.
 */
public class CardManagementDto extends BaseDto{

    /**
     * 卡号
     */
    private String cardid;

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
