package com.xdmd.environment.subjectAcceptance.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectAcceptance.exception.StringToDateException;
import com.xdmd.environment.subjectAcceptance.pojo.CheckApply;
import com.xdmd.environment.subjectAcceptance.service.AcceptApplyService;
import com.xdmd.environment.subjectAcceptance.utils.FileUpload;
import com.xdmd.environment.subjectAcceptance.utils.RarFileUpload;
import com.xdmd.environment.subjectAcceptance.utils.UpdateFileUpload;
import com.xdmd.environment.subjectAcceptance.utils.UpdateRarFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("apply")
public class AcceptApplyController {

    @Autowired
    AcceptApplyService acceptApplyService;
    ResultMap resultMap = new ResultMap();
    private static Logger log = LoggerFactory.getLogger(AcceptApplyController.class);


    //员工填写验收申请表
    @ResponseBody
    @PostMapping("addAcceptApply")
    public ResultMap AddAcceptApply(@RequestParam("agreementStartTimeString") String agreementStartTimeString,  //合同开始时间
                                    @RequestParam("agreementEndTimeString") String agreementEndTimeString,      //合同结束时间
                                    @RequestParam("applicationAcceptanceTimeString") String applicationAcceptanceTimeString,    //验收申请时间
                                    @RequestParam("submitInventoryFile") MultipartFile submitInventoryFile,     //提交清单文件
                                    @RequestParam("applicationAcceptanceFile") MultipartFile applicationAcceptanceFile,     //验收申请表文件
                                    @RequestParam("achievementsFile") MultipartFile achievementsFile,   //成果附件文件
                                    @Valid CheckApply checkApply, BindingResult result) {
        if (StringUtils.isEmpty(agreementStartTimeString) || StringUtils.isEmpty(agreementEndTimeString) || StringUtils.isEmpty(applicationAcceptanceTimeString)) {
            return resultMap.fail().message("日期不能为空");
        }
        if (!submitInventoryFile.getOriginalFilename().contains(".") || !applicationAcceptanceFile.getOriginalFilename().contains(".") || !achievementsFile.getOriginalFilename().contains(".")) {
            return resultMap.fail().message("上传的文件不可以为空");
        }

        //定义接收的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把接收到的String类型 日期 数据转换成制定格式 由Util.Date 再转换成sql.Date
            Date dateAgreementStartTime = sdf.parse(agreementStartTimeString);
            long timeAgreementStartTime = dateAgreementStartTime.getTime();
            java.sql.Date sqlAgreementStartTime = new java.sql.Date(timeAgreementStartTime);
            checkApply.setAgreementStartTime(sqlAgreementStartTime);

            Date dateAgreementEndTime = sdf.parse(agreementEndTimeString);
            long timeAgreementEndTime = dateAgreementEndTime.getTime();
            java.sql.Date sqlAgreementEndTime = new java.sql.Date(timeAgreementEndTime);
            checkApply.setAgreementEndTime(sqlAgreementEndTime);

            Date dateApplicationAcceptanceTime = sdf.parse(applicationAcceptanceTimeString);
            long timeApplicationAcceptanceTime = dateApplicationAcceptanceTime.getTime();
            java.sql.Date sqlApplicationAcceptanceTime = new java.sql.Date(timeApplicationAcceptanceTime);
            checkApply.setApplicationAcceptanceTime(sqlApplicationAcceptanceTime);

        } catch (ParseException e) {
            e.printStackTrace();
            log.error("AcceptApplyController  -- 日期类型错误" + e.getMessage());
            return resultMap.fail().message("日期类型错误");
        }
        //用于判断用户传输的参数是否有误
        if (result.hasErrors()) {
            List<ObjectError> ls = result.getAllErrors();
            String errorMessage = ls.get(0).getDefaultMessage();
            return resultMap.fail().message(errorMessage);
        }

        //验收申请表文件的上传与判断
        HashMap<String, String> FileResult = FileUpload.fileUpload(applicationAcceptanceFile, "公司名", "验收申请表");
        Set<String> keys = FileResult.keySet();
        for (String key : keys) {
            if (key.equals("1")) {
                return resultMap.fail().message(FileResult.get("1"));
            } else if (key.equals("0")) {
                String applicationAcceptanceFilePath = FileResult.get("0");
                checkApply.setApplicationAcceptanceUrl(applicationAcceptanceFilePath);
            }
        }

