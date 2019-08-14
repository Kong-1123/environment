package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.mapper.ProjectProgressMapper;
import com.xdmd.environment.dailymanagement.pojo.ProjectProgressDTO;
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
}
