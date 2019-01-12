package com.zb.controller;

import com.zb.dto.DetailDto;
import com.zb.model.PageableData;
import com.zb.service.DetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 明细
 */
@Api(value = "每日明细信息 Client Restful API ", description = "每日明细信息 Client ", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/detail")
public class DetailController {

    @Autowired
    DetailService detailService;

    @ApiOperation(value = "获取明细信息 ", notes = "获取明细信息")
    @ApiImplicitParam(name = "id", value = "明细id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public DetailDto getById(@RequestParam("id") Integer id) {

        return detailService.get(id);
    }

    @ApiOperation(value = "分页查询明细信息", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "detailDto", value = "参数对象", dataType = "DetailDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<DetailDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                        @PathVariable(value = "pageSize") Integer pageSize,
                                                        @RequestBody(required = false) DetailDto detailDto) throws Exception {

        return detailService.queryPageableData(pageNum, pageSize, detailDto);
    }

    @ApiOperation(value = "修改明细信息 ", notes = "修改明细信息")
    @ApiImplicitParam(name = "detailDto", value = "参数对象", dataType = "DetailDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody DetailDto detailDto) {

        return detailService.update(detailDto);
    }
}
