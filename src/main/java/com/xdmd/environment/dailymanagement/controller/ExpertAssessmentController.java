package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.ExpertAssessmentDTO;
import com.xdmd.environment.dailymanagement.service.ExpertAssessmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kong
 * @createDate: 2019/8/17
 * @description: 专家评估接口
 */
@Api(tags = "专家评估接口")
@RestController
@RequestMapping("environment/dailymanage/zhuanjiapinggu")
public class ExpertAssessmentController {
    @Autowired
    ExpertAssessmentService expertAssessmentService;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增
     * @param expertAssessment
     * @return
     */
    @ApiOperation(value = "新增专家评估")
    @PostMapping("insertEA")
    ResultMap insert(@Param("expertAssessment") ExpertAssessmentDTO expertAssessment){
        return resultMap=expertAssessmentService.insert(expertAssessment);
    }

    /**
     * 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @ApiOperation(value = "根據主鍵id查詢")
    @GetMapping("getEAByid")
    ResultMap getEAByid(@Param("id") int id){
        return resultMap=expertAssessmentService.getEAByid(id);
    }

    /**
     * 查詢全部
     * @return
     */
    @ApiOperation(value = "查詢全部专家评估信息")
    @GetMapping("getAllEA")
    ResultMap getAllEA(){
        return resultMap=expertAssessmentService.getAllEA();
    }

    /**
     * 查詢全部评估内容
     * @return
     */
    @ApiOperation(value = "查詢全部评估内容")
    @GetMapping("getAllEvaluationContent")
    public ResultMap getAllEvaluationContent(){
        return resultMap=expertAssessmentService.getAllEvaluationContent();
    }
}
