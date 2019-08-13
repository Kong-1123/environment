package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import com.xdmd.environment.dailymanagement.service.DailyManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description:
 */
@Api(tags = "日常管理")
@RestController
@RequestMapping("/environment/daily")
public class DailyManageController {
    @Autowired
    DailyManageService dailyManageService;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增中期检查
     * @param midCheckDTO
     * @return
     */
    @ApiOperation(value = "新增中期检查")
    @PostMapping("")
    public ResultMap insert(MidCheckDTO midCheckDTO) {
        return resultMap=dailyManageService.insert(midCheckDTO);
    }
}
