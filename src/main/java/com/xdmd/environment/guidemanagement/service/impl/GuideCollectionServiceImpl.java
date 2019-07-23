package com.xdmd.environment.guidemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.mapper.GuideCollectionMapper;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.service.GuideCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<GuideCollection> findAllGuideInfo(int id,int pageNum, int pageSize) {
        GuideCollection guideCollection=null;
        PageHelper.startPage(pageNum,pageSize);
        List<GuideCollection> guideCollectionList=guideCollectionMapper.findAllGuideInfo(id);
        return guideCollectionList;
    }

    /**
     * 实现新增信息
     * @param guideCollection
     * @return
     */
    @Override
    public ResultMap insertGuideInfo(GuideCollection guideCollection) {
              try {
                  guideCollectionMapper.insertGuideInfo(guideCollection);
              }
              catch (Exception e){
                  return resultMap.fail().message("新增失败");
              }
              return  resultMap.success().message("新增成功");

}

    @Override
    public ResultMap findDic() {
        try {
           guideCollectionMapper.findDic();
        }
        catch (Exception e){
            return resultMap.fail().message("失败");
        }
        return  resultMap.success().message("成功");
    }


    /**
     * 更新限制时间业务实现
     * @param guideCollectionLimitTime
     * @return
     */
    @Override
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime) {
        try{
            guideCollectionMapper.updateLimitTime(guideCollectionLimitTime);
        }catch (Exception e){
            return  resultMap.success().message("更新失败");
        }
        return  resultMap.success().message("更新成功");
    }

    /**
     * 补充汇总表其余数据业务实现
     * @param guideSummary
     * @return
     */
    @Override
    public ResultMap insertSummaryData(GuideSummary guideSummary) {
        return null;
    }
}
