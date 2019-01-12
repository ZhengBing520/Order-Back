package com.zb.service.impl;

import com.zb.dao.DetailDao;
import com.zb.dto.DetailDto;
import com.zb.entity.Detail;
import com.zb.service.DetailService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by bzheng on 2019/1/10.
 */
@Service
public class DetailServiceImpl extends BaseServiceImpl<DetailDto, Detail, DetailDao> implements DetailService {

    /**
     * 根据商家id 和时间删除明细
     * @param businessId
     * @param nextDay
     */
    @Override
    public Boolean deleteByBusinessIdAndDate(Integer businessId, Date nextDay) {
        int i = dao.deleteByBusinessIdAndDate(businessId, nextDay);
        return i > 0;
    }
}
