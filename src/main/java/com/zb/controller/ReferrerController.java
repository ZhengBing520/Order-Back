package com.zb.controller;

import com.zb.dto.ReferrerDto;
import com.zb.model.PageableData;
import com.zb.service.ReferrerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 介绍人管理
 */
@Api(value = "介绍人信息 Client Restful API ", description = "介绍人信息 Client (艾翠)", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/referrer")
public class ReferrerController {

    @Autowired
    ReferrerService referrerService;

    @ApiOperation(value = "获取介绍人信息 ", notes = "获取介绍人信息")
    @ApiImplicitParam(name = "id", value = "介绍人id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public ReferrerDto getById(@RequestParam("id") Integer id) {

        return referrerService.get(id);
    }

    @ApiOperation(value = "分页查询介绍人信息（郑兵） #2018-04-03#", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "referrerDto", value = "参数对象", dataType = "ReferrerDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<ReferrerDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                        @PathVariable(value = "pageSize") Integer pageSize,
                                                        @RequestBody(required = false) ReferrerDto referrerDto) throws Exception {

        return referrerService.queryPageableData(pageNum, pageSize, referrerDto);
    }

    @ApiOperation(value = "删除介绍人信息 ", notes = "删除介绍人信息")
    @ApiImplicitParam(name = "id", value = "介绍人id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean del(@RequestParam("id") Integer id) {

        return referrerService.deleteById(id);
    }

    @ApiOperation(value = "新增介绍人信息 ", notes = "新增介绍人信息")
    @ApiImplicitParam(name = "referrerDto", value = "参数对象", dataType = "ReferrerDto", paramType = "body", required = true)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody ReferrerDto referrerDto) {

        return referrerService.insert(referrerDto);
    }

    @ApiOperation(value = "修改介绍人信息 ", notes = "修改介绍人信息")
    @ApiImplicitParam(name = "referrerDto", value = "参数对象", dataType = "ReferrerDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody ReferrerDto referrerDto) {

        return referrerService.update(referrerDto);
    }
}
