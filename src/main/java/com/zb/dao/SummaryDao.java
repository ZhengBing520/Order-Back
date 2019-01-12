package com.zb.dao;

import com.zb.dto.SummaryDto;
import com.zb.entity.Summary;
import com.zb.request.AccountCollectRequest;
import org.apache.ibatis.annotations.Param;

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
}
