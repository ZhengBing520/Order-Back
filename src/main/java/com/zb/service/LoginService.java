package com.zb.service;

import com.zb.dto.UserDto;

/**
 * Created by bzheng on 2019/1/30.
 */
public interface LoginService {

    // 获取登录账户信息
     UserDto getLoginUser();

    // 获取登录账户信息
     UserDto getLoginUser(String token);

    // 验证token是否过期
     boolean verifyToken(String token);

    // 将登录信息添加到redis
     void setLoginUser(UserDto userDto);
}
