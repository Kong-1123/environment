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
    List<GuideCollection> findAllGuideInfo(Integer pageNum, Integer pageSize);

    /**
     * 新增
     * @param guideCollection
     * @return
     */
    Integer insertGuideInfo(GuideCollection guideCollection);
}
