package com.zb.service.impl;

import com.zb.dao.DetailDao;
import com.zb.dto.*;
import com.zb.entity.Detail;
import com.zb.entity.Summary;
import com.zb.request.AccountCollectRequest;
import com.zb.service.DetailService;
import com.zb.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by bzheng on 2019/1/10.
 */
@Service
public class DetailServiceImpl extends BaseServiceImpl<DetailDto, Detail, DetailDao> implements DetailService {

    @Autowired
    SummaryService summaryService;

    /**
     * 根据商家id 和时间删除明细
     *
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
     *
     * @param accountCollectRequest
     * @return
     */
    @Override
    public List<CardAccountCollectDto> getCardCollect(AccountCollectRequest accountCollectRequest) {
        return dao.getCardCollect(accountCollectRequest);
    }

    /**
     * 获取每日介绍人收款汇总
     *
     * @param accountCollectRequest
     * @return
     */
    @Override
    public List<ReferrerAccountCollectDto> getReferrerCollect(AccountCollectRequest accountCollectRequest) {
        return dao.getReferrerCollect(accountCollectRequest);
    }

    /**
     * 每日数据汇总求和
     *
     * @param dateDetail
     * @return
     */
    @Override
    public DetailStatisticsDto detailStatisticsByDate(Date dateDetail) {
        return dao.detailStatisticsByDate(dateDetail);
    }

    @Override
    public Boolean update(DetailDto detailDto) {
        // 修改只允许修改实收
        Detail detail = dao.selectById(detailDto.getId());
        if (Objects.isNull(detail)) {
            return false;
        }
        BigDecimal receiptUpdate = detailDto.getReceipt() == null ? BigDecimal.ZERO : detailDto.getReceipt();
        BigDecimal receiptOld = detail.getReceipt() == null ? BigDecimal.ZERO : detail.getReceipt();
        BigDecimal subtract = receiptUpdate.subtract(receiptOld);
        // 判断当前是否需要修改总记录
        if (subtract.compareTo(BigDecimal.ZERO) != 0) {
            // 修改汇总实收数据
            summaryService.updateReceiptByDate(detail.getDateDetail(), subtract);
        }
        return super.update(detailDto);
    }
}
