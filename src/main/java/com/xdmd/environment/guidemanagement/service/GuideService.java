package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.*;

import java.util.List;


public interface GuideService {

    /**
     * 获取所有信息分页展示
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<GuideCollection> getAllGuideInfo(int pageNum, int pageSize);

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

    List<GuideSummary> getAllSummary();
}
