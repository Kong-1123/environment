package com.xdmd.environment.dailymanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.*;
import org.apache.ibatis.annotations.Param;

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
     * @param contractResearchDevelopmentTasksDTO
     * @return
     */
    ResultMap insertCRDT(ContractResearchDevelopmentTasksDTO contractResearchDevelopmentTasksDTO);

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
    ResultMap insertCP(CurrentProgressDTO currentProgress);

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    ResultMap getCPByPid(@Param("Pid") int Pid);
    /**
     * [新增] 课题实施中存在的主要问题【课题进展第四部分】
     * @param projectMainProblemsDTO
     * @return
     */
    ResultMap insertPMP(ProjectMainProblemsDTO projectMainProblemsDTO);

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    ResultMap getPMPByPid(@Param("Pid") int Pid);

    /**
     * [新增] 下一步工作计划【课题进展第五部分】
     * @param nextWorkPlanDTO
     * @return
     */
    ResultMap insertNWP(NextWorkPlanDTO nextWorkPlanDTO);

    /**
     * [查詢] 根據课题进展id查詢
     * @param Pid
     * @return
     */
    ResultMap getNWPByPid(@Param("Pid") int Pid);





































}
