package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;

import java.util.List;


public interface GuideCollectionService {

    /**
     * 获取所有信息分页展示
     * @param
     * @return
     */
    List<GuideCollection> findAllGuideInfo(int id,int pageNum, int pageSize);

    /**
     * 新增
     * @param guideCollection
     * @return
     */
    ResultMap insertGuideInfo( GuideCollection guideCollection);

    /**
     * 查询类别和领域
     * @return
     */
    ResultMap findDic();

    /**
     * 更新时间
     * @param guideCollectionLimitTime
     * @return
     */
    ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime);

    /**
     * 补充汇总表其余数据
     * @param guideSummary
     * @return
     */
    ResultMap insertSummaryData(GuideSummary guideSummary);
}
