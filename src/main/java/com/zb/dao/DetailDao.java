package com.zb.dao;

import com.zb.dto.*;
import com.zb.entity.Detail;
import com.zb.request.AccountCollectRequest;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/1/10.
 */
public interface DetailDao extends BaseDao<Detail> {

    /**
     * 获取每日卡号收款汇总
     * @param accountCollectRequest
     * @return
     */
    List<CardAccountCollectDto> getCardCollect(AccountCollectRequest accountCollectRequest);

    /**
     * 获取每日介绍人收款汇总
     * @param accountCollectRequest
     * @return
     */
    List<ReferrerAccountCollectDto> getReferrerCollect(AccountCollectRequest accountCollectRequest);

    /**
     * 根据商家id和时间删除明细
     * @param businessId
     * @param dateDetail
     * @return
     */
    int deleteByBusinessIdAndDate(@Param("businessId") Integer businessId, @Param("dateDetail") Date dateDetail);

    /**
     * 根据时间统计总量
     * @param dateDetail
     * @return
     */
    DetailStatisticsDto detailStatisticsByDate(@Param("dateDetail") Date dateDetail);

}
