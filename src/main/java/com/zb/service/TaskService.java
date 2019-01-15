package com.zb.service;

import com.zb.dto.TaskDto;
import com.zb.request.TaskRequest;

import java.util.Date;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface TaskService extends BaseService<TaskDto>{

    // 批量新增
    Boolean insertList(TaskRequest taskRequest);

    // 删除第二天任务
    Boolean deleteTasks(Integer businessId, Date nextDay);
}
