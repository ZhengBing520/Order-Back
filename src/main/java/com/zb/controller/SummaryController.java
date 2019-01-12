package com.zb.controller;

import com.zb.dto.AccountCollectDto;
import com.zb.dto.SummaryDto;
import com.zb.model.PageableData;
import com.zb.request.AccountCollectRequest;
import com.zb.service.DetailService;
import com.zb.service.SummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2019/1/13.
 * 每日汇总信息
 */
@Api(value = "每日汇总信息 Client Restful API ", description = "每日汇总信息 Client ", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/summary")
public class SummaryController {

    @Autowired
    SummaryService summaryService;

    @Autowired
    DetailService detailService;

    @ApiOperation(value = "每日汇总信息", notes = "每日汇总信息")
    @ApiImplicitParam(name = "accountCollectRequest", value = "查询条件", dataType = "AccountCollectRequest", paramType = "body", required = true)
    @RequestMapping(value = "/selectSummary", method = RequestMethod.POST)
    public List<SummaryDto> selectSummary(@RequestBody AccountCollectRequest accountCollectRequest) {
        return summaryService.selectSummary(accountCollectRequest);
    }

    @ApiOperation(value = "获取每日卡号收款汇总", notes = "获取每日卡号收款汇总")
    @ApiImplicitParam(name = "accountCollectRequest", value = "查询条件", dataType = "AccountCollectRequest", paramType = "body", required = true)
    @RequestMapping(value = "/getCardCollect", method = RequestMethod.POST)
    public List<AccountCollectDto> getCardCollect(@RequestBody AccountCollectRequest accountCollectRequest) {
        return detailService.getCardCollect(accountCollectRequest);
    }

    @ApiOperation(value = "获取每日介绍人收款汇总", notes = "获取每日介绍人收款汇总")
    @ApiImplicitParam(name = "accountCollectRequest", value = "查询条件", dataType = "AccountCollectRequest", paramType = "body", required = true)
    @RequestMapping(value = "/getReferrerCollect", method = RequestMethod.POST)
    public List<AccountCollectDto> getReferrerCollect(@RequestBody AccountCollectRequest accountCollectRequest) {
        return detailService.getReferrerCollect(accountCollectRequest);
    }

    @ApiOperation(value = "分页查询汇总信息", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "summaryDto", value = "参数对象", dataType = "SummaryDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<SummaryDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                      @PathVariable(value = "pageSize") Integer pageSize,
                                                      @RequestBody(required = false) SummaryDto summaryDto) throws Exception {

        return summaryService.queryPageableData(pageNum, pageSize, summaryDto);
    }

    @ApiOperation(value = "修改汇总信息 ", notes = "修改汇总信息")
    @ApiImplicitParam(name = "summaryDto", value = "参数对象", dataType = "SummaryDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody SummaryDto summaryDto) {

        return summaryService.update(summaryDto);
    }

    @ApiOperation(value = "获取汇总信息 ", notes = "获取汇总信息")
    @ApiImplicitParam(name = "id", value = "汇总id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public SummaryDto getById(@RequestParam("id") Integer id) {

        return summaryService.get(id);
    }
}
