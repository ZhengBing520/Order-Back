package com.zb.dao;

import com.zb.dto.CommissionDto;
import com.zb.entity.Commission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface CommissionDao extends BaseDao<Commission> {

    /**
     * 生成默认规则
     * @param list
     */
    int init(@Param("list") List<CommissionDto> list);

    /**
     * 根据商家ID删除佣金规则
     * @param businessId
     * @return
     */
    int deleteByBusinessid(@Param("businessId") Integer businessId);

    /**
     * 根据商家ID获取佣金规则
     * @param businessId
     * @return
     */
    List<CommissionDto> selectCommissionListByBusinessId(@Param("businessId") Integer businessId);
}
