package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;
import com.xdmd.environment.dailymanagement.service.MidCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description:
 */
@Api(tags = "日常管理")
@RestController
@RequestMapping("/environment/daily")
public class MidCheckController {
    @Autowired
    MidCheckService midCheckService;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增中期检查
     * @param midCheckDTO
     * @return
     */
    @ApiOperation(value = "新增中期检查")
    @PostMapping("addmidcheck")
    public ResultMap insert(MidCheckDTO midCheckDTO) {
        return resultMap= midCheckService.insertMidCheck(midCheckDTO);
    }

    /**
     * [新增] 中期检察记录
     * @param midCheckRecordDTO
     * @return
     */
    @ApiOperation(value = "新增中期检查记录")
    @PostMapping("addmidrecord")
    public ResultMap insert(MidCheckRecordDTO midCheckRecordDTO){
        return  resultMap= midCheckService.insertMidCheckRecord(midCheckRecordDTO);
    }

    /**
     *  [更新] 中期检察记录状态
     * @return
     */
    @ApiOperation(value = "更新中期检查记录状态")
    @PostMapping("updatemidrecord")
    public ResultMap update(){
        return  resultMap= midCheckService.updateMidCheck();
    }


}
