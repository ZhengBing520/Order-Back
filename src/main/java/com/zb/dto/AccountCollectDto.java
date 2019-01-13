package com.zb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bzheng on 2019/1/12.
 * 账户汇总--每日
 */
public class AccountCollectDto implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("日期")
    private Date dateDetail;

    public Date getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(Date dateDetail) {
        this.dateDetail = dateDetail;
    }
}
