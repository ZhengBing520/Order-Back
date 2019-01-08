package com.zb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zb.dao.BaseDao;
import com.zb.dto.BaseDto;
import com.zb.entity.BaseEntity;
import com.zb.model.PageableData;
import com.zb.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by bzheng on 2018/3/14.
 */

public abstract class BaseServiceImpl<D extends BaseDto, E extends BaseEntity, DAO extends BaseDao<E>> implements BaseService<D> {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    DAO dao;

    Class<D> clazzD;

    Class<E> clazzE;

    @Override
    public PageableData<D> queryPageableData(Integer pageNum, Integer pageSize, D d) {
        PageableData<D> pageableData = PageableData.createModel();

        if (pageNum == null || pageNum < 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        // 开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<D> list = dao.queryPageableData(d);
        Page<D> userPage = (Page<D>) list;
        Long totalCount = userPage.getTotal();
        Integer currentPage = userPage.getPageNum();
        Integer pageSizeDb = userPage.getPageSize();
        pageableData = PageableData.createModel(totalCount, currentPage, pageSizeDb, list);
        return pageableData;
    }

    @SuppressWarnings("unchecked")
    public BaseServiceImpl() {
        Type type = this.getClass().getGenericSuperclass();
//        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
        Type[] trueTypes = ((ParameterizedType) type).getActualTypeArguments();
        this.clazzD = (Class<D>) trueTypes[0];
        this.clazzE = (Class<E>) trueTypes[1];
    }

    @Override
    public D get(Integer id) {
        Assert.notNull(id, "id 不能为空");
        E entity = dao.selectById(id);
        D dto = entityToDto(entity);
        return dto;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Assert.notNull(id, "Id 不能为空");
        int num = dao.delete(id);
        return num > 0;
    }

    @Override
    public Integer insert(D d) {
        E entity = dtoToEntity(d);
        dao.insert(entity);
        return entity.getId();

    }

    @Override
    public Boolean update(D d) {
        Assert.notNull(d, d.getClass().getSimpleName() + "不能为空");
        Assert.notNull(d.getId(), "Id 不能为空");
        E entity = dtoToEntity(d);
        entity.setUpdateTime(new Date());
        int update = dao.update(entity);
        return 0 < update;


    }

    public D entityToDto(E entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        D d = null;
        try {
            d = clazzD.newInstance();
        } catch (Exception e) {
            logger.error("entityToDto出错：" + e.getMessage(), e);
        }
        BeanUtils.copyProperties(entity, d);
        return d;
    }

    public E dtoToEntity(D d) {
        if (Objects.isNull(d)) {
            return null;
        }
        E entity = null;
        try {
            entity = clazzE.newInstance();
        } catch (Exception e) {
            logger.error("dtoToEntity出错：" + e.getMessage(), e);
        }
        BeanUtils.copyProperties(d, entity);
        return entity;
    }

}
