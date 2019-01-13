package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by bzheng on 2019/1/13.
 */
public class CardAccountCollectDto extends AccountCollectDto {

    @ApiModelProperty("卡号信息")
    private String cardName;

    @ApiModelProperty("卡号金额")
    private BigDecimal cardReceiptSum;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BigDecimal getCardReceiptSum() {
        return cardReceiptSum;
    }

    public void setCardReceiptSum(BigDecimal cardReceiptSum) {
        this.cardReceiptSum = cardReceiptSum;
    }
}