        //成果附件的上传与判断
        HashMap<String, String> FileResult2 = FileUpload.fileUpload(achievementsFile, "公司名", "成果附件");
        Set<String> keys2 = FileResult2.keySet();
        for (String key : keys2) {
            if (key.equals("1")) {
                return resultMap.fail().message(FileResult2.get("1"));
            } else if (key.equals("0")) {
                String achievementsFilePath = FileResult2.get("0");
                checkApply.setAchievementsUrl(achievementsFilePath);
            }
        }

        //提交清单的上传与判断
        HashMap<String, String> FileResult3 = RarFileUpload.rarFileUpload(submitInventoryFile, "公司名", "提交清单文件");
        Set<String> keys3 = FileResult3.keySet();
        for (String key : keys3) {
            if (key.equals("1")) {
                return resultMap.fail().message(FileResult3.get("1"));
            } else if (key.equals("0")) {
                String submitInventoryFilePath = FileResult3.get("0");
                checkApply.setSubmitInventoryUrl(submitInventoryFilePath);
            }
        }

        //获取创建新增该表时间
        Date date = new Date();
        checkApply.setCreateTime(date);
        //获取创建人
        String createname = "创建人";
        checkApply.setCreateAuthor(createname);

        //此时为公司的员工进行提交 审核状态应该为0
        checkApply.setAcceptancePhase(0);

