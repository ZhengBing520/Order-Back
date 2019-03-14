package com.zb.controller;

import com.zb.common.Constant;
import com.zb.dto.CommissionDto;
import com.zb.entity.Commission;
import com.zb.model.PageableData;
import com.zb.service.CommissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 佣金
 */
@Api(value = "佣金信息 Client Restful API ", description = "佣金信息 Client ", protocols = "application/json")

@Validated
@RestController
@RequestMapping("/api/plat/commission")
public class CommissionController {

    @Autowired
    CommissionService commissionService;

    @ApiOperation(value = "获取佣金信息 ", notes = "获取佣金信息")
    @ApiImplicitParam(name = "id", value = "佣金id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public CommissionDto getById(@RequestParam("id") Integer id) {

        return commissionService.get(id);
    }

    @ApiOperation(value = "分页查询佣金信息", notes = "分页查询佣金信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "commissionDto", value = "参数对象", dataType = "CommissionDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<CommissionDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                       @PathVariable(value = "pageSize") Integer pageSize,
                                                       @RequestBody(required = false) CommissionDto commissionDto) throws Exception {

        return commissionService.queryPageableData(pageNum, pageSize, commissionDto);
    }


    @ApiOperation(value = "修改佣金信息 ", notes = "修改佣金信息")
    @ApiImplicitParam(name = "commissionDto", value = "参数对象", dataType = "CommissionDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody CommissionDto commissionDto) {

        return commissionService.update(commissionDto);
    }

    @ApiOperation(value = "分页查询默认佣金信息", notes = "分页查询默认佣金信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true)
    })
    @RequestMapping(value = "/queryDefaultCommission/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public PageableData<CommissionDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                         @PathVariable(value = "pageSize") Integer pageSize) {
        CommissionDto commissionDto = new CommissionDto();
        commissionDto.setBusinessId(Constant.DEFAULT_COMMISSION_BUSINESS_ID);
        return commissionService.queryPageableData(pageNum, pageSize, commissionDto);
    }
}
