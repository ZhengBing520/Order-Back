package com.zb.service.impl;

import com.zb.common.utils.DateUtil;
import com.zb.dao.TaskDao;
import com.zb.dto.BusinessDto;
import com.zb.dto.TaskDto;
import com.zb.entity.Task;
import com.zb.request.TaskRequest;
import com.zb.service.BusinessService;
import com.zb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by bzheng on 2019/1/6.
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl<TaskDto, Task, TaskDao> implements TaskService {

    @Autowired
    BusinessService businessService;

    /**
     * 批量插入任务(导入的任务是第二天的，重复导入就覆盖)
     * @param taskRequest
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertList(TaskRequest taskRequest) {
        // 通过商家名称找到商家id
        String businessName = taskRequest.getBusinessName();
        Assert.notNull(businessName, "商家名称不能为空");
        BusinessDto business = businessService.selectByName(businessName);
        if (Objects.isNull(business)) {
            // 新增商家
            business = new BusinessDto();
            business.setName(businessName);
            Integer insertId = businessService.insert(business);
            business.setId(insertId);
        }
        Integer id = business.getId();
        List<Task> taskList = taskRequest.getTaskList();
        if (ObjectUtils.isEmpty(taskList)) {
            throw new IllegalArgumentException("导入任务为空");
        }
        Date nextDay = DateUtil.getBeginDayOfTomorrow();
        // 删除第二天任务
        dao.deleteTasks(id, nextDay);
        taskList.forEach(task -> {
            task.setBusinessId(id);
            // 第二天
            task.setDateTask(nextDay);
        });
        int i = dao.insertList(taskList);
        if (0 < i) {
            // 生成每日的明细

        }
        return 0 < i;
    }
}
