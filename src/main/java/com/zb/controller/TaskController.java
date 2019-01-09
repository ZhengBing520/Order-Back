package com.zb.controller;

import com.zb.dto.TaskDto;
import com.zb.model.PageableData;
import com.zb.request.TaskRequest;
import com.zb.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 任务
 */
@Api(value = "任务任务信息 Client Restful API ", description = "任务任务信息 Client ", protocols = "application/json")
@Validated
@RestController
@RequestMapping("/api/plat/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @ApiOperation(value = "获取任务信息 ", notes = "获取任务信息")
    @ApiImplicitParam(name = "id", value = "任务id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public TaskDto getById(@RequestParam("id") Integer id) {

        return taskService.get(id);
    }

    @ApiOperation(value = "分页查询任务信息（郑兵） #2018-04-03#", notes = "分页查询车辆信息）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页号", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", dataType = "int", paramType = "path", required = true),
            @ApiImplicitParam(name = "businessDto", value = "参数对象", dataType = "BusinessDto", paramType = "body", required = false)
    })
    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<TaskDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                         @PathVariable(value = "pageSize") Integer pageSize,
                                                         @RequestBody(required = false) TaskDto TaskDto) throws Exception {

        return taskService.queryPageableData(pageNum, pageSize, TaskDto);
    }

    @ApiOperation(value = "删除任务信息 ", notes = "删除任务信息")
    @ApiImplicitParam(name = "id", value = "任务id", dataType = "int", paramType = "query", required = true)
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean del(@RequestParam("id") Integer id) {

        return taskService.deleteById(id);
    }

    @ApiOperation(value = "新增任务信息 ", notes = "新增任务信息")
    @ApiImplicitParam(name = "businessDto", value = "参数对象", dataType = "BusinessDto", paramType = "body", required = true)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody TaskDto TaskDto) {

        return taskService.insert(TaskDto);
    }
    @ApiOperation(value = "导入任务列表 ", notes = "导入任务列表")
    @ApiImplicitParam(name = "taskRequest", value = "任务对象", dataType = "TaskRequest", paramType = "body", required = true)
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public Boolean importTask(@RequestBody TaskRequest taskRequest) {

        return taskService.insertList(taskRequest);
    }

    @ApiOperation(value = "修改任务信息 ", notes = "修改任务信息")
    @ApiImplicitParam(name = "businessDto", value = "参数对象", dataType = "BusinessDto", paramType = "body", required = true)
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody TaskDto TaskDto) {

        return taskService.update(TaskDto);
    }
}
