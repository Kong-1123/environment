package com.xdmd.environment.subjectAcceptance.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xdmd.environment.common.IntegrationFile;
import com.xdmd.environment.common.PageBean;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.common.SqlDateToString;
import com.xdmd.environment.subjectAcceptance.exception.MysqlErrorException;
import com.xdmd.environment.subjectAcceptance.exception.StringToDateException;
import com.xdmd.environment.subjectAcceptance.mapper.AcceptApplyFileUploadMapper;
import com.xdmd.environment.subjectAcceptance.mapper.AcceptApplyMapper;
import com.xdmd.environment.subjectAcceptance.pojo.CheckApply;
import com.xdmd.environment.subjectAcceptance.pojo.UploadFile;
import com.xdmd.environment.subjectAcceptance.service.AcceptApplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class AcceptApplyServiceImpl implements AcceptApplyService {
    @Autowired
    private AcceptApplyMapper acceptApplyMapper;
    @Autowired
    private AcceptApplyFileUploadMapper acceptApplyFileUploadMapper;
    ResultMap resultMap = new ResultMap();
    //打印日志
    private static Logger log = LoggerFactory.getLogger(AcceptApplyServiceImpl.class);

    //企业填写验收申请表
    @Transactional(rollbackFor = Exception.class)
    public ResultMap AddAcceptApply(CheckApply checkApply, MultipartFile submitInventoryFile, MultipartFile applicationAcceptanceFile, MultipartFile achievementsFile, String createname) throws MysqlErrorException {

        int number = 0;
        int number2 = 0;
        int number3 = 0;
        int number4 = 0;
        try {
            number = acceptApplyMapper.insertSelective(checkApply);

            //把上传的文件上传到文件表
            //验收申请表的上传
            IntegrationFile applicationAcceptanceIntegrationFile = new IntegrationFile();
            UploadFile applicationUploadFile = applicationAcceptanceIntegrationFile.IntegrationFile(applicationAcceptanceFile, checkApply.getId(), checkApply.getApplicationAcceptanceUrl(), "验收申请表", createname);
            number2 = acceptApplyFileUploadMapper.insertSelective(applicationUploadFile);

            //成果附件的上传
            IntegrationFile achievementsUploadFile = new IntegrationFile();
            UploadFile achievementsUploadFile2 = achievementsUploadFile.IntegrationFile(achievementsFile, checkApply.getId(), checkApply.getAchievementsUrl(), "成果附件", createname);
            number3 = acceptApplyFileUploadMapper.insertSelective(achievementsUploadFile2);

            //提交清单的上传
            IntegrationFile submitInventoryUploadFile = new IntegrationFile();
            UploadFile submitUploadFile = submitInventoryUploadFile.IntegrationFile(submitInventoryFile, checkApply.getId(), checkApply.getSubmitInventoryUrl(), "提交清单", createname);
            number4 = acceptApplyFileUploadMapper.insertSelective(submitUploadFile);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("AcceptApplyServiceImpl -- AddAcceptApply 中查询语句出错");
            throw new MysqlErrorException();
        }
        if (number == 0 || number2 == 0 || number3 == 0 || number4 == 0) {
            resultMap.fail().message("新增失败");
        } else {
            resultMap.success().message("新增成功");
        }
        return resultMap;
    }

    //企业修改验收申请表
    @Transactional(rollbackFor = Exception.class)
    public ResultMap updateAcceptApply(CheckApply checkApply, MultipartFile submitInventoryFile, MultipartFile applicationAcceptanceFile, MultipartFile achievementsFile, String createname) throws MysqlErrorException {
        int number = 0;
        int number2 = 0;
        int number3 = 0;
        int number4 = 0;
        try {
            number = acceptApplyMapper.updateByPrimaryKey(checkApply);

            //把上传的文件上传到文件表
            //验收申请表的上传
            IntegrationFile applicationAcceptanceIntegrationFile = new IntegrationFile();
            UploadFile applicationUploadFile = applicationAcceptanceIntegrationFile.IntegrationFile(applicationAcceptanceFile, checkApply.getId(), checkApply.getApplicationAcceptanceUrl(), "验收申请表", createname, checkApply.getApplicationId());
            number2 = acceptApplyFileUploadMapper.updateByPrimaryKey(applicationUploadFile);

            //成果附件的上传
            IntegrationFile achievementsUploadFile = new IntegrationFile();
            UploadFile achievementsUploadFile2 = achievementsUploadFile.IntegrationFile(achievementsFile, checkApply.getId(), checkApply.getAchievementsUrl(), "成果附件", createname, checkApply.getAchievementId());
            number3 = acceptApplyFileUploadMapper.updateByPrimaryKey(achievementsUploadFile2);

            //提交清单的上传
            IntegrationFile submitInventoryUploadFile = new IntegrationFile();
            UploadFile submitUploadFile = submitInventoryUploadFile.IntegrationFile(submitInventoryFile, checkApply.getId(), checkApply.getSubmitInventoryUrl(), "提交清单", createname, checkApply.getSubmitId());
            number4 = acceptApplyFileUploadMapper.updateByPrimaryKey(submitUploadFile);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("AcceptApplyServiceImpl -- updateAcceptApply 中更新语句出错");
            throw new MysqlErrorException();
        }
        if (number == 0 || number2 == 0 || number3 == 0 || number4 == 0) {
            resultMap.fail().message("更新失败");
        } else {
            resultMap.success().message("更新成功");
        }
        return resultMap;
    }

    //验收申请表的查询
    public ResultMap queryAcceptApply(String subjectName, String projectLeader, Integer page, Integer total) throws StringToDateException {
        //页数
        int newpage = 0;
        if (page == 1) {
            newpage = page - 1;
        } else {
            newpage = (page - 1) * total;
        }

        List<CheckApply> checkApplyList = acceptApplyMapper.queryAcceptApply(subjectName, projectLeader, newpage, total);
        Integer alltotal = acceptApplyMapper.queryAllTotal(subjectName, projectLeader, newpage, total);

        List<JSONObject> jsonObjectList = new ArrayList<>();

        //判断根据用户输入的筛选条件是否有内容
        if(alltotal==null){
            return resultMap.success().message(jsonObjectList);
        }

        //判断用户输入的页数是否超过总页数
        int allPage = 0;
        if (alltotal % page == 0) {
            allPage = alltotal / page;
        } else {
            allPage = (alltotal / page) + 1;
        }
        if(page>allPage){
            return resultMap.fail().message("页数超过总页数");
        }


        for (CheckApply checkApply : checkApplyList) {
            //对查询出来的日期进行处理
            Date agreementStartTime = checkApply.getAgreementStartTime();
            String agreementStartTimeString = SqlDateToString.dateToString(agreementStartTime);

            Date agreementEndTime = checkApply.getAgreementEndTime();
            String agreementEndTimeString = SqlDateToString.dateToString(agreementEndTime);

            Date applicationAcceptanceTime = checkApply.getApplicationAcceptanceTime();
            String applicationAcceptanceTimeString = SqlDateToString.dateToString(applicationAcceptanceTime);

            //获取申请表的主键
            Integer id = checkApply.getId();

            String AcceptApplyFile = "验收申请表";
            String submitInventoryFile = "提交清单";
            String achievementsFile = "成果附件";


            //验收申请表
            UploadFile uploadFile1 = acceptApplyFileUploadMapper.queryFileUrl(id, AcceptApplyFile);
            checkApply.setApplicationId(uploadFile1.getId());
            checkApply.setApplicationAcceptanceUrl(uploadFile1.getUploadFileAddress());

            //提交清单
            UploadFile uploadFile2 = acceptApplyFileUploadMapper.queryFileUrl(id, submitInventoryFile);
            checkApply.setSubmitId(uploadFile2.getId());
            checkApply.setSubmitInventoryUrl(uploadFile2.getUploadFileAddress());

            //成果附件
            UploadFile uploadFile3 = acceptApplyFileUploadMapper.queryFileUrl(id, achievementsFile);
            checkApply.setAchievementId(uploadFile3.getId());
            checkApply.setAchievementsUrl(uploadFile3.getUploadFileAddress());


            //通过AliBaBa fastJson工具 把实体类中不需要的字段去除
            JSONObject jsonObject = JSON.parseObject(checkApply.toString());
            jsonObject.put("agreementStartTimeString",agreementStartTimeString);
            jsonObject.put("agreementEndTimeString",agreementEndTimeString);
            jsonObject.put("applicationAcceptanceTimeString",applicationAcceptanceTimeString);

            jsonObjectList.add(jsonObject);

        }
        PageBean<Object> objectPageBean = new PageBean<>();
        objectPageBean.setData(jsonObjectList);
        objectPageBean.setCount(alltotal);


        resultMap.success().message(objectPageBean);
        return resultMap;
    }
}
