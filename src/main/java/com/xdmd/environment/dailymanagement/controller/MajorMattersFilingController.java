package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.MajorMattersFilingDTO;
import com.xdmd.environment.dailymanagement.service.MajorMattersFilingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 重大事项
 */
@Api(tags = "重大重大事项管理")
@RestController
@RequestMapping("enviroment/daily/major")
public class MajorMattersFilingController {
    @Autowired
    MajorMattersFilingService majorMattersFilingService;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增重大事项变更
     * @param majorMattersFiling
     * @return
     */
    @ApiOperation("新增重大事项变更【外网】")
    @PostMapping("insertMajor")
    public ResultMap insert(@RequestBody MajorMattersFilingDTO majorMattersFiling){
        return  resultMap= majorMattersFilingService.insert(majorMattersFiling);
    }

    /**
     * [更新]重大事项附件id
     * @return
     */
    @ApiOperation("更新重大事项附件【外网】")
    @PostMapping("updateAnnexId")
    public ResultMap updateAnnexId(int changeApplicationAttachmentId,int expertArgumentationAttachmentId,int filingApplicationAttachmentId,int approvalDocumentsAttachmentId,int id){
        return  resultMap= majorMattersFilingService.updateAnnexId(changeApplicationAttachmentId,expertArgumentationAttachmentId, filingApplicationAttachmentId, approvalDocumentsAttachmentId, id);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @ApiOperation("根據主鍵 id 查詢【外网】")
    @GetMapping("getMajorById")
    public ResultMap getMajorById(@Param("id") int id){
        return  resultMap= majorMattersFilingService.getMajorById(id);
    }

    /**
     * [查詢] 分頁查詢【内网】
     * @param offset
     * @param pagesize
     * @return
     */
    @ApiOperation("根據主鍵 id 查詢【外网】")
    @GetMapping("pageList")
    //public ResultMap pageList(@Param("offset") int offset,
    //                   @Param("pagesize") int pagesize){
    //    return  resultMap= majorMattersFilingService.getMajorById(id);
    //}

    /**
     * [查詢] 分頁查詢 count【内网】
     * @param offset
     * @param pagesize
     * @return
     */
    public ResultMap pageListCount(@Param("offset") int offset,
                            @Param("pagesize") int pagesize){
        return  resultMap= majorMattersFilingService.pageListCount(offset,pagesize);
    }

    /**
     * 查询所有调整类型
     * @return
     */
    public ResultMap  AdjustType(){
        return  resultMap= majorMattersFilingService.AdjustType();
    }

    /**
     * 查询所有调整类型
     * @return
     */
   public ResultMap  AdjustmentMatters(){
       return  resultMap= majorMattersFilingService.AdjustType();
   }
}
