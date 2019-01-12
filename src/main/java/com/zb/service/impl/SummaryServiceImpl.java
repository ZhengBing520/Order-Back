package com.zb.service.impl;

import com.zb.dao.SummaryDao;
import com.zb.dto.SummaryDto;
import com.zb.entity.Summary;
import com.zb.request.AccountCollectRequest;
import com.zb.service.SummaryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bzheng on 2019/1/10.
 */
@Service
public class SummaryServiceImpl extends BaseServiceImpl<SummaryDto, Summary, SummaryDao> implements SummaryService {

    @Override
    public List<SummaryDto> selectSummary(AccountCollectRequest accountCollectRequest) {

        return dao.selectSummary(accountCollectRequest);
    }

    @Override
    public void createSummary() {

    }
}
