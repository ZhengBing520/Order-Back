package com.zb.controller;

import com.zb.dto.ResetPasswordDto;
import com.zb.dto.UserDto;
import com.zb.model.PageableData;
import com.zb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 用户信息
 */
@Api(value = "用户信息 Client Restful API ", description = "用户信息 Client ", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户信息 ", notes = "获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public UserDto getById(@RequestParam("id") Integer id) {

        return userService.get(id);
    }

    @ApiOperation(value = "分页查询用户信息", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "userDto", value = "参数对象", dataType = "UserDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<UserDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                   @PathVariable(value = "pageSize") Integer pageSize,
                                                   @RequestBody(required = false) UserDto userDto) throws Exception {

        return userService.queryPageableData(pageNum, pageSize, userDto);
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean del(@RequestParam("id") Integer id) {

        return userService.deleteById(id);
    }

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @ApiImplicitParam(name = "userDto", value = "参数对象", dataType = "UserDto", paramType = "body", required = true)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody @Validated UserDto userDto) {

        return userService.insert(userDto);
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @ApiImplicitParam(name = "userDto", value = "参数对象", dataType = "UserDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody UserDto userDto) {

        return userService.update(userDto);
    }

    @ApiOperation(value = "重置用户密码", notes = "重置用户密码")
    @ApiImplicitParam(name = "resetPasswordDto", value = "参数对象", dataType = "ResetPasswordDto", paramType = "body", required = true)
    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
    public Boolean resetPwd(@RequestBody ResetPasswordDto resetPasswordDto) {

        return userService.resetPwd(resetPasswordDto);
    }
}
