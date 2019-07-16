package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.service.GuideCollectionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 控制层接口
 */
@RestController
@RequestMapping("/environment/guidemanagement")
public class GuideCollectionController {
    @Autowired
    GuideCollectionService guideCollectionService;
    ResultMap resultMap=new ResultMap();

    @ApiOperation(value = "获取信息",notes = "根据id获取信息")
    @ApiImplicitParam(name = "id",value = "信息id",required = true,dataType = "integet",paramType = "path")
    @ResponseBody
    @RequestMapping(value = "/findOne/{id}")
    public ResultMap findOneGuideInfo(@PathVariable("id") Integer id){
        return guideCollectionService.findOneGuideInfo(id)!=null?resultMap.success():resultMap.fail();

    }
    @ApiOperation(value = "展示所有信息",notes = "分页展示所有信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前显示页", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "总页数", required = true, dataType = "Integer", paramType = "path")
    })
    @ResponseBody
    @RequestMapping(value = "/findAll/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
    public ResultMap findAllGuideInfo(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize ){
        List<GuideCollection> guideCollectionList=guideCollectionService.findAllGuideInfo(pageNum,pageSize);
        return guideCollectionList.size()>0?resultMap.success():resultMap.fail();
    }
    @ApiOperation(value = "新增信息")
    @ResponseBody
    @RequestMapping(value = "/insertGuideInfo")
    public ResultMap insertGuideInfo(GuideCollection guideCollection){
        return guideCollectionService.insertGuideInfo(guideCollection)>0?resultMap.success():resultMap.fail();
    }

}
