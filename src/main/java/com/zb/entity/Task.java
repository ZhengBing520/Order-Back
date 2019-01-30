package com.zb.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by bzheng on 2019/1/6.
 * 任务表
 */
public class Task extends BaseEntity {

    /**
     * 商家ID
     */
    private Integer businessId;

    /**
     * 任务日期
     */
    private Date dateTask;

    /**
     * 任务名称
     */
    private String nameTask;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 规格
     */
    private String spec;

    /**
     * 附加要求
     */
    private String require;

    /**
     * 做单时间
     */
    private Integer timeDoing;

    /**
     * 拍下件数
     */
    private Integer buyNum;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 导入任务用户ID
     */
    private Integer createId;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
}
