package com.xdmd.environment.dailymanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.ProjectProgressDTO;

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
}
