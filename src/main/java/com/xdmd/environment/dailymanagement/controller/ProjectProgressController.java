package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.*;
import com.xdmd.environment.dailymanagement.service.ProjectProgressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/14
 * @description: 课题进展接口
 */
@Api(tags = "课题进展接口")
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
    @PostMapping("insertProgress")
    public ResultMap insert(ProjectProgressDTO progressDTO) {
       return resultMap=projectProgressService.insert(progressDTO);
    }

    /**
     *  [查詢] 根據id查詢课题进展主体
     * @param id
     * @return
     */
    @ApiOperation(value = "根據id查詢课题进展主体")
    @GetMapping ("getInfoById")
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
    @ApiOperation(value = "根據参数查詢课题进展主体")
    @ApiImplicitParams({
            @ApiImplicitParam(name="subjectName",value = "课题名称",dataType = "string"),
            @ApiImplicitParam(name="bearerUnit",value = "承担单位",dataType = "string"),
            @ApiImplicitParam(name="progress",value = "课题进展类型【45-超前 46-正常 47-滞后】",dataType = "int"),
    })
    @GetMapping("getInfoByParam")
    public ResultMap getInfoByParam(String subjectName,String bearerUnit,Integer progress) {
        return  resultMap=projectProgressService.getInfoByParam(subjectName,bearerUnit,progress);
    }


    /**
     * [新增] 合同要求研发任务【课题进展第一部分】
     * @param contractResearchDevelopmentTasks
     * @return
     */
    @ApiOperation(value = "新增合同要求研发任务【课题进展第一部分】")
    @PostMapping("insertCRDT")
    public ResultMap insertCRDT(@RequestBody List<ContractResearchDevelopmentTasksDTO> contractResearchDevelopmentTasks){
        return  resultMap=projectProgressService.insertCRDT(contractResearchDevelopmentTasks);
    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第一部分】
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第一部分】")
    @GetMapping ("getCRDTByPid")
    public ResultMap getCRDTByPid(int Pid){
        return  resultMap=projectProgressService.getCRDTByPid(Pid);
    }


    /**
     * [新增]目前进展情况【课题进展第二部分】
     * @param currentProgress
     * @return
     */
    @ApiOperation(value = "新增目前进展情况【课题进展第二部分】")
    @PostMapping("insertCP")
    public ResultMap insertCP(@RequestBody List<CurrentProgressDTO> currentProgress){
        return  resultMap=projectProgressService.insertCP(currentProgress);

    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第二部分】
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第二部分】")
    @GetMapping ("getCPByPid")
    public ResultMap getCPByPid(int Pid){
        return  resultMap=projectProgressService.getCPByPid(Pid);

    }
    /**
     * [新增] 课题实施中存在的主要问题【课题进展第四部分】
     * @param projectMainProblemsDTO
     * @return
     */
    @ApiOperation(value = "新增课题实施中存在的主要问题【课题进展第四部分】")
    @PostMapping("insertPMP")
    public ResultMap insertPMP(@RequestBody List<ProjectMainProblemsDTO> projectMainProblemsDTO){
        return  resultMap=projectProgressService.insertPMP(projectMainProblemsDTO);
    }

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第四部分】")
    @GetMapping ("getPMPByPid")
    public ResultMap getPMPByPid(int Pid){
        return  resultMap=projectProgressService.getPMPByPid(Pid);
    }

    /**
     * [新增] 下一步工作计划【课题进展第五部分】
     * @param nextWorkPlanDTO
     * @return
     */
    @ApiOperation(value = "新增下一步工作计划【课题进展第五部分】")
    @PostMapping("insertNWP")
    public ResultMap insertNWP(@RequestBody List<NextWorkPlanDTO> nextWorkPlanDTO){
        return  resultMap=projectProgressService.insertNWP(nextWorkPlanDTO);
    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第五部分】
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第五部分】")
    @GetMapping ("getNWPByPid")
    public ResultMap getNWPByPid(int Pid){
        return  resultMap=projectProgressService.getNWPByPid(Pid);
    }
}
