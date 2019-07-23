package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.service.GuideCollectionService;
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
public class GuideCollectionController {
    @Autowired
    GuideCollectionService guideCollectionService;
    ResultMap resultMap=new ResultMap();

    /**
     * 分页展示所有信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页展示所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前显示页", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", required = true, dataType = "int", paramType = "path")
    })
    @ResponseBody
    @GetMapping(value = "findAll/{id}/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
    public ResultMap findAllGuideInfo(@PathVariable("id")int id,@PathVariable("pageNum")int pageNum,@PathVariable("pageSize") int pageSize){
        List<GuideCollection> guideCollectionList=guideCollectionService.findAllGuideInfo(id,pageNum,pageSize);
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
        return resultMap=guideCollectionService.insertGuideInfo(guideCollection);
    }

    @ApiOperation(value = "显示类别和领域信息")
    @ResponseBody
    @GetMapping(value = "findDic")
    public ResultMap findDic(){
        return guideCollectionService.findDic().size()>0?resultMap.success():resultMap.fail();
    }

    @ApiOperation(value = "更新限制时间")
    @ResponseBody
    @PostMapping(value = "update/limitime")
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime){
        return resultMap=guideCollectionService.updateLimitTime(guideCollectionLimitTime);
    }

    @ApiOperation(value = "添加汇总信息")
    @ResponseBody
    @PostMapping(value = "insertSummaryData")
    public ResultMap insertSummaryData(GuideSummary guideSummary){
        return resultMap=guideCollectionService.insertGuideInfo(guideSummary);
    }
}
