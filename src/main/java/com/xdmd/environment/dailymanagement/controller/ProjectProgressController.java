package com.xdmd.environment.dailymanagement.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import com.xdmd.environment.dailymanagement.pojo.*;
import com.xdmd.environment.dailymanagement.service.ProjectProgressService;
import com.xdmd.environment.contractmanage.mapper.UploadMapper;
import com.xdmd.environment.common.UploadFile;
import com.xdmd.environment.common.FileSuffixJudge;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/14
 * @description: 课题进展接口
 */
@Api(tags = "课题进展接口")
@RestController
@RequestMapping("/environment/progress")
public class ProjectProgressController {
    @Autowired
    ProjectProgressService projectProgressService;
    @Autowired
    UploadMapper uploadMapper;


    UploadFile uploadFile=new UploadFile();
    ResultMap resultMap=new ResultMap();

    /**
     * [新增] 课题进展主体
     * @param progressDTO
     * @return
     */
    @ApiOperation(value = "新增课题进展主体")
    @PostMapping("insertProgress")
    public ResultMap insert(ProjectProgressDTO progressDTO) {
       return resultMap=projectProgressService.insert(progressDTO);
    }

    /**
     *  [查詢] 根據id查詢课题进展主体
     * @param id
     * @return
     */
    @ApiOperation(value = "根據id查詢课题进展主体")
    @GetMapping ("getInfoById")
    public ResultMap getInfoById(int id) {
        return resultMap=projectProgressService.getInfoById(id);
    }

    /**
     * [查詢] 根據参数查詢
     * @param subjectName
     * @param bearerUnit
     * @param progress
     * @return
     */
    @ApiOperation(value = "根據参数查詢课题进展主体")
    @ApiImplicitParams({
            @ApiImplicitParam(name="subjectName",value = "课题名称",dataType = "string"),
            @ApiImplicitParam(name="bearerUnit",value = "承担单位",dataType = "string"),
            @ApiImplicitParam(name="progress",value = "课题进展类型【45-超前 46-正常 47-滞后】",dataType = "int"),
    })
    @GetMapping("getInfoByParam")
    public ResultMap getInfoByParam(String subjectName,String bearerUnit,Integer progress) {
        return  resultMap=projectProgressService.getInfoByParam(subjectName,bearerUnit,progress);
    }


