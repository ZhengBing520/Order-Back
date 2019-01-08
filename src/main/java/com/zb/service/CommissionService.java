package com.zb.service;

import com.zb.dto.CommissionDto;

/**
 * Created by bzheng on 2019/1/6.
 * 佣金表
 */
public interface CommissionService extends BaseService<CommissionDto>{

    /**
     *根据商家id初始化佣金规则
     */
    int init(Integer businessId);

    /**
     * 根据商家id删除佣金规则
     * @param businessId
     * @return
     */
    int deleteByBusinessid(Integer businessId);
}
