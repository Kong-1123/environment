package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.service.GuideService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/07/16
 * @description: 指南管理接口
 */
@Api(tags="指南管理接口")
@RestController
@RequestMapping(value = "/environment/guide/")
public class GuideController {
    @Autowired
    GuideService guideService;
    ResultMap resultMap=new ResultMap();
    private List<Integer> idList;

    /**
     * 分页展示所有信息
     * @return
     */
    @ApiOperation(notes="分页查询指南申报信息",value = "获取指南申报信息" )
    @GetMapping(value = "getCollectionByParam")
    public ResultMap getGuideInfoPageList(String guideName, Integer domain, Integer category,String fillUnit,String fillContacts,String contactPhone, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize")int pageSize){
        List<Map> guideCollectionList= guideService.getCollectionByParam(guideName,domain,category,fillUnit,fillContacts,contactPhone,pageNum,pageSize);
        return guideCollectionList.size()>0?resultMap.success().message(guideCollectionList):resultMap.fail().message("查询失败");
    }

    /**
     * 新增信息
     * @param guideCollection
     * @return
     */
    @ApiOperation(notes="新增指南申报信息", value = "新增信息")
    @PostMapping(value = "insertGuideInfo")
    public ResultMap insertGuideInfo(GuideCollection guideCollection){
        return resultMap= guideService.insertGuideInfo(guideCollection);
    }

    @ApiOperation(notes="显示类别和领域信息",value = "获取类别和领域信息")
    @GetMapping(value = "getCategoryAndDomain")
    public ResultMap getCategoryAndDomain(){
        return guideService.getCategoryAndDomain().size()>0?resultMap.success().message(guideService.getCategoryAndDomain()):resultMap.fail().message("查询失败");
    }

    @ApiOperation(notes = "更新限制指南申报时间",value = "更新时间")
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
    @PostMapping(value = "insertSummary")
    public ResultMap insertSummary(GuideSummary guideSummary
    ){
        return resultMap= guideService.insertSummary(guideSummary);
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
    @ApiOperation(value = "分页展示汇总信息(有bug)")
    @GetMapping(value = "getAllSummary")
    public ResultMap getSummaryByParam(String guideSummaryTitle,String fillUnit,Integer domain, Integer category, String projectTime, String researchContentTechnology,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        List<Map> guideSummaryList=guideService.getSummaryByParam(guideSummaryTitle,fillUnit,domain,category,projectTime,researchContentTechnology,pageNum,pageSize);
        return guideSummaryList.size()>0?resultMap.success().message(guideSummaryList):resultMap.fail().message("查询失败");
    }

    @ApiOperation(value = "根据单位id展示相应单位指南(注意:传的是单位id,不是指南申报id)")
    @GetMapping(value = "getCollectionByUd")
    public  ResultMap getCollectionByUid(int id) {
        List<Map> getCollectionList=guideService.getCollectionByUid(id);
        return getCollectionList.size()>0?resultMap.success().message(getCollectionList):resultMap.fail().message("查询失败");
    }

    /**
     * 根据汇总获取的id查询申报
     * @param
     * @return
     */
    @ApiOperation(value = "根据汇总获取的id查询申报(注意:传的是指南申报id,不是汇总表id)--存在bug")
    @GetMapping(value = "getCollectionById")
    public List<Map> getCollectionById(@RequestBody(required = false) List<Integer> idList){
        return guideService.getCollectionById(idList);
    }
}
