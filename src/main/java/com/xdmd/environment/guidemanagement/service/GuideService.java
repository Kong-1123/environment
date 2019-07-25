package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.*;

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
    List<GuideCollection> getCollectionPageList(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone, int pageNum, int pageSize);

    /**
     * 获取领域
     * @return
     */
    List<Domain> getAllDomain();
    /**
     * 获取类别
     * @return
     */
    List<Category> getAllCategory();

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
     * @param guideSummary
     * @return
     */
    ResultMap insertSummary(GuideSummary guideSummary);

    /**
     * 查询出所有汇总信息
     * @return
     */
    List<GuideSummary> getAllSummary(String guideSummaryTitle, String fillUnit,Integer domain,Integer category,String projectTime,String researchContentTechnology,int pageNum,int pageSize);
}
