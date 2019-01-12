package com.zb.service;

import com.zb.dto.SummaryDto;
import com.zb.request.AccountCollectRequest;

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
     * 每天同步汇总信息
     */
    void createSummary();

}
