package com.zb.dto;

import com.zb.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by bzheng on 2019/1/9.
 */
public class ReferrerDto extends BaseDto {

    /**
     *
     */
    @ApiModelProperty("介绍人姓名")
    private String nameReferrer;

    /**
     *
     */
    @ApiModelProperty("提成")
    private BigDecimal pushMoney;

    public String getNameReferrer() {
        return nameReferrer;
    }

    public void setNameReferrer(String nameReferrer) {
        this.nameReferrer = nameReferrer;
    }

    public BigDecimal getPushMoney() {
        return pushMoney;
    }

    public void setPushMoney(BigDecimal pushMoney) {
        this.pushMoney = pushMoney;
    }
}
