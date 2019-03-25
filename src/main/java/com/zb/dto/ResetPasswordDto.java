package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by bzheng on 2019/3/18.
 */
public class ResetPasswordDto {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("新密码")
    private String newPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
