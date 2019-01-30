package com.zb.param;

import java.util.Date;

/**
 * Created by bzheng on 2019/1/30.
 */
public class TaskParam {

    /**
     * 商家id
     */
    private Integer businessId;

    /**
     * 导入任务用户ID
     */
    private Integer createId;

    /**
     * 日期
     */
    private Date dateTask;

    public TaskParam(Integer businessId, Integer createId, Date dateTask) {
        this.businessId = businessId;
        this.createId = createId;
        this.dateTask = dateTask;
    }

    public TaskParam() {
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getDateTask() {
        return dateTask;
    }

    public void setDateTask(Date dateTask) {
        this.dateTask = dateTask;
    }
}
