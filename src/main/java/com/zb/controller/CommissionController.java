package com.zb.controller;

import com.zb.dto.CommissionDto;
import com.zb.model.PageableData;
import com.zb.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bzheng on 2019/1/6.
 * 佣金
 */
@Validated
@RestController
@RequestMapping("/api/plat/commission")
public class CommissionController {

    @Autowired
    CommissionService commissionService;
    
    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    public CommissionDto getById(@RequestParam("id") Integer id) {

        return commissionService.get(id);
    }

    @RequestMapping(value = "/queryPageableData/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public PageableData<CommissionDto> queryPageableData(@PathVariable(value = "pageNum") Integer pageNum,
                                                       @PathVariable(value = "pageSize") Integer pageSize,
                                                       @RequestBody(required = false) CommissionDto CommissionDto) throws Exception {

        return commissionService.queryPageableData(pageNum, pageSize, CommissionDto);
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public Boolean delJacVehicleById(@RequestParam("id") Integer id) {

        return commissionService.deleteById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Integer create(@RequestBody CommissionDto CommissionDto) {

        return commissionService.insert(CommissionDto);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Boolean update(@RequestBody CommissionDto CommissionDto) {

        return commissionService.update(CommissionDto);
    }
}
