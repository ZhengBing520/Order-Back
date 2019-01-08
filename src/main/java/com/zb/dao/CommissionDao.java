package com.zb.dao;

import com.zb.entity.Commission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface CommissionDao extends BaseDao<Commission> {

    /**
     * 通过商家id获取佣金配置信息
     * @param businessId
     * @return
     */
    List<Commission> selectListBybusinessId(@Param("businessId") Integer businessId);

    /**
     * 生成默认规则
     * @param list
     */
    int init(@Param("list") List<Commission> list);

    /**
     * 根据商家ID删除佣金规则
     * @param businessId
     * @return
     */
    int deleteByBusinessid(@Param("businessId") Integer businessId);
}
