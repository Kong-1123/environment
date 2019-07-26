package com.xdmd.environment.subjectmanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectmanagement.pojo.OpenTender;

import java.util.List;

/**
 * 招标业务
 * @author Kong
 * @date 2019/07/26
 */
public interface OpenTenderService {
    /**
     * 新增招标信息
     * @param openTender
     * @return
     */
    ResultMap insertTender(OpenTender openTender);

    /**
     * 根據id查詢相应单位招标
     * @param id
     * @return
     */
    ResultMap getTenderById(int id);

    /**
     * 分页查询招标信息
     * @param projectName
     * @param subjectName
     * @param subjectLeader
     * @param leaderContact
     * @return
     */
    List<OpenTender> getTenderPageList(String projectName, String subjectName, String subjectLeader, String leaderContact,int pageNum,int pageSize);
}
