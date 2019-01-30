package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.common.Constant;
import com.zb.common.utils.CommonUtil;
import com.zb.dto.UserDto;
import com.zb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * Created by bzheng on 2019/1/29.
 * 登录相关util
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisServiceImpl redisUtil;

    /**
     * token前缀
     */
    private static final String TOKEN_PREFIX = "order:token:";

//    @Value("login.timeout")
    private Long timeout;

    // 2小时
    private  long TIMEOUT_DEFAULT = 1000 * 2 * 60 * 60;

    // 获取登录账户信息
    @Override
    public  UserDto getLoginUser() {
        String token = getToken();
        return getLoginUser(token);
    }

    // 获取登录账户信息
    @Override
    public  UserDto getLoginUser(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("没有token");
        }
        String s = redisUtil.get(createKey(token));
        UserDto userDto = JSON.parseObject(s, UserDto.class);
        return userDto;
    }

    /**
     * 验证token是否过期
     */
    @Override
    public  boolean verifyToken(String token) {
        UserDto loginUser = getLoginUser(token);
        if (Objects.isNull(loginUser)) {
            return false;
        }
        // 重新设置过期时间
        setLoginUser(loginUser);
        return true;
    }

    // 将登录信息添加到redis
    @Override
    public  void setLoginUser(UserDto userDto) {
        Assert.notNull(userDto, "登录信息不能为空");
        if (StringUtils.isEmpty(userDto.getToken())) {
            throw new IllegalArgumentException("没有token");
        }
        redisUtil.set(createKey(userDto.getToken()), JSON.toJSONString(userDto), TIMEOUT_DEFAULT);
    }

    public  String getToken() {
        return CommonUtil.getRequest().getHeader(Constant.X_Auth_Token);
    }

    public String createKey(String token) {
        return TOKEN_PREFIX + token;
    }
}
