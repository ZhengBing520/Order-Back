package com.zb.service;

import com.zb.dto.BaseDto;
import com.zb.model.PageableData;

/**
 * Created by bzheng on 2019/1/6.
 */
public interface BaseService<D extends BaseDto>{

    /**
     * 分页查找
     * @param pageNum
     * @param pageSize
     * @param d
     * @return
     */
    PageableData<D> queryPageableData(Integer pageNum, Integer pageSize, D d);

    // 通过ID获取数据
    D get(Integer id);

    // 删除数据
     Boolean deleteById(Integer id);

     // 新增
     Integer insert(D d);

     // 修改
     Boolean update(D d);

}
