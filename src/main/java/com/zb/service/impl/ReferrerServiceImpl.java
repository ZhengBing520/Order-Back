package com.zb.service.impl;

import com.zb.dao.ReferrerDao;
import com.zb.dto.ReferrerDto;
import com.zb.entity.Referrer;
import com.zb.service.ReferrerService;
import org.springframework.stereotype.Service;

/**
 * Created by bzheng on 2019/1/9.
 */
@Service
public class ReferrerServiceImpl extends BaseServiceImpl<ReferrerDto, Referrer, ReferrerDao> implements ReferrerService {
}
