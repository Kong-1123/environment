package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.pojo.GuideSummaryV2;
import com.xdmd.environment.guidemanagement.service.GuideService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 指南管理接口
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
    @ApiOperation(value = "分页查询指南申报信息")
    @ResponseBody
    @GetMapping(value = "getCollectionByParam")
    public ResultMap getGuideInfoPageList(String guideName, Integer domain, Integer category,String fillUnit,String fillContacts,String contactPhone, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize")int pageSize){
        List<GuideCollection> guideCollectionList= guideService.getCollectionByParam(guideName,domain,category,fillUnit,fillContacts,contactPhone,pageNum,pageSize);
        return guideCollectionList.size()>0?resultMap.success().message(guideCollectionList):resultMap.fail().message("查询失败");
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

    @ApiOperation(value = "显示类别和领域信息")
    @ResponseBody
    @GetMapping(value = "getCategoryAndDomain")
    public ResultMap getCategoryAndDomain(){
        return guideService.getCategoryAndDomain()!=null?resultMap.success().message("查询成功"):resultMap.fail().message("查询失败");
    }

    @ApiOperation(value = "更新限制时间")
    @ResponseBody
    @PostMapping(value = "update/limitime")
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime){
        return resultMap= guideService.updateLimitTime(guideCollectionLimitTime);
    }

    /**
     * 汇总新增信息
     * @param guideSummaryV2
     * @return
     */
    @ApiOperation(value = "新增汇总信息")
    @ResponseBody
    @PostMapping(value = "insertSummary")
    public ResultMap insertSummary(GuideSummaryV2 guideSummaryV2
    ){
        return resultMap= guideService.insertSummary(guideSummaryV2);
    }

    /**
     * 分页展示汇总信息
     * @param guideSummaryTitle
     * @param fillUnit
     * @param domain
     * @param category
     * @param projectTime
     * @param researchContentTechnology
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页展示汇总信息")
    @ResponseBody
    @GetMapping(value = "getAllSummary")
    public ResultMap getAllSummary(String guideSummaryTitle,String fillUnit,Integer domain, Integer category, String projectTime, String researchContentTechnology,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        List<GuideSummary> guideSummaryList=guideService.getAllSummary(guideSummaryTitle,fillUnit,domain,category,projectTime,researchContentTechnology,pageNum,pageSize);
        return guideSummaryList.size()>0?resultMap.success().message(guideSummaryList):resultMap.fail().message("查询失败");
    }

    @ApiOperation(value = "根据单位id展示相应单位指南")
    @ResponseBody
    @GetMapping(value = "getCollectionById")
    public  ResultMap getCollectionById(int id) {
        List<GuideCollection> getCollectionList=guideService.getCollectionById(id);
        return getCollectionList.size()>0?resultMap.success().message(getCollectionList):resultMap.fail().message("查询失败");
    }
}
