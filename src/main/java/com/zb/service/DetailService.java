package com.zb.service;

import com.zb.dto.DetailDto;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by bzheng on 2019/1/10.
 */
@Service
public interface DetailService extends BaseService<DetailDto> {

    /**
     * 根据商家id 和时间删除明细
     * @param businessId
     * @param nextDay
     */
    Boolean deleteByBusinessIdAndDate(Integer businessId, Date nextDay);
}
