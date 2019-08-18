package com.xdmd.environment.guidemanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.service.GuideService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/07/16
 * @description: 指南管理接口
 */
@Api(tags="指南管理")
@RestController
@RequestMapping(value = "/environment/guide/")
public class GuideController {
    @Autowired
    GuideService guideService;
    ResultMap resultMap=new ResultMap();

    @ApiOperation(value = "新增指南申报信息")
    @PostMapping(value = "insertGuideInfo")
    public ResultMap insertGuideInfo(@RequestBody GuideCollection guideCollection){
        return resultMap=guideService.insertGuideInfo(guideCollection);
    }

    @ApiOperation(value = "分页查询指南申报信息【内网】" )
    @GetMapping(value = "getCollectionByParam")
    @ApiImplicitParams({
            @ApiImplicitParam(name="guideName",value = "指南建议申报名称",dataType = "string"),
            @ApiImplicitParam(name="domain",value = "所属领域",dataType = "int"),
            @ApiImplicitParam(name="category",value = "所属类别",dataType = "int"),
            @ApiImplicitParam(name="fillContacts",value = "填报联系人",dataType = "string"),
            @ApiImplicitParam(name="fillUnit",value = "填报单位",dataType = "string"),
            @ApiImplicitParam(name="contactPhone",value = "填报联系人电话（手机）",dataType = "string"),
            @ApiImplicitParam(name="pageNum",value = "当前页数",dataType = "int",required = true),
            @ApiImplicitParam(name="pageSize",value = "每页显示条数",dataType = "int",required = true)
    })
    public ResultMap getGuideInfoPageList(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone,int pageNum,int pageSize){
       return resultMap= guideService.getCollectionByParam(guideName,domain,category,fillUnit,fillContacts,contactPhone,pageNum,pageSize);
    }


    @ApiOperation(notes="显示所属类别和领域",value = "获取所有类别和领域信息")
    @GetMapping(value = "getCategoryAndDomain")
    public ResultMap getCategoryAndDomain(){
        return resultMap=guideService.getCategoryAndDomain();
    }

    @ApiOperation(notes = "更新限制指南申报时间",value = "更新时间")
    @PostMapping(value = "update/limitime")
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime){
        return resultMap= guideService.updateLimitTime(guideCollectionLimitTime);
    }

    /**
     * 根据单位id查询
     * @param Uid
     * @return
     */
    @ApiOperation(value = "根据单位id展示相应单位指南(注意:传的是单位id,不是指南申报id)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="guideName",value = "指南建议申报名称",dataType = "string"),
            @ApiImplicitParam(name="domain",value = "所属领域",dataType = "int"),
            @ApiImplicitParam(name="category",value = "所属类别",dataType = "int"),
            @ApiImplicitParam(name="fillContacts",value = "填报联系人",dataType = "string"),
            @ApiImplicitParam(name="fillUnit",value = "填报单位",dataType = "string"),
            @ApiImplicitParam(name="contactPhone",value = "填报联系人电话（手机）",dataType = "string"),
            @ApiImplicitParam(name="Uid",value = "单位id",dataType = "int",required = true),
            @ApiImplicitParam(name="pageNum",value = "当前页数",dataType = "int",required = true),
            @ApiImplicitParam(name="pageSize",value = "每页显示条数",dataType = "int",required = true)
    })
    @GetMapping(value = "getCollectionByUid")
    public  ResultMap getCollectionByUid(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone,int Uid,int pageNum,int pageSize) {
        return  resultMap=guideService.getCollectionByUid(guideName,domain,category,fillUnit,fillContacts,contactPhone,Uid,pageNum,pageSize);
    }

    /**
     * [新增]单位关联指南征集
     * @param unitId
     * @param collectionId
     * @return
     */
    @PostMapping(value = "insertUCid")
    @ApiOperation(value = "新增单位关联指南征集【备用】")
    public ResultMap insert(int unitId, int collectionId){
        return resultMap=guideService.insert(unitId,collectionId);
    }

    /**
     * 根据勾选获取的id查询指南申报
     * @param ids
     * @return
     */
    @PostMapping(value = "getCollectionByIds")
    @ApiOperation(value = "根据勾选的指南申报的id集合查询申报信息(注意:传的是指南申报id,不是汇总表id)")
    public ResultMap getCollectionByIds(@ApiParam("指南id集合") @RequestBody List<Long> ids){
        if(ids != null && !ids.equals("") && !ids.equals("null")){
             resultMap=guideService.getCollectionByIds(ids);
        }
        return resultMap;
    }

    /**
     * 新增汇总信息【单条插入】
     * @param guideSummary
     * @return
     */
    @ApiOperation(value = "新增汇总信息",notes = "【单条插入】")
    @PostMapping(value = "insertSummary")
    public ResultMap insertSummary(@RequestBody GuideSummary guideSummary){
        return resultMap= guideService.insertSummary(guideSummary);
    }

    /**
     * 新增汇总信息实现【批量插入】
     * @param guideSummary
     * @return
     */
    @PostMapping(value = "batchInsertSummary")
    @ApiOperation(value = "批量新增汇总信息")
    public ResultMap batchInsertSummary(@RequestBody List<GuideSummary> guideSummary){
        if(guideSummary != null && !guideSummary.equals("") && !guideSummary.equals("null")){
            resultMap=guideService.batchInsertSummary(guideSummary);
        }
        return resultMap;
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
    @GetMapping(value = "getAllSummary")
    @ApiOperation(value = "分页展示汇总信息(bug:模糊查询立项时间有问题)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="guideSummaryTitle",value = "汇总标题",dataType = "string"),
            @ApiImplicitParam(name="fillUnit",value = "填报单位",dataType = "string"),
            @ApiImplicitParam(name="domain",value = "所属领域",dataType = "int"),
            @ApiImplicitParam(name="category",value = "所属类别",dataType = "int"),
            @ApiImplicitParam(name="projectTime",value = "立项时间",dataType = "string"),
            @ApiImplicitParam(name="researchContentTechnology",value = "主要研究内容和关键技术[300字以内]",dataType = "string"),
            @ApiImplicitParam(name="pageNum",value = "当前页数",dataType = "int",required = true),
            @ApiImplicitParam(name="pageSize",value = "每页显示条数",dataType = "int",required = true)
    })
    public ResultMap getSummaryByParam(String guideSummaryTitle,String fillUnit,Integer domain,Integer category,String projectTime,String researchContentTechnology,int pageNum,int pageSize){
        return resultMap=guideService.getSummaryByParam(guideSummaryTitle,fillUnit,domain,category,projectTime,researchContentTechnology,pageNum,pageSize);
    }

    /**
     * 实现根据汇总标题查询汇总信息【内网】
     * @param guideSummaryTitle
     * @return
     */
    @GetMapping(value = "getSummaryByTitle")
    @ApiOperation(value = "实现根据汇总标题查询汇总信息【内网】")
    @ApiImplicitParam(name="guideSummaryTitle",value = "汇总标题",dataType = "string")
    public ResultMap getSummaryByGuideSummaryTitle(@RequestParam("guideSummaryTitle") String guideSummaryTitle){
        return resultMap=guideService.getSummaryByGuideSummaryTitle(guideSummaryTitle);

    }
}
