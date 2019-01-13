package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by bzheng on 2019/1/13.
 */
public class ReferrerAccountCollectDto extends AccountCollectDto {

    @ApiModelProperty("介绍人")
    private String referrerName;

    @ApiModelProperty("介绍人提成")
    private BigDecimal referrerReceiptSum;

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }

    public BigDecimal getReferrerReceiptSum() {
        return referrerReceiptSum;
    }

    public void setReferrerReceiptSum(BigDecimal referrerReceiptSum) {
        this.referrerReceiptSum = referrerReceiptSum;
    }
}
