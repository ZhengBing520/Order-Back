package com.zb.request;

import com.zb.dto.TaskDto;
import com.zb.entity.Task;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by bzheng on 2019/1/6.
 */
public class TaskRequest {

    /**
     * 商家名称
     */
    @ApiModelProperty("商家名称")
    private String businessName;

    /**
     * 商家任务
     */
    private List<Task> taskList;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
