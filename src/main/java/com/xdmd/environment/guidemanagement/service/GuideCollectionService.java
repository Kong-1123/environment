package com.xdmd.environment.guidemanagement.service;

import com.github.pagehelper.Page;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;


public interface GuideCollectionService {

    /**
     * 根據主鍵 id 查詢
     * @param id
     */
    GuideCollection findOneGuideInfo(int id);
    /**
     * 获取所有信息分页展示
     * @param
     * @return
     */
    Page<GuideCollection> findAllGuideInfo( int pageNum,  int pageSize);

    /**
     * 新增
     * @param guideCollection
     * @return
     */
    ResultMap insertGuideInfo( GuideCollection guideCollection);
}
