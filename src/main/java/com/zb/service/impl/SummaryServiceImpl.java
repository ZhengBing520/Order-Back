package com.zb.service.impl;

import com.zb.dao.SummaryDao;
import com.zb.dto.SummaryDto;
import com.zb.entity.Summary;
import com.zb.service.SummaryService;
import org.springframework.stereotype.Service;

/**
 * Created by bzheng on 2019/1/10.
 */
@Service
public class SummaryServiceImpl extends BaseServiceImpl<SummaryDto, Summary, SummaryDao> implements SummaryService {
}
