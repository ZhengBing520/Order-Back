package com.zb.service;

import com.zb.dto.SummaryDto;
import com.zb.request.AccountCollectRequest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/1/10.
 * 汇总记录
 */
public interface SummaryService extends BaseService<SummaryDto> {

    /**
     * 查询汇总信息
     * @param accountCollectRequest
     * @return
     */
    List<SummaryDto> selectSummary(AccountCollectRequest accountCollectRequest);

    /**
     * 生成第二天汇总信息（导入完任务之后，界面点击生成按钮）
     * @return
     */
    Boolean initSummary();

    /**
     * 通过日期修改实收和差额
     * @param dateDetail 日期
     * @param subtract 需要减的数据大小
     * @return
     */
    Boolean updateReceiptByDate(Date dateDetail, BigDecimal subtract);
}
