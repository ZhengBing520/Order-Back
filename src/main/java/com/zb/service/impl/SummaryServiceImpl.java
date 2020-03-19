package com.zb.service.impl;

import com.zb.common.utils.DateUtil;
import com.zb.dao.SummaryDao;
import com.zb.dto.CardAccountCollectDto;
import com.zb.dto.DetailStatisticsDto;
import com.zb.dto.ReferrerAccountCollectDto;
import com.zb.dto.SummaryDto;
import com.zb.entity.Summary;
import com.zb.model.PageableData;
import com.zb.request.AccountCollectRequest;
import com.zb.service.DetailService;
import com.zb.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by bzheng on 2019/1/10.
 */
@Service
public class SummaryServiceImpl extends BaseServiceImpl<SummaryDto, Summary, SummaryDao> implements SummaryService {

    @Autowired
    DetailService detailService;

    @Override
    public List<SummaryDto> selectSummary(AccountCollectRequest accountCollectRequest) {
        List<SummaryDto> summaryDtos = dao.selectSummary(accountCollectRequest);
        // 获取介绍人和卡号汇总数据
        summaryDtos = putAccountCollectDto(summaryDtos, accountCollectRequest);
        return summaryDtos;
    }

    /**
     * 设置卡号统计和介绍人提成数据
     * @param summaryDtos
     * @param accountCollectRequest
     * @return
     */
    private List<SummaryDto> putAccountCollectDto(List<SummaryDto> summaryDtos, AccountCollectRequest accountCollectRequest) {
        if (ObjectUtils.isEmpty(summaryDtos)) {
            return summaryDtos;
        }
        List<ReferrerAccountCollectDto> referrerCollect = detailService.getReferrerCollect(accountCollectRequest);
        List<CardAccountCollectDto> cardCollect = detailService.getCardCollect(accountCollectRequest);
        // 转换成map
        Map<Date, List<ReferrerAccountCollectDto>> referrerMap = null;
        Map<Date, List<CardAccountCollectDto>> cardMap = null;

        if (!Objects.isNull(referrerCollect)) {
            referrerMap = referrerCollect.stream().collect(Collectors.groupingBy(ReferrerAccountCollectDto::getDateDetail));
        }
        if (!Objects.isNull(cardCollect)) {
            cardMap = cardCollect.stream().collect(Collectors.groupingBy(CardAccountCollectDto::getDateDetail));
        }

        // 赋值
        for (SummaryDto summaryDto : summaryDtos) {
            if (!Objects.isNull(summaryDto.getDateSummary())) {
                if (!Objects.isNull(referrerMap) && !Objects.isNull(referrerMap.get(summaryDto.getDateSummary()))) {
                    // 设置数据
                    summaryDto.setReferrerAccountCollectDtos(referrerMap.get(summaryDto.getDateSummary()));
                }
            }
            if (!Objects.isNull(cardMap) && !Objects.isNull(cardMap.get(summaryDto.getDateSummary()))) {
                summaryDto.setCardAccountCollectDtos(cardMap.get(summaryDto.getDateSummary()));
            }
        }

        return summaryDtos;
    }

    @Override
    public PageableData<SummaryDto> queryPageableData(Integer pageNum, Integer pageSize, SummaryDto summaryDto) {
        PageableData<SummaryDto> summaryDtoPageableData = super.queryPageableData(pageNum, pageSize, summaryDto);
        List<SummaryDto> dataList = summaryDtoPageableData.getDataList();
        AccountCollectRequest accountCollectRequest = new AccountCollectRequest();
        if (!Objects.isNull(summaryDto)) {
            accountCollectRequest.setStartTime(summaryDto.getStartTime());
            accountCollectRequest.setEndTime(summaryDto.getEndTime());
        }

        dataList = putAccountCollectDto(dataList, accountCollectRequest);
        return summaryDtoPageableData;
    }

    @Override
    public Boolean initSummary() {
        // 先删除
        Date nextDay = DateUtil.getBeginDayOfTomorrow();
        dao.deleteByDate(nextDay);
        // 新增
        Summary summary = new Summary();
        summary.setDateSummary(nextDay);
        // 获取每日明细信息
        DetailStatisticsDto detailStatisticsDto = detailService.detailStatisticsByDate(nextDay);
        if (Objects.isNull(detailStatisticsDto)) {
            return Boolean.FALSE;
        }
        summary.setBillSum(detailStatisticsDto.getBillTotalSum());
        summary.setReceivableSum(detailStatisticsDto.getReceivableSum());// 总收
        summary.setPutSum(detailStatisticsDto.getPutSum());// 总放
        summary.setResidue(detailStatisticsDto.getResidueSum());// 余

        // 其他人提成
        AccountCollectRequest accountCollectRequest = new AccountCollectRequest();
        accountCollectRequest.setStartTime(nextDay);
        accountCollectRequest.setEndTime(nextDay);
        List<ReferrerAccountCollectDto> referrerCollect = detailService.getReferrerCollect(accountCollectRequest);
        BigDecimal residueLast = null;
        if (!Objects.isNull(referrerCollect)) {
            residueLast = referrerCollect.stream().map(ReferrerAccountCollectDto::getReferrerReceiptSum).reduce(BigDecimal.ZERO, BigDecimal::add);
        } else {
            residueLast = new BigDecimal(0);
        }
        summary.setResidueLast(summary.getResidue().subtract(residueLast)); // 剩余（实际最终到手利润，余-其他人提成）
        summary.setReceipt(detailStatisticsDto.getReceiptSum());// 实收
        summary.setBalance(summary.getReceivableSum().subtract(summary.getReceipt()));// 差额（总收-实际收款）
        int insert = dao.insert(summary);
        return insert > 0;
    }

    @Override
    public Boolean updateReceiptByDate(Date dateDetail, BigDecimal subtract) {
        int i = dao.updateReceiptByDate(dateDetail, subtract);
        return i > 0;
    }

}
