package com.zb.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by bzheng on 2019/1/27.
 */
public class LoginDto {

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
