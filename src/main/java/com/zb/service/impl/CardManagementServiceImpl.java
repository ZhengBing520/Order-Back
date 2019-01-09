package com.zb.service.impl;

import com.zb.dao.CardManagementDao;
import com.zb.dto.CardManagementDto;
import com.zb.entity.CardManagement;
import com.zb.service.CardManagementService;
import org.springframework.stereotype.Service;

/**
 * Created by bzheng on 2019/1/9.
 */
@Service
public class CardManagementServiceImpl extends BaseServiceImpl<CardManagementDto, CardManagement, CardManagementDao> implements CardManagementService {
}
