package com.xdmd.environment.guidemanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.mapper.GuideCollectionMapper;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.service.GuideCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 指南征集业务实现类
 */
@Service
public class GuideCollectionServiceImpl implements GuideCollectionService {
    @Autowired
    GuideCollectionMapper guideCollectionMapper;
    ResultMap resultMap=new ResultMap();
    @Override
    public GuideCollection findOneGuideInfo(int id) {
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
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum   开始页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    @Override
    public Page<GuideCollection> findAllGuideInfo(int pageNum,  int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<GuideCollection> guideCollectionPage=guideCollectionMapper.findAllGuideInfo();
        System.out.println("0000");
        return guideCollectionPage;
    }

    /**
     * 实现新增信息
     * @param guideCollection
     * @return
     */
    @Override
    public ResultMap insertGuideInfo(GuideCollection guideCollection) {
              try {
                  int a = guideCollectionMapper.insertGuideInfo(guideCollection);
              }
              catch (Exception e){
                  return resultMap.fail().message("新增失败");
              }
              return  resultMap.success().message("新增成功");

}
}
