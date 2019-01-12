package com.zb.service;

import com.zb.dto.AccountCollectDto;
import com.zb.dto.DetailDto;
import com.zb.request.AccountCollectRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    /**
     * 获取每日卡号收款汇总
     * @param accountCollectRequest
     * @return
     */
    List<AccountCollectDto> getCardCollect(AccountCollectRequest accountCollectRequest);

    /**
     * 获取每日介绍人收款汇总
     * @param accountCollectRequest
     * @return
     */
    List<AccountCollectDto> getReferrerCollect(AccountCollectRequest accountCollectRequest);
}
