package com.zb.service.impl;

import com.zb.common.Constant;
import com.zb.dao.UserDao;
import com.zb.dto.LoginDto;
import com.zb.dto.ResetPasswordDto;
import com.zb.dto.UserDto;
import com.zb.entity.User;
import com.zb.service.LoginService;
import com.zb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by bzheng on 2019/1/27.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDto, User, UserDao> implements UserService {

    @Autowired
    LoginService loginService;

    @Override
    public Integer insert(UserDto userDto) {
        // 默认创建普通用户
        if (Objects.isNull(userDto.getType())) {
            userDto.setType(Constant.UserType.GENERAL);
        }
        // 验证用户名的唯一性
        int i = dao.selectCountByUsername(userDto.getUsername(), null);
        if (0 < i) {
            throw new IllegalArgumentException("用户名已存在");
        }
        // 非管理员不能创建管理员用户，修改一样
        UserDto loginUser = loginService.getLoginUser();
        if (Objects.equals(Constant.UserType.GENERAL, loginUser.getType()) && !Objects.equals(loginUser.getType(), userDto.getType())) {
            throw new IllegalArgumentException("非管理员不能创建管理员");
        }

        return super.insert(userDto);
    }

    @Override
    public Boolean update(UserDto userDto) {
        // 非管理员不能创建管理员用户，修改一样
        UserDto loginUser = loginService.getLoginUser();
        if (Objects.equals(Constant.UserType.GENERAL, loginUser.getType()) && !Objects.equals(loginUser.getType(), userDto.getType())) {
            throw new IllegalArgumentException("非管理员不能创建管理员");
        }
        return super.update(userDto);
    }

    @Override
    public UserDto login(LoginDto loginDto) {
        Assert.notNull(loginDto, "登录信息不能为空");
        User user = dao.selectByUsername(loginDto.getUsername());
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("没有此账号");
        }
        if (!Objects.equals(user.getPassword(), loginDto.getPassword())) {
            throw new IllegalArgumentException("您输入的密码不正确");
        }
        user.setPassword(null);
        UserDto userDto = entityToDto(user);
        String token = UUID.randomUUID().toString();
        userDto.setToken(token);
        // 添加到redis
        loginService.setLoginUser(userDto);
        return userDto;
    }

    @Override
    public Boolean resetPwd(ResetPasswordDto resetPasswordDto) {
        if (Objects.isNull(resetPasswordDto)) {
            throw new IllegalArgumentException("参数对象不能为空");
        }
        User user = dao.selectById(resetPasswordDto.getId());
        if (Objects.isNull(user)) {
            throw new IllegalArgumentException("没有此用户");
        }
        // 重置密码
//        String passwordNew = DigestUtils.md5DigestAsHex(resetPasswordDto.getNewPassword().getBytes()).toUpperCase();
        user.setPassword(resetPasswordDto.getNewPassword());

        return update(entityToDto(user));
    }
}