        try {
            resultMap = acceptApplyService.AddAcceptApply(checkApply, submitInventoryFile, applicationAcceptanceFile, achievementsFile, createname);

            /**
             * 再新增一个验收申请与公司的关联表
             */
        } catch (Exception e) {
            e.printStackTrace();
            return resultMap.fail().message("系统异常");
        }
        return resultMap.success().message("新增成功");
    }

    //验收申请表的查询
    @PostMapping("queryAcceptApply")
    @ResponseBody
    public ResultMap queryAcceptApply(@RequestParam(value = "subjectName", required = false) String subjectName,
                                      @RequestParam(value = "projectLeader", required = false) String projectLeader,
                                      @RequestParam("Page") Integer page,
                                      @RequestParam("total") Integer total) {
        if (page <= 0 || total <= 0) {
            return resultMap.fail().message("请返回正确的页数或每页显示条数");
        }
        try {
            //要先获取登陆人对应的公司id  再通过公司的id 对应的申请表id 找到该公司对应的申请表信息
            resultMap = acceptApplyService.queryAcceptApply(subjectName, projectLeader, page, total);
        } catch (StringToDateException e) {
            e.printStackTrace();
            log.error("AcceptAppluController -- queryAcceptApply方法中  StringToDate 转换错误");
            resultMap.fail().message("系统异常");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.fail().message("系统异常");
            return resultMap;
        }
        return resultMap;
    }

    //对验收申请表进行修改
    @ResponseBody
    @PostMapping("UpdateAcceptApply")
    public ResultMap updateAcceptApply(@RequestParam("oldSubmitInventoryFile") String oldSubmitInventoryFile,      //旧的提交清单文件
                                       @RequestParam("oldApplicationAcceptanceFile") String oldApplicationAcceptanceFile, //旧的提交验收申请文件
                                       @RequestParam("oldAchievementsFile") String oldAchievementsFile,  //旧的成果附件
                                       @RequestParam("agreementStartTimeString") String agreementStartTimeString,  //合同开始时间
                                       @RequestParam("agreementEndTimeString") String agreementEndTimeString,      //合同结束时间
                                       @RequestParam("applicationAcceptanceTimeString") String applicationAcceptanceTimeString,    //验收申请时间
                                       @RequestParam("submitInventoryFile") MultipartFile submitInventoryFile,     //提交清单文件
                                       @RequestParam("applicationAcceptanceFile") MultipartFile applicationAcceptanceFile,     //验收申请表文件
                                       @RequestParam("achievementsFile") MultipartFile achievementsFile,   //成果附件文件
                                       @Valid CheckApply checkApply, BindingResult result) {
        if (StringUtils.isEmpty(agreementStartTimeString) || StringUtils.isEmpty(agreementEndTimeString) || StringUtils.isEmpty(applicationAcceptanceTimeString)) {
            return resultMap.fail().message("日期不能为空");
        }
        if (!submitInventoryFile.getOriginalFilename().contains(".") || !applicationAcceptanceFile.getOriginalFilename().contains(".") || !achievementsFile.getOriginalFilename().contains(".")) {
            return resultMap.fail().message("上传的文件不可以为空");
        }
        //用于判断用户传输的参数是否有误
        if (result.hasErrors()) {
            List<ObjectError> ls = result.getAllErrors();
            String errorMessage = ls.get(0).getDefaultMessage();
            return resultMap.fail().message(errorMessage);
        }
        //定义接收的日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把接收到的String类型 日期 数据转换成制定格式 由Util.Date 再转换成sql.Date
            Date dateAgreementStartTime = sdf.parse(agreementStartTimeString);
            long timeAgreementStartTime = dateAgreementStartTime.getTime();
            java.sql.Date sqlAgreementStartTime = new java.sql.Date(timeAgreementStartTime);
            checkApply.setAgreementStartTime(sqlAgreementStartTime);

            Date dateAgreementEndTime = sdf.parse(agreementEndTimeString);
            long timeAgreementEndTime = dateAgreementEndTime.getTime();
            java.sql.Date sqlAgreementEndTime = new java.sql.Date(timeAgreementEndTime);
            checkApply.setAgreementEndTime(sqlAgreementEndTime);

            Date dateApplicationAcceptanceTime = sdf.parse(applicationAcceptanceTimeString);
            long timeApplicationAcceptanceTime = dateApplicationAcceptanceTime.getTime();
            java.sql.Date sqlApplicationAcceptanceTime = new java.sql.Date(timeApplicationAcceptanceTime);
            checkApply.setApplicationAcceptanceTime(sqlApplicationAcceptanceTime);

        } catch (ParseException e) {
            e.printStackTrace();
            log.error("AcceptApplyController  -- 日期类型错误" + e.getMessage());
            return resultMap.fail().message("日期类型错误");
        }

        //验收申请表的重新提交
        HashMap<String, String> file1 = UpdateFileUpload.updateFileUpload(applicationAcceptanceFile, "公司名", "验收申请表", oldApplicationAcceptanceFile);
        Set<String> keys1 = file1.keySet();
        for (String key : keys1) {
            if (key.equals("1")) {
                return resultMap.fail().message(file1.get("1"));
            } else if (key.equals("0")) {
                String achievementsFilePath = file1.get("0");
                checkApply.setApplicationAcceptanceUrl(achievementsFilePath);
            }
        }

        //提交清单文件的重新提交
        HashMap<String, String> file2 = UpdateRarFileUpload.rarFileUpload(submitInventoryFile, "公司名", "提交清单文件", oldSubmitInventoryFile);
        Set<String> keys2 = file2.keySet();
        for (String key : keys2) {
            if (key.equals("1")) {
                return resultMap.fail().message(file2.get("1"));
            } else if (key.equals("0")) {
                String submitInventoryFilePath = file2.get("0");
                checkApply.setSubmitInventoryUrl(submitInventoryFilePath);
            }
        }
        //成果附件的重新提交
        HashMap<String, String> file3 = UpdateFileUpload.updateFileUpload(achievementsFile, "公司名", "成果附件", oldAchievementsFile);
        Set<String> keys3 = file3.keySet();
        for (String key : keys3) {
            if (key.equals("1")) {
                return resultMap.fail().message(file3.get("1"));
            } else if (key.equals("0")) {
                String achievementsFilePath = file3.get("0");
                checkApply.setAchievementsUrl(achievementsFilePath);
            }
        }

        //获取创建新增该表时间
        Date date = new Date();
        checkApply.setCreateTime(date);

        //获取创建人
        String createname = "创建人";
        checkApply.setCreateAuthor(createname);

        //此时为公司的员工进行提交 审核状态应该为0
        checkApply.setAcceptancePhase(0);

        try {
            resultMap = acceptApplyService.updateAcceptApply(checkApply, submitInventoryFile, applicationAcceptanceFile, achievementsFile, createname);
        } catch (Exception e) {
            e.printStackTrace();
            return resultMap.fail().message("系统异常");
        }
        return resultMap;

    }
}
