package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.*;
import com.xdmd.environment.guidemanagement.service.GuideService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 控制层接口
 */

@Controller
@RequestMapping(value = "/environment/guide/")
public class GuideController {
    @Autowired
    GuideService guideService;
    ResultMap resultMap=new ResultMap();

    /**
     * 分页展示所有信息
     * @return
     */
    @ApiOperation(value = "分页展示所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前显示页", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", required = true, dataType = "int", paramType = "path")
    })
    @ResponseBody
    @GetMapping(value = "findAll/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
    public ResultMap getAllGuideInfo(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize")int pageSize){
        List<GuideCollection> guideCollectionList= guideService.getAllGuideInfo(pageNum,pageSize);
        return guideCollectionList.size()>0?resultMap.success().message(guideCollectionList):resultMap.fail();
    }

    /**
     * 新增信息
     * @param guideCollection
     * @return
     */
    @ApiOperation(value = "新增信息")
    @ResponseBody
    @PostMapping(value = "insertGuideInfo")
    public ResultMap insertGuideInfo(GuideCollection guideCollection){
        return resultMap= guideService.insertGuideInfo(guideCollection);
    }

    @ApiOperation(value = "显示领域信息")
    @ResponseBody
    @GetMapping(value = "getAllDomain")
    public ResultMap getAllDomain(){
         List<Domain> domainList=guideService.getAllDomain();
         return domainList.size()>0?resultMap.success().message(domainList):resultMap.fail();
    }

    @ApiOperation(value = "显示类别信息")
    @ResponseBody
    @GetMapping(value = "getAllCategory")
    public ResultMap getAllCategory(){
        List<Category> categoryList=guideService.getAllCategory();
        return categoryList.size()>0?resultMap.success().message(categoryList):resultMap.fail();
    }


    @ApiOperation(value = "更新限制时间")
    @ResponseBody
    @PostMapping(value = "update/limitime")
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime){
        return resultMap= guideService.updateLimitTime(guideCollectionLimitTime);
    }

    /**
     * 汇总新增信息
     * @param guideSummary
     * @return
     */
    @ApiOperation(value = "新增汇总信息")
    @ResponseBody
    @PostMapping(value = "insertSummary")
    public ResultMap insertSummary(GuideSummary guideSummary
    ){
        return resultMap= guideService.insertSummary(guideSummary);
    }

    @ApiOperation(value = "汇总信息")
    @ResponseBody
    @GetMapping(value = "getAllSummary")
    public ResultMap getAllSummary(){
        List<GuideSummary> guideSummaryList=guideService.getAllSummary();
        return guideSummaryList.size()>0?resultMap.success().message(guideSummaryList):resultMap.fail();

    }
}
