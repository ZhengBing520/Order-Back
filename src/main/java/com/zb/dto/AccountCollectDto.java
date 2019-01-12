package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by bzheng on 2019/1/12.
 * 账户汇总--每日
 */
public class AccountCollectDto implements Serializable {

    @ApiModelProperty("卡号信息")
    private String cardName;

    @ApiModelProperty("介绍人")
    private String referrerName;

    @ApiModelProperty("金额")
    private BigDecimal receiptSum;

    @ApiModelProperty("日期")
    private Date dateDetail;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BigDecimal getReceiptSum() {
        return receiptSum;
    }

    public void setReceiptSum(BigDecimal receiptSum) {
        this.receiptSum = receiptSum;
    }

    public Date getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(Date dateDetail) {
        this.dateDetail = dateDetail;
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }
}
