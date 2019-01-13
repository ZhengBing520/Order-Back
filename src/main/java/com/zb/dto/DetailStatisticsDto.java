package com.zb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by bzheng on 2019/1/13.
 * 每日明细统计
 */
public class DetailStatisticsDto {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("日期")
    private Date dateDetail;

    /**
     *
     */
    @ApiModelProperty("总单(商家任务表行数统计)和")
    private Integer billTotalSum;

    /**
     *
     */
    @ApiModelProperty("应收(商家任务表中件数*（总价+佣金）)和")
    private BigDecimal receivableSum;

    /**
     *
     */
    @ApiModelProperty("放(商家任务表中件数*（总价+成本佣金）)和")
    private BigDecimal putSum;

    /**
     *
     */
    @ApiModelProperty("实收和")
    private BigDecimal receiptSum;

    /**
     *
     */
    @ApiModelProperty("余(应收-放)和")
    private BigDecimal residueSum;

    public Date getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(Date dateDetail) {
        this.dateDetail = dateDetail;
    }

    public Integer getBillTotalSum() {
        return billTotalSum;
    }

    public void setBillTotalSum(Integer billTotalSum) {
        this.billTotalSum = billTotalSum;
    }

    public BigDecimal getReceivableSum() {
        return receivableSum;
    }

    public void setReceivableSum(BigDecimal receivableSum) {
        this.receivableSum = receivableSum;
    }

    public BigDecimal getPutSum() {
        return putSum;
    }

    public void setPutSum(BigDecimal putSum) {
        this.putSum = putSum;
    }

    public BigDecimal getReceiptSum() {
        return receiptSum;
    }

    public void setReceiptSum(BigDecimal receiptSum) {
        this.receiptSum = receiptSum;
    }

    public BigDecimal getResidueSum() {
        return residueSum;
    }

    public void setResidueSum(BigDecimal residueSum) {
        this.residueSum = residueSum;
    }
}
