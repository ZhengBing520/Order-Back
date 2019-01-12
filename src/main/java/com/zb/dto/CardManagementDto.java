package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by bzheng on 2019/1/9.
 * 卡号信息表
 */
public class CardManagementDto extends BaseDto{

    /**
     * 卡号
     */
    @ApiModelProperty("卡号")
    private String cardNum;

    @ApiModelProperty("卡号信息")
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
