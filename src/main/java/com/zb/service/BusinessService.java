package com.zb.service;

import com.zb.dto.BusinessDto;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface BusinessService extends BaseService<BusinessDto> {

    /**
     * 通过名称查找商家
     *
     * @param businessName
     * @return
     */
    BusinessDto selectByName(String businessName);

}
