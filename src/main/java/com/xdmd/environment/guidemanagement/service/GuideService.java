package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.pojo.GuideSummaryV2;

import java.util.List;


public interface GuideService {

    /**
     * 分页查询指南申报
     * @param guideName
     * @param domain
     * @param category
     * @param fillUnit
     * @param fillContacts
     * @param contactPhone
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<GuideCollection> getCollectionByParam(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone, int pageNum, int pageSize);

    /**
     * 获取类别和领域
     * @return
     */
    ResultMap getCategoryAndDomain();

    /**
     * 新增指南申报
     * @param guideCollection
     * @return
     */
    ResultMap insertGuideInfo( GuideCollection guideCollection);

    /**
     * 更新时间
     * @param guideCollectionLimitTime
     * @return
     */
    ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime);

    /**
     * 新增汇总信息
     * @param guideSummaryV2
     * @return
     */
    ResultMap insertSummary(GuideSummaryV2 guideSummaryV2);

    /**
     * 分页查询出所有汇总信息
     * @return
     */
    List<GuideSummary> getAllSummary(String guideSummaryTitle, String fillUnit,Integer domain,Integer category,String projectTime,String researchContentTechnology,int pageNum,int pageSize);

    /**
     * 根據id查詢相应单位的指南
     * @param id
     * @return
     */
    List<GuideCollection> getCollectionById(int id);
}

