package com.zb.dao;

import com.zb.dto.SummaryDto;
import com.zb.entity.Summary;
import com.zb.request.AccountCollectRequest;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/1/10.
 */
public interface SummaryDao extends BaseDao<Summary> {

    /**
     * 获取每日汇总信息
     * @param accountCollectRequest
     * @return
     */
    List<SummaryDto> selectSummary(AccountCollectRequest accountCollectRequest);

    /**
     * 根据日期删除汇总信息
     * @param nextDay
     * @return
     */
    int deleteByDate(@Param("dateSummary") Date nextDay);

    /**
     * 通过日期修改实收和差额
     * @param dateSummary 日期
     * @param subtract 需要减的数据大小
     * @return
     */
    int updateReceiptByDate(@Param("dateSummary") Date dateSummary, @Param("subtract") BigDecimal subtract);
}
