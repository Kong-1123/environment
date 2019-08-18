package com.xdmd.environment.dailymanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectProgressService {
    /**
     * [新增] 课题进展主体
     * @author Kong
     * @date 2019/08/14
     **/
    ResultMap insert(ProjectProgressDTO progressDTO);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/08/14
     **/
    ResultMap getInfoById(int id);

    /**
     * [查詢] 根據参数查詢
     * @param subjectName
     * @param bearerUnit
     * @param progress
     * @return
     */
    ResultMap getInfoByParam(String subjectName,String bearerUnit,Integer progress);


    /**
     * [新增] 合同要求研发任务【课题进展第一部分】
     * @param contractResearchDevelopmentTasks
     * @return
     */
    ResultMap insertCRDT(List<ContractResearchDevelopmentTasksDTO> contractResearchDevelopmentTasks);

    /**
     * [查詢] 根據课题进展id查詢【课题进展第一部分】
     * @param Pid
     * @return
     */
    ResultMap getCRDTByPid(int Pid);


    /**
     * [新增]目前进展情况【课题进展第二部分】
     * @param currentProgress
     * @return
     */
    ResultMap insertCP(List<CurrentProgressDTO> currentProgress);

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    ResultMap getCPByPid(@Param("Pid") int Pid);
    /**
     * [新增] 课题实施中存在的主要问题【课题进展第四部分】
     * @param projectMainProblems
     * @return
     */
    ResultMap insertPMP(List<ProjectMainProblemsDTO> projectMainProblems);

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    ResultMap getPMPByPid(@Param("Pid") int Pid);

    /**
     * [新增] 下一步工作计划【课题进展第五部分】
     * @param nextWorkPlan
     * @return
     */
    ResultMap insertNWP(List<NextWorkPlanDTO> nextWorkPlan);

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    ResultMap getNWPByPid(@Param("Pid") int Pid);

    /**
     * 根据课题进展主表id更新上传附件id
     * @param openReportAnnexId
     * @param subjectProgressAnnexId
     * @param fundProgressAnnexId
     * @param expertSuggestAnnexId
     * @param pid
     * @return
     */
    ResultMap updateSubjectProgressByPid(int openReportAnnexId, int subjectProgressAnnexId, int fundProgressAnnexId, int expertSuggestAnnexId, int pid);
}
