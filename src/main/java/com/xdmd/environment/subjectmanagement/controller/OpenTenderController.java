package com.xdmd.environment.subjectmanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectmanagement.pojo.OpenTender;
import com.xdmd.environment.subjectmanagement.service.OpenTenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/07/26
 * @description: 招标接口
 */
@Api(tags="招标公告接口")
@RestController
@RequestMapping(value = "/environment/tender")
public class OpenTenderController  {
    @Autowired
    OpenTenderService openTenderService;
    ResultMap resultMap=new ResultMap();
    /**
     * 新增招标信息
     * @param openTender
     * @return
     */
    @ApiOperation(value = "新增招标信息")
    @PostMapping(value = "insertTender")
    ResultMap insertTender(OpenTender openTender){
        return openTenderService.insertTender(openTender);

    }

    /**
     * 根據id查詢相应单位的课题
     * @param id
     * @return
     */
    @ApiOperation(value = "根据单位的id查询招标信息（不是招标公告的id）")
    @GetMapping(value = "getTenderById")
    ResultMap getTenderById(int id){
       return openTenderService.getTenderById(id);
    }

    /**
     * 分页查询招标信息
     * @param projectName
     * @param subjectName
     * @param subjectLeader
     * @param leaderContact
     * @return
     */
    @ApiOperation(value = "分页展示招标信息")
    @GetMapping(value = "getAllTender")
    ResultMap getAllTender(String projectName, String subjectName, String subjectLeader, String leaderContact, int pageNum, int pageSize){
      List<OpenTender> openTenderList=openTenderService.getTenderPageList(projectName, subjectName, subjectLeader, leaderContact, pageNum, pageSize);
        return openTenderList.size()>0?resultMap.success().message(openTenderList):resultMap.fail().message("查询失败");
    }
}
