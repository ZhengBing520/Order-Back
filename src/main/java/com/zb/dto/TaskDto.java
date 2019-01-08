package com.zb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zb.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by bzheng on 2019/1/6.
 * 任务表
 */
public class TaskDto extends BaseDto {

    /**
     *
     */
    @ApiModelProperty("商家ID")
    private Integer businessId;

    /**
     *
     */
    @ApiModelProperty("商家名称")
    private String businessName;

    /**
     *
     */
    @ApiModelProperty("任务日期")
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh_CN", timezone = "GMT+8")
    private Date dateTask;

    /**
     *
     */
    @ApiModelProperty("任务名称")
    private String nameTask;

    /**
     *
     */
    @ApiModelProperty("关键词")
    private String keywords;

    /**
     *
     */
    @ApiModelProperty("规格")
    private String spec;

    /**
     *
     */
    @ApiModelProperty("附加要求")
    private String require;

    /**
     *
     */
    @ApiModelProperty("做单时间")
    private Integer timeDoing;

    /**
     *
     */
    @ApiModelProperty("拍下件数")
    private Integer buyNum;

    /**
     *
     */
    @ApiModelProperty("单价")
    private BigDecimal price;

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

    public Date getDateTask() {
        return dateTask;
    }

    public void setDateTask(Date dateTask) {
        this.dateTask = dateTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public Integer getTimeDoing() {
        return timeDoing;
    }

    public void setTimeDoing(Integer timeDoing) {
        this.timeDoing = timeDoing;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }
}
