package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
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
     * 根据id获取信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取信息")
    @ApiImplicitParam(name = "id",value = "信息id",required = true,dataType = "int",paramType = "path")
    @ResponseBody
    @GetMapping(value = "findOne/{id}")
    public ResultMap findOneGuideInfo(@PathVariable("id") int id){
        return guideCollectionService.findOneGuideInfo(id)!=null?resultMap.success().message(guideCollectionService.findOneGuideInfo(id)):resultMap.fail();

    }

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
    @GetMapping(value = "findAll/{pageNum}/{pageSize}",produces = {"application/json;charset=UTF-8"})
    public ResultMap findAllGuideInfo(@PathVariable("pageNum")int pageNum,@PathVariable("pageSize") int pageSize){
        List<GuideCollection> guideCollectionList=guideCollectionService.findAllGuideInfo(pageNum,pageSize);
        return guideCollectionList.size()>0?resultMap.success().message(guideCollectionList):resultMap.fail();
    }

    /**
     * 新增信息
     * @param guideCollection
     * @return
     */
    @ApiOperation(value = "新增信息")
    @RequestMapping(value = "insertGuideInfo",method=RequestMethod.POST)
    public ResultMap insertGuideInfo(GuideCollection guideCollection){
        return guideCollectionService.insertGuideInfo(guideCollection);
    }
}
