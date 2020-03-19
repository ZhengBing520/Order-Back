package com.zb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zb.common.utils.DateUtil;
import com.zb.dao.BusinessDao;
import com.zb.dto.BusinessDto;
import com.zb.entity.Business;
import com.zb.model.PageableData;
import com.zb.service.BusinessService;
import com.zb.service.CommissionService;
import com.zb.service.DetailService;
import com.zb.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by bzheng on 2019/1/6.
 */
@Service
public class BusinessServiceImpl extends BaseServiceImpl<BusinessDto, Business, BusinessDao> implements BusinessService {

    private final static Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    CommissionService commissionService;

    @Autowired
    TaskService taskService;

    @Autowired
    DetailService detailService;

    @Override
    @Transactional
    public Integer insert(BusinessDto businessDto) {
        // 判断名称唯一
        if (checkBusinessNameUnique(businessDto.getName(), null)) {
            throw new IllegalArgumentException("商家名称已存在");
        }
        Integer id = super.insert(businessDto);
        // 初始化佣金表
        commissionService.init(id);
        return id;
    }


    @Override
    public Boolean update(BusinessDto businessDto) {
        if (checkBusinessNameUnique(businessDto.getName(), businessDto.getId())) {
            throw new IllegalArgumentException("商家名称已存在");
        }

        return super.update(businessDto);
    }

    /**
     * 检查商家名称是否唯一
     * @param businessName 商家名称
     * @param excludeId 修改id
     * @return
     */
    public Boolean checkBusinessNameUnique(String businessName, Integer excludeId) {
        if (StringUtils.isEmpty(businessName)) {
            throw new IllegalArgumentException("商家名称不能为空");
        }
        int i = dao.selectCountByModelName(businessName, excludeId);
        return 0 < i;
    }

    @Override
    public BusinessDto selectByName(String businessName) {
        if (StringUtils.isEmpty(businessName)) {
            throw new IllegalArgumentException("商家名称为空");
        }
        Business business = dao.selectByName(businessName);
        if (Objects.isNull(business)) {
            return null;
        }
        return entityToDto(business);
    }

    @Override
    @Transactional
    public Boolean deleteById(Integer id) {
        Assert.notNull(id, "商家ID不能为空");
        Boolean flag = super.deleteById(id);
        Date nextDay = DateUtil.getBeginDayOfTomorrow();
        if (flag) {
            // 删除佣金规则
            commissionService.deleteByBusinessId(id);

            // 删除任务
            taskService.deleteTasks(null, id, nextDay);

        }
        return flag;
    }
}
