package com.zb.dto;

import com.zb.entity.BaseEntity;

/**
 * Created by bzheng on 2019/1/9.
 */
public class ReferrerDto extends BaseDto {

    /**
     * 介绍人姓名
     */
    private String nameReferrer;

    public String getNameReferrer() {
        return nameReferrer;
    }

    public void setNameReferrer(String nameReferrer) {
        this.nameReferrer = nameReferrer;
    }
}
