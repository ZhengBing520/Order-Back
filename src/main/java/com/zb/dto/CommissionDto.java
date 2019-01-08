package com.zb.dto;

import java.math.BigDecimal;

/**
 * Created by bzheng on 2019/1/6.
 * 佣金表
 */
public class CommissionDto extends BaseDto{

    /**
     * 商家ID
     */
    private Integer businessId;

    /**
     * 商家名称
     */
    private String businessName;

    /**
     * 价格区间中的最小值
     */
    private Integer priceMin;

    /**
     * 价格区间中的最大值
     */
    private Integer priceMax;

    /**
     * 佣金
     */
    private BigDecimal commission;

    /**
     * 成本佣金
     */
    private BigDecimal commissionCost;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Integer priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Integer priceMax) {
        this.priceMax = priceMax;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getCommissionCost() {
        return commissionCost;
    }

    public void setCommissionCost(BigDecimal commissionCost) {
        this.commissionCost = commissionCost;
    }
}
