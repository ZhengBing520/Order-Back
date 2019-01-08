package com.zb.dao;

import com.zb.dto.BusinessDto;
import com.zb.entity.Business;
import com.zb.entity.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by bzheng on 2019/1/6.
 * 商家dao
 */
public interface BusinessDao extends BaseDao<Business> {

    /**
     * 通过商家名称找商家信息
     * @param businessName
     * @return
     */
    Business selectByName(@Param("businessName") String businessName);

    /**
     * 检查中文名称唯一性
     *
     * @param businessName
     * @param id
     * @return
     */
    int selectCountByModelName(@Param("businessName") String businessName, @Param("excludeId") Integer id);

    /**
     * 分页查询商家信息
     * @param businessDto
     * @return
     */
    List<BusinessDto> queryPageableData(BusinessDto businessDto);
}
