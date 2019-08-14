package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.ProjectProgressDTO;
import com.xdmd.environment.dailymanagement.service.ProjectProgressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kong
 * @createDate: 2019/08/14
 * @description: 课题进展接口
 */
@Api(tags = "课题进展")
@RestController
@RequestMapping("/environment/progress")
public class ProjectProgressController {
    @Autowired
    ProjectProgressService projectProgressService;
    ResultMap resultMap=new ResultMap();

    /**
     * [新增] 课题进展主体
     * @param progressDTO
     * @return
     */
    @ApiOperation(value = "新增课题进展主体")
    @PostMapping("addProgress")
    public ResultMap insert(ProjectProgressDTO progressDTO) {
       return resultMap=projectProgressService.insert(progressDTO);
    }

    /**
     *  [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @ApiOperation(value = "根據主鍵 id 查詢")
    @PostMapping("getInfoById")
    public ResultMap getInfoById(int id) {
        return resultMap=projectProgressService.getInfoById(id);
    }

    /**
     * [查詢] 根據参数查詢
     * @param subjectName
     * @param bearerUnit
     * @param progress
     * @return
     */
    @ApiOperation(value = "根據参数查詢")
    @PostMapping("getInfoByParam")
    public ResultMap getInfoByParam(String subjectName, String bearerUnit, Integer progress) {
        return  resultMap=projectProgressService.getInfoByParam(subjectName,bearerUnit,progress);
    }
}
