package com.xdmd.environment.subjectAcceptance.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectAcceptance.exception.MysqlErrorException;
import com.xdmd.environment.subjectAcceptance.exception.StringToDateException;
import com.xdmd.environment.subjectAcceptance.pojo.CheckApply;
import org.springframework.web.multipart.MultipartFile;

public interface AcceptApplyService {
    //验收申请表的查询
   // ResultMap queryAcceptApply() throws StringToDateException;
    //企业填写验收申请表
    ResultMap AddAcceptApply(CheckApply checkApply, MultipartFile submitInventoryFile, MultipartFile applicationAcceptanceFile, MultipartFile achievementsFile, String createname) throws MysqlErrorException;

    //企业修改验收申请表
    ResultMap updateAcceptApply(CheckApply checkApply, MultipartFile submitInventoryFile, MultipartFile applicationAcceptanceFile, MultipartFile achievementsFile, String createname) throws MysqlErrorException;

    //验收申请表的查询
    ResultMap queryAcceptApply(String subjectName, String projectLeader, Integer page, Integer total)throws StringToDateException;

}
