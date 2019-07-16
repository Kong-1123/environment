package com.xdmd.environment.guidemanagement.service;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;

import java.util.List;


public interface GuideCollectionService {

    /**
     * 根據主鍵 id 查詢
     * @param id
     */
    GuideCollection findOneGuideInfo(Integer id);
    /**
     * 获取所有信息
     * @param
     * @return
     */
    List<GuideCollection> findAllGuideInfo(int pageNum, int pageSize);

    /**
     * 新增
     * @param guideCollection
     */
    Integer insertGuideInfo(GuideCollection guideCollection);
}
