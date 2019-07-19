package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;

import java.util.List;


public interface GuideCollectionService {

    /**
     * 获取所有信息分页展示
     * @param
     * @return
     */
    List<GuideCollection> findAllGuideInfo(int pageNum, int pageSize);

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
}
