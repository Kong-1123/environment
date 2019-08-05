package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


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
    List<Map> getCollectionByParam(String guideName, Integer domain, Integer category, String fillUnit, String fillContacts, String contactPhone, int pageNum, int pageSize);

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
     * @param guideSummary
     * @return
     */
    ResultMap insertSummary(GuideSummary guideSummary);

    /**
     * 分页查询出所有汇总信息
     * @return
     */
    List<Map> getSummaryByParam(String guideSummaryTitle, String fillUnit,Integer domain,Integer category,String projectTime,String researchContentTechnology,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    /**
     * 根據单位id查詢相应单位的指南申报
     * @param Uid
     * @return
     */
    List<Map> getCollectionByUid(int Uid);

    /**
     * 获取所有汇总表里的关联gcid
     * @return
     */
    List<Integer> getGCid();

    /**
     * 根据汇总获取的id查询申报
     * @param
     * @return
     */
    List<Map> getCollectionById();
}

