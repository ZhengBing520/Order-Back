package com.zb.controller;

import com.zb.dto.CardManagementDto;
import com.zb.model.PageableData;
import com.zb.service.CardManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 卡号
 */
@Api(value = "卡号管理 Client Restful API ", description = "卡号管理 Client ", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/cardManagement")
public class CardManagementController {

    @Autowired
    CardManagementService cardManagementService;

    @ApiOperation(value = "获取卡号管理 ", notes = "获取卡号管理")
    @ApiImplicitParam(name = "id", value = "卡号id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public CardManagementDto getById(@RequestParam("id") Integer id) {

        return cardManagementService.get(id);
    }

    @ApiOperation(value = "分页查询卡号管理", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "cardManagementDto", value = "参数对象", dataType = "CardManagementDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<CardManagementDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                        @PathVariable(value = "pageSize") Integer pageSize,
                                                        @RequestBody(required = false) CardManagementDto cardManagementDto) throws Exception {

        return cardManagementService.queryPageableData(pageNum, pageSize, cardManagementDto);
    }

    @ApiOperation(value = "删除卡号管理 ", notes = "删除卡号管理")
    @ApiImplicitParam(name = "id", value = "卡号id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean del(@RequestParam("id") Integer id) {

        return cardManagementService.deleteById(id);
    }

    @ApiOperation(value = "新增卡号管理 ", notes = "新增卡号管理")
    @ApiImplicitParam(name = "cardManagementDto", value = "参数对象", dataType = "CardManagementDto", paramType = "body", required = true)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody CardManagementDto cardManagementDto) {

        return cardManagementService.insert(cardManagementDto);
    }

    @ApiOperation(value = "修改卡号管理 ", notes = "修改卡号管理")
    @ApiImplicitParam(name = "cardManagementDto", value = "参数对象", dataType = "CardManagementDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody CardManagementDto cardManagementDto) {

        return cardManagementService.update(cardManagementDto);
    }
}
