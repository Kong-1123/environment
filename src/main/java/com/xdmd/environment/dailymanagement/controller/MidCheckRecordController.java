package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;
import com.xdmd.environment.dailymanagement.service.MidCheckRecordService;
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
@RestController
@RequestMapping("/dailymanage/midcheck")
public class MidCheckRecordController {
    @Autowired
    MidCheckRecordService midCheckRecordService;
    /**
     * 新增中期检查记录
     * @param midCheckRecord
     * @return
     */
    @PostMapping("/insertMidRecord")
    @ApiOperation(value = "新增中期检查记录")
    public int insertMidRecord(MidCheckRecordDTO midCheckRecord) {
        return midCheckRecordService.insertMidRecord(midCheckRecord);
    }
}
