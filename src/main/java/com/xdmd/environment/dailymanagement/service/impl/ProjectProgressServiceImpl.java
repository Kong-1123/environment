package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.mapper.ProjectProgressMapper;
import com.xdmd.environment.dailymanagement.pojo.*;
import com.xdmd.environment.dailymanagement.service.ProjectProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/14
 * @description: 课题进展报告实现
 */
@Service
public class ProjectProgressServiceImpl implements ProjectProgressService {
    @Autowired
    ProjectProgressMapper projectProgressMapper;
    ResultMap resultMap=new ResultMap();

    /**
     * [新增] 课题进展主体
     * @param progressDTO
     * @return
     */
    @Override
    public ResultMap insert(ProjectProgressDTO progressDTO) {
        try{
            int insertNo=projectProgressMapper.insert(progressDTO);
            if(insertNo>0){
                resultMap.success().message("新增成功");
            }else if(insertNo==0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;

    }

    /**
     *  [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @Override
    public ResultMap getInfoById(int id) {
        try{
            ProjectProgressDTO progressDTO=projectProgressMapper.getInfoById(id);
            if(progressDTO!=null){
                resultMap.success().message(progressDTO);
            }else if(progressDTO==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;

    }

    /**
     * [查詢] 根據参数查詢
     * @param subjectName
     * @param bearerUnit
     * @param progress
     * @return
     */
    @Override
    public ResultMap getInfoByParam(String subjectName, String bearerUnit, Integer progress) {
        try{
            List<ProjectProgressDTO> progressDTOList=projectProgressMapper.getInfoByParam(subjectName,bearerUnit,progress);
            if(progressDTOList.size()>0){
                resultMap.success().message(progressDTOList);
            }else if(progressDTOList.size()==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [新增] 合同要求研发任务【课题进展第一部分】
     * @author Kong
     * @date 2019/08/14
     **/
    @Override
    public ResultMap insertCRDT(List<ContractResearchDevelopmentTasksDTO> contractResearchDevelopmentTasks) {
        try{
            int insertNo=projectProgressMapper.insertCRDT(contractResearchDevelopmentTasks);
            if(insertNo>0){
                resultMap.success().message("成功新增"+insertNo+"条数据");
            }else if(insertNo==0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第一部分】
     * @param Pid
     * @return
     */
    @Override
    public ResultMap getCRDTByPid(int Pid) {
        try{
            List<ContractResearchDevelopmentTasksDTO> crdt = projectProgressMapper.getCRDTByPid(Pid);
            if(crdt!=null){
                resultMap.success().message(crdt);
            }else if(crdt==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [新增]目前进展情况【课题进展第二部分】
     * @param currentProgress
     * @return
     */
    @Override
    public ResultMap insertCP(List<CurrentProgressDTO> currentProgress) {
        try{
            int insertNo=projectProgressMapper.insertCP(currentProgress);
            if(insertNo>0){
                resultMap.success().message("成功新增"+insertNo+"条数据");
            }else if(insertNo==0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }
    /**
     * [查詢] 根據课题进展id查詢【课题进展第二部分】
     * @param Pid
     * @return
     */
    @Override
    public ResultMap getCPByPid(int Pid) {
        try{
            List<CurrentProgressDTO> cp = projectProgressMapper.getCPByPid(Pid);
            if(cp!=null){
                resultMap.success().message(cp);
            }else if(cp==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [新增] 课题实施中存在的主要问题【课题进展第四部分】
     * @param projectMainProblems
     * @return
     */
    @Override
    public ResultMap insertPMP(List<ProjectMainProblemsDTO> projectMainProblems) {
        try{
            int insertNo=projectProgressMapper.insertPMP(projectMainProblems);
            if(insertNo>0){
                resultMap.success().message("成功新增"+insertNo+"条数据");
            }else if(insertNo==0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [查詢] 根據课题进展id查詢【课题进展第四部分】
     * @param Pid
     * @return
     */
    @Override
    public ResultMap getPMPByPid(int Pid) {
        try{
            List<ProjectMainProblemsDTO> pmp = projectProgressMapper.getPMPByPid(Pid);
            if(pmp!=null){
                resultMap.success().message(pmp);
            }else if(pmp==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [新增] 下一步工作计划【课题进展第五部分】
     * @param nextWorkPlan
     * @return
     */
    @Override
    public ResultMap insertNWP(List<NextWorkPlanDTO> nextWorkPlan) {
        try{
           int insertNo= projectProgressMapper.insertNWP(nextWorkPlan);
            if(insertNo>0){
                resultMap.success().message("成功新增"+insertNo+"条数据");
            }else if(insertNo==0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     *  [查詢] 根據课题进展id查詢【课题进展第四部分】
     * @param Pid
     * @return
     */
    @Override
    public ResultMap getNWPByPid(int Pid) {
        try{
            List<NextWorkPlanDTO> nwp = projectProgressMapper.getNWPByPid(Pid);
            if(nwp!=null){
                resultMap.success().message(nwp);
            }else if(nwp==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }
}
