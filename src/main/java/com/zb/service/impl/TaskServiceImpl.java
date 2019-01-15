package com.zb.service.impl;

import com.zb.common.utils.DateUtil;
import com.zb.dao.TaskDao;
import com.zb.dto.BusinessDto;
import com.zb.dto.CommissionDto;
import com.zb.dto.DetailDto;
import com.zb.dto.TaskDto;
import com.zb.entity.Commission;
import com.zb.entity.Task;
import com.zb.request.TaskRequest;
import com.zb.service.BusinessService;
import com.zb.service.CommissionService;
import com.zb.service.DetailService;
import com.zb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
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

    @Autowired
    DetailService detailService;

    @Autowired
    CommissionService commissionService;

    /**
     * 批量插入任务(导入的任务是第二天的，重复导入就覆盖)
     *
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
        // 获取佣金规则
        List<CommissionDto> commissionDtoList = commissionService.selectCommissionListByBusinessId(id);
        Date nextDay = DateUtil.getBeginDayOfTomorrow();
        // 删除第二天任务
        deleteTasks(id, nextDay);
        // 总单数
        Integer billTotal = taskList.size();
        // 总价
        Double totalPrice = 0D;
        // 应收 总价 + 佣金
        BigDecimal receivableDecimal = new BigDecimal(0);
        // 放  总价 + 成本佣金
        BigDecimal putDecimal = new BigDecimal(0);

        for (Task task : taskList) {
            task.setBusinessId(id);
            // 第二天
            task.setDateTask(nextDay);

            // 佣金（通过总价找到佣金） 总价 = 单价 * 件数
            BigDecimal price = task.getPrice();
            Integer buyNum = task.getBuyNum();
            // 总价
            totalPrice += buyNum * price.doubleValue();

        }

        // 佣金
        CommissionDto commissionDto = getReceivableToTask(commissionDtoList, totalPrice);
        BigDecimal totalPriceDecimal = new BigDecimal(totalPrice);
        if (!Objects.isNull(commissionDto)) {
            receivableDecimal = totalPriceDecimal.add(commissionDto.getCommission());
            putDecimal = totalPriceDecimal.add(commissionDto.getCommissionCost());
        }
        // 余 (应收-放)
        BigDecimal residue = receivableDecimal.subtract(putDecimal);
        int i = dao.insertList(taskList);
        if (0 < i) {

            // 生成每日的明细
            DetailDto detailDto = new DetailDto();
            // 商家id
            detailDto.setBusinessId(id);
            // 日期
            detailDto.setDateDetail(nextDay);
            // 总单商家任务表行数统计
            detailDto.setBillTotal(billTotal);
            // 应收
            detailDto.setReceivable(receivableDecimal);
            // 放
            detailDto.setPut(putDecimal);
            // 余
            detailDto.setResidue(residue);
            // 实收默认等于应收
            detailDto.setReceipt(receivableDecimal);
            detailService.insert(detailDto);
        }
        return 0 < i;
    }

    /**
     * 删除任务级联删除明细
     *
     * @param id
     * @param nextDay
     * @return
     */
    @Override
    public Boolean deleteTasks(Integer id, Date nextDay) {
        int i = dao.deleteTasks(id, nextDay);
        if (i > 0) {
            // 删除明细
            detailService.deleteByBusinessIdAndDate(id, nextDay);
        }

        return i > 0;
    }

    /**
     * 通过单价找佣金规则
     *
     * @param commissionDtoList 佣金规则
     * @param price             单价
     * @return
     */
    private CommissionDto getReceivableToTask(List<CommissionDto> commissionDtoList, double price) {
        CommissionDto commissionDto = null;
        if (Objects.isNull(commissionDtoList)) {
            return commissionDto;
        }
        for (CommissionDto dto : commissionDtoList) {
            if (price - dto.getPriceMin() >= 0 && price - dto.getPriceMax() <= 0) {
                commissionDto = dto;
                break;
            } else {
                continue;
            }

        }
        return commissionDto;
    }
}
