package com.xdmd.environment.guidemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.mapper.GuideCollectionMapper;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.service.GuideCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 指南征集业务实现类
 */
@Service(value = "guideCollectionService")
public class GuideCollectionServiceImpl implements GuideCollectionService {
    @Autowired
    GuideCollectionMapper guideCollectionMapper;
    ResultMap resultMap=new ResultMap();

    @Override
    @Transactional
    public GuideCollection findOneGuideInfo(Integer id) {
        return guideCollectionMapper.findOneGuideInfo(id);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     *很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum  开始页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    @Override
    @Transactional
    public List<GuideCollection> findAllGuideInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GuideCollection> guideCollectionList=guideCollectionMapper.findAllGuideInfo();
        return guideCollectionList;
    }

    /**
     * 实现新增信息
     * @param guideCollection
     */
    @Override
    @Transactional
    public Integer insertGuideInfo(GuideCollection guideCollection) {
        return guideCollectionMapper.insertGuideInfo(guideCollection);
    }

}
