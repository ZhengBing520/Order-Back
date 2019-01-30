package com.zb.service;

import com.zb.dto.LoginDto;
import com.zb.dto.UserDto;

/**
 * Created by bzheng on 2019/1/27.
 */
public interface UserService extends BaseService<UserDto> {

    /**
     * 登录
     * @param loginDto
     * @return
     */
    UserDto login(LoginDto loginDto);

    /**
     * 重置密码
     * @param id
     * @return
     */
    Boolean resetPwd(Integer id);
}
