package com.xdmd.environment.dailymanagement.mapper;

import com.xdmd.environment.dailymanagement.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/14
 * @description: 课题进展报告
 */
@Repository
public interface ProjectProgressMapper {
    /**
     * [新增] 课题进展主体
     * @author Kong
     * @date 2019/08/14
     **/
    @Insert(value = "INSERT INTO project_progress\t" +
            "VALUES(" +
            "DEFAULT," +
            "#{bearerUnit}," +
            "#{subjectName}," +
            "#{subjectNo}," +
            "#{projectLeader}," +
            "#{projectLeaderPhone}," +
            "#{primaryContacts}," +
            "#{primaryContactsPhone}," +
            "#{progress}," +
            "#{progressCompletedPercentage}," +
            "#{totalFundsInplace}," +
            "#{projectFundsUsed}," +
            "#{totalFunding}," +
            "#{provincialEnvironmentalFundsUsed}," +
            "#{provincialEnvironmentalFundsPercent}," +
            "#{contractAgreedClosingTime}," +
            "#{isComplateContract}," +
            "#{estimatedAcceptanceTime}," +
            "#{unitAuditComments}," +
            "#{openReportAttachment}," +
            "#{expertOpinionAnnex}," +
            "#{progressReportAnnex}," +
            "#{subjectProgressAnnex}," +
            "DEFAULT)")
    int insert(ProjectProgressDTO progressDTO);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/08/14
     **/
    @Select(value = "select * from project_progress where id=#{id}")
    ProjectProgressDTO getInfoById(int id);



    /**
     * [查詢] 根據参数查詢
     * @param subjectName
     * @param bearerUnit
     * @param progress
     * @return
     */
    @Select(value = "<script>" +
            "SELECT\n" +
            "subject_name,\n" +
            "bearer_unit,\n" +
            "progress,\n" +
            "commit_time\n" +
            "FROM\n" +
            "project_progress\n" +
            "<where>" +
            "<if test ='null != subjectName'>" +
            "subject_name like CONCAT('%',#{subjectName},'%')" +
            "</if>" +
            "<if test ='null != bearerUnit'>" +
            "AND bearer_unit like CONCAT('%',#{bearerUnit},'%')" +
            "</if>" +
            "<if test ='null != progress'>" +
            "AND progress =#{progress}" +
            "</if></where>" +
            "</script>")
    List<ProjectProgressDTO> getInfoByParam(String subjectName,String bearerUnit,Integer progress);

    //////////////////////////以下是课题进展子表第一部分////////////////////////////////////
    /**
     * [新增] 合同要求研发任务【课题进展第一部分】
     * @author Kong
     * @date 2019/08/14
     **/
    int insert(ContractResearchDevelopmentTasksDTO contractResearchDevelopmentTasksDTO);

    /**
     * [查詢] 根據课题进展id查詢
     * @author Kong
     * @date 2019/08/14
     **/

    ContractResearchDevelopmentTasksDTO getCRDTByPid(int Pid);

    /**
     * [查詢] 查詢
     * @author Kong
     * @date 2019/08/14
     **/
    List<ContractResearchDevelopmentTasksDTO> getAllCRDT();
    //////////////////////////以下是课题进展子表第二部分////////////////////////////////////
    /**
     * [新增] 目前进展情况【课题进展第二部分】
     * @author Kong
     * @date 2019/08/14
     **/
    int insert(CurrentProgressDTO currentProgress);

    /**
     * [查詢] 根據课题进展id查詢
     * @author Kong
     * @date 2019/08/14
     **/
    CurrentProgressDTO getCPByPid(@Param("id") int Pid);

    /**
     * [查詢] 查詢全部
     * @author Kong
     * @date 2019/08/14
     **/
    List<CurrentProgressDTO> getAllCP();
    //////////////////////////以下是课题进展子表第四部分////////////////////////////////////
    /**
     * [新增] 课题实施中存在的主要问题【课题进展第四部分】
     * @author Kong
     * @date 2019/08/14
     **/
    int insert(ProjectMainProblemsDTO projectMainProblemsDTO);

    /**
     * [查詢] 根據课题进展id查詢
     * @author Kong
     * @date 2019/08/14
     **/
    ProjectMainProblemsDTO getPMPByPid(@Param("id") int Pid);

    /**
     * [查詢] 查詢全部
     * @author Kong
     * @date 2019/08/14
     **/
    List<ProjectMainProblemsDTO> getAllPMP();

    //////////////////////////以下是课题进展子表第五部分////////////////////////////////////
    /**
     * [新增] 下一步工作计划【课题进展第五部分】
     * @author Kong
     * @date 2019/08/14
     **/
    int insert(NextWorkPlanDTO nextWorkPlanDTO);

    /**
     * [查詢] 根據课题进展id查詢
     * @author Kong
     * @date 2019/08/14
     **/
    NextWorkPlanDTO getNWPByPid(@Param("id") int Pid);

    /**
     * [查詢] 查詢全部
     * @author Kong
     * @date 2019/08/14
     **/
    List<NextWorkPlanDTO> getAllNWP();
}
