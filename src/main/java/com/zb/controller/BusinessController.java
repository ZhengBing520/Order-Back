package com.zb.controller;

import com.zb.dto.BusinessDto;
import com.zb.model.PageableData;
import com.zb.service.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 商家
 */
@Api(value = "商家信息 Client Restful API ", description = "商家信息 Client (艾翠)", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @ApiOperation(value = "获取商家信息 ", notes = "获取商家信息")
    @ApiImplicitParam(name = "id", value = "商家id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public BusinessDto getById(@RequestParam("id") Integer id) {

        return businessService.get(id);
    }

    @ApiOperation(value = "分页查询商家信息（郑兵） #2018-04-03#", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "businessDto", value = "参数对象", dataType = "BusinessDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<BusinessDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                        @PathVariable(value = "pageSize") Integer pageSize,
                                                        @RequestBody(required = false) BusinessDto businessDto) throws Exception {

        return businessService.queryPageableData(pageNum, pageSize, businessDto);
    }

    @ApiOperation(value = "删除商家信息 ", notes = "删除商家信息")
    @ApiImplicitParam(name = "id", value = "商家id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean del(@RequestParam("id") Integer id) {

        return businessService.deleteById(id);
    }

    @ApiOperation(value = "新增商家信息 ", notes = "新增商家信息")
    @ApiImplicitParam(name = "businessDto", value = "参数对象", dataType = "BusinessDto", paramType = "body", required = true)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody BusinessDto businessDto) {

        return businessService.insert(businessDto);
    }

    @ApiOperation(value = "修改商家信息 ", notes = "修改商家信息")
    @ApiImplicitParam(name = "businessDto", value = "参数对象", dataType = "BusinessDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody BusinessDto businessDto) {

        return businessService.update(businessDto);
    }
}
