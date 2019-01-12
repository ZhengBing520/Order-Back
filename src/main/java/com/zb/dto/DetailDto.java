package com.zb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zb.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by bzheng on 2019/1/10.
 */
public class DetailDto extends BaseDto {

     
    @ApiModelProperty("商家ID")
    private Integer businessId;

    @ApiModelProperty("商家")
    private String businessName;

    /**
     * 
     */
    @ApiModelProperty("日期")
    private Date dateDetail;

    /**
     * 
     */
    @ApiModelProperty("总单(商家任务表行数统计)")
    private Integer billTotal;

    /**
     * 
     */
    @ApiModelProperty("应收(商家任务表中件数*（总价+佣金）)")
    private BigDecimal receivable;

    /**
     * 
     */
    @ApiModelProperty("放(商家任务表中件数*（总价+成本佣金）)")
    private BigDecimal put;

    /**
     * 
     */
    @ApiModelProperty("实收")
    private BigDecimal receipt;

    /**
     * 
     */
    @ApiModelProperty("余(应收-放)")
    private BigDecimal residue;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Date getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(Date dateDetail) {
        this.dateDetail = dateDetail;
    }

    public Integer getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(Integer billTotal) {
        this.billTotal = billTotal;
    }

    public BigDecimal getReceivable() {
        return receivable;
    }

    public void setReceivable(BigDecimal receivable) {
        this.receivable = receivable;
    }

    public BigDecimal getPut() {
        return put;
    }

    public void setPut(BigDecimal put) {
        this.put = put;
    }

    public BigDecimal getReceipt() {
        return receipt;
    }

    public void setReceipt(BigDecimal receipt) {
        this.receipt = receipt;
    }

    public BigDecimal getResidue() {
        return residue;
    }

    public void setResidue(BigDecimal residue) {
        this.residue = residue;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
