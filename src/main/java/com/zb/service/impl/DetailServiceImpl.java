package com.zb.service.impl;

import com.zb.dao.DetailDao;
import com.zb.dto.AccountCollectDto;
import com.zb.dto.DetailDto;
import com.zb.entity.Detail;
import com.zb.request.AccountCollectRequest;
import com.zb.service.DetailService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    /**
     * 获取每日卡号收款汇总
     * @param accountCollectRequest
     * @return
     */
    @Override
    public List<AccountCollectDto> getCardCollect(AccountCollectRequest accountCollectRequest) {
        return dao.getCardCollect(accountCollectRequest);
    }

    /**
     * 获取每日介绍人收款汇总
     * @param accountCollectRequest
     * @return
     */
    @Override
    public List<AccountCollectDto> getReferrerCollect(AccountCollectRequest accountCollectRequest) {
        return dao.getReferrerCollect(accountCollectRequest);
    }
}