    /**
     * [新增] 合同要求研发任务【课题进展第一部分】
     * @param contractResearchDevelopmentTasks
     * @return
     */
    @ApiOperation(value = "新增合同要求研发任务【课题进展第一部分】")
    @PostMapping("insertCRDT")
    public ResultMap insertCRDT(@RequestBody List<ContractResearchDevelopmentTasksDTO> contractResearchDevelopmentTasks){
        return  resultMap=projectProgressService.insertCRDT(contractResearchDevelopmentTasks);
    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第一部分】
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第一部分】")
    @GetMapping ("getCRDTByPid")
    public ResultMap getCRDTByPid(int Pid){
        return  resultMap=projectProgressService.getCRDTByPid(Pid);
    }


    /**
     * [新增]目前进展情况【课题进展第二部分】
     * @param currentProgress
     * @return
     */
    @ApiOperation(value = "新增目前进展情况【课题进展第二部分】")
    @PostMapping("insertCP")
    public ResultMap insertCP(@RequestBody List<CurrentProgressDTO> currentProgress){
        return  resultMap=projectProgressService.insertCP(currentProgress);

    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第二部分】
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第二部分】")
    @GetMapping ("getCPByPid")
    public ResultMap getCPByPid(int Pid){
        return  resultMap=projectProgressService.getCPByPid(Pid);

    }
    /**
     * [新增] 课题实施中存在的主要问题【课题进展第四部分】
     * @param projectMainProblemsDTO
     * @return
     */
    @ApiOperation(value = "新增课题实施中存在的主要问题【课题进展第四部分】")
    @PostMapping("insertPMP")
    public ResultMap insertPMP(@RequestBody List<ProjectMainProblemsDTO> projectMainProblemsDTO){
        return  resultMap=projectProgressService.insertPMP(projectMainProblemsDTO);
    }

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第四部分】")
    @GetMapping ("getPMPByPid")
    public ResultMap getPMPByPid(int Pid){
        return  resultMap=projectProgressService.getPMPByPid(Pid);
    }

    /**
     * [新增] 下一步工作计划【课题进展第五部分】
     * @param nextWorkPlanDTO
     * @return
     */
    @ApiOperation(value = "新增下一步工作计划【课题进展第五部分】")
    @PostMapping("insertNWP")
    public ResultMap insertNWP(@RequestBody List<NextWorkPlanDTO> nextWorkPlanDTO){
        return  resultMap=projectProgressService.insertNWP(nextWorkPlanDTO);
    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第五部分】
     * @param Pid
     * @return
     */
    @ApiOperation(value = "根據id查詢【课题进展第五部分】")
    @GetMapping ("getNWPByPid")
    public ResultMap getNWPByPid(int Pid){
        return  resultMap=projectProgressService.getNWPByPid(Pid);
    }

    /**
     * 根据课题进展主表id更新上传附件id
     * @param openReportAnnexId
     * @param subjectProgressAnnexId
     * @param fundProgressAnnexId
     * @param expertSuggestAnnexId
     * @param pid
     * @return
     */
    @PostMapping ("updateSubjectProgressByPid")
    @ApiOperation(value = "根据课题进展主表id更新上传附件id")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "openReportAnnexId",value = "开题报告附件id",dataType ="int"),
        @ApiImplicitParam(name = "subjectProgressAnnexId",value = "课题进展情况附件id",dataType ="int"),
        @ApiImplicitParam(name = "fundProgressAnnexId",value = "经费进展情况附件id",dataType ="int"),
        @ApiImplicitParam(name = "expertSuggestAnnexId",value = "专家意见附件id",dataType ="int"),
        @ApiImplicitParam(name = "pid",value = "课题进展id",dataType ="int"),

    })
    public ResultMap updateSubjectProgressByPid(int openReportAnnexId, int subjectProgressAnnexId, int fundProgressAnnexId, int expertSuggestAnnexId, int pid){
        return  resultMap=projectProgressService.updateSubjectProgressByPid(openReportAnnexId,subjectProgressAnnexId,fundProgressAnnexId,expertSuggestAnnexId,pid);
    }


    @PostMapping("subjectfileupload")
    @ApiOperation(value = "课题进展情况附件上传")
    public String fileUpload(@RequestParam("fileName") MultipartFile file) throws IOException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }

        // 获取文件名拼接当前系统时间作为新文件名
        String nowtime =  new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis());
        StringBuilder pinjiefileName=new StringBuilder(nowtime).append(file.getOriginalFilename());
        String fileName =pinjiefileName.toString();

        //获取课题名称
        ContractManageDTO contractManageDTO=new ContractManageDTO();
        String ketiName=contractManageDTO.getSubjectName();
        //获取文件上传绝对路径
        String FilePath = "D:/xdmd/environment/" +ketiName+ "/课题进展情况附件/";
        StringBuilder initPath = new StringBuilder(FilePath);
        String filePath=initPath.append(fileName).toString();
        System.out.println("文件路径-->"+filePath);
        File dest = new File(filePath);

        //获取文件类型
        String contentType = file.getContentType();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //判断上传文件类型是否符合要求
        Boolean typeIsOK= FileSuffixJudge.suffixJudge(file.getOriginalFilename());
        if (typeIsOK==false){
            return "上传的文件类型不符合要求";
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            //保存文件
            file.transferTo(dest);
            // 获取文件大小
            File file1 = new File(filePath);
            String fileSize = String.valueOf(file1.length());
            System.out.println(fileName+"的文件大小-->"+fileSize);
            //封装到uploadfile
            uploadFile.setUploadFilePath(String.valueOf(dest));
            uploadFile.setFileSize(fileSize);
            uploadFile.setUploadFileName(fileName);
            uploadFile.setUploadFileType(contentType);
            uploadFile.setUploadSuffixName(suffixName);
            uploadFile.setCreateAuthor("创建者");
            //文件信息保存到数据库
            uploadMapper.insertUpload(uploadFile);
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败";
    }






}
