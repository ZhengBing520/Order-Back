package com.zb.controller;

import com.zb.dto.LoginDto;
import com.zb.dto.UserDto;
import com.zb.entity.User;
import com.zb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bzheng on 2019/1/27.
 * 登录
 */
@Api(value = "登录 Client Restful API ", description = "登录 Client ", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat")
public class LoginController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录 ", notes = "登录")
    @ApiImplicitParam(name = "loginDto", value = "参数对象", dataType = "LoginDto", paramType = "body", required = true)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDto login(@RequestBody LoginDto loginDto) {

        return userService.login(loginDto);
    }
}
