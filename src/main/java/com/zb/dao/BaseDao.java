package com.zb.dao;

import com.zb.dto.BaseDto;
import com.zb.entity.BaseEntity;

import java.util.List;

/**
 * Created by bzheng on 2019/1/6.
 * 基础方法
 */
public interface BaseDao<E extends BaseEntity> {

    // 新增
    int insert(E e);

    // 查询
    E selectById(Integer id);

    // 修改
    int update(E e);

    // 删除
    int delete(Integer id);

    // 分页查询
    <D extends BaseDto> List<D> queryPageableData(D d);
}
