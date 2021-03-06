package com.xdmd.environment.guidemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.mapper.GuideMapper;
import com.xdmd.environment.guidemanagement.pojo.*;
import com.xdmd.environment.guidemanagement.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 指南征集业务实现类
 */
@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    GuideMapper guideMapper;
    ResultMap resultMap=new ResultMap();
    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum   开始页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    @Override
    public List<GuideCollection> getAllCollection(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GuideCollection> guideCollectionList= guideMapper.getAllCollection(guideName,domain,category,fillUnit,fillContacts,contactPhone);
        return guideCollectionList;
    }

    @Override
    public List<Domain> getAllDomain() {
        return guideMapper.getAllDomain();
    }

    @Override
    public List<Category> getAllCategory() {
        return guideMapper.getAllCategory();
    }

    /**
     * 实现新增信息
     * @param guideCollection
     * @return
     */
    @Override
    public ResultMap insertGuideInfo(GuideCollection guideCollection) {
              try {
                  guideMapper.insertGuideInfo(guideCollection);
              }
              catch (Exception e){
                  return resultMap.fail().message("新增失败");
              }
              return  resultMap.success().message("新增成功");
}



    /**
     * 更新限制时间业务实现
     * @param guideCollectionLimitTime
     * @return
     */
    @Override
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime) {
        try{
            guideMapper.updateLimitTime(guideCollectionLimitTime);
        }catch (Exception e){
            return  resultMap.success().message("更新失败");
        }
        return  resultMap.success().message("更新成功");
    }

    @Override
    public ResultMap insertSummary(GuideSummary guideSummary) {

            int n=guideMapper.insertSummary(guideSummary);
        return  resultMap.success().message("汇总新增成功");
    }

    /**
     * 汇总信息分页
     * @param guideSummaryTitle
     * @param fillUnit
     * @param domain
     * @param category
     * @param projectTime
     * @param researchContentTechnology
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<GuideSummary> getAllSummary(String guideSummaryTitle, String fillUnit,Integer domain,Integer category,String projectTime,String researchContentTechnology,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GuideSummary> guideSummaryList=guideMapper.getAllSummary(guideSummaryTitle,fillUnit,domain,category,projectTime,researchContentTechnology);
        return guideSummaryList;
    }

    @Override
    public List<GuideCollection> getCollectionById(int id) {
        return guideMapper.getCollectionById(id);
    }

}
