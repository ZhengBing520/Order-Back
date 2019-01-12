package com.zb.service.impl;

import com.zb.common.Constant;
import com.zb.dao.CommissionDao;
import com.zb.dto.CommissionDto;
import com.zb.entity.Commission;
import com.zb.service.CommissionService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by bzheng on 2019/1/6.
 */
@Service
public class CommissionServiceImpl extends BaseServiceImpl<CommissionDto, Commission, CommissionDao>  implements CommissionService {


    /**
     *  初始化佣金规则
     * @param businessId
     */
    @Override
    public int init(Integer businessId) {
        Assert.notNull(businessId, "商家id不能为空");
        // 获取默认配置
        List<Commission> list = dao.selectListBybusinessId(Constant.DEFAULT_COMMISSION_BUSINESS_ID);
        // 生成默认配置
        if (!ObjectUtils.isEmpty(list)) {
            list.forEach(commission -> {
                commission.setBusinessId(businessId);
            });
            return dao.init(list);
        }

        return 0;
    }

    @Override
    public int deleteByBusinessid(Integer businessId) {
        Assert.notNull(businessId, "商家id不能为空");
        return dao.deleteByBusinessid(businessId);
    }

    @Override
    public List<CommissionDto> selectCommissionListByBusinessId(Integer businessId) {
        List<CommissionDto> list = dao.selectCommissionListByBusinessId(businessId);
        if (Objects.isNull(list)) {
            list = new ArrayList<>();
        }
        return list;
    }
}
