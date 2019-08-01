package com.xdmd.environment.guidemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.Dictionary;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.mapper.GuideMapper;
import com.xdmd.environment.guidemanagement.pojo.*;
import com.xdmd.environment.guidemanagement.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<GuideCollection> getCollectionByParam(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<GuideCollection> guideCollectionList= guideMapper.getCollectionByParam(guideName,domain,category,fillUnit,fillContacts,contactPhone);
        return guideCollectionList;
    }

    /**
     * 获取类别和领域
     * @return
     */
    @Override
    public ResultMap getCategoryAndDomain() {
        List<Dictionary> getCategoryAndDomains=guideMapper.getCategoryAndDomain();
        return getCategoryAndDomains!=null?resultMap.success().message(getCategoryAndDomains):resultMap.fail().message("查询失败");
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
     * 无论时间周期是否正确，都会导入正确数据到数据库
     * @param guideCollectionLimitTime
     * @return
     */
    @Override
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime) {
        /**
         * 判断时间大小
         */
        try{
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
             //开始时间
            Date begin = fmt.parse(guideCollectionLimitTime.getGuideCollectionStartTime());
            //结束时间
            Date end = fmt.parse(guideCollectionLimitTime.getGuideCollectionEndTime());
            //判断开始时间是否在结束时间之后,返回布尔值
            if(begin.after(end)||end.before(begin)){
                String begintime=guideCollectionLimitTime.getGuideCollectionStartTime();
                String endtime=guideCollectionLimitTime.getGuideCollectionEndTime();
                guideCollectionLimitTime.setGuideCollectionStartTime(endtime);
                guideCollectionLimitTime.setGuideCollectionEndTime(begintime);
            }
            guideMapper.updateLimitTime(guideCollectionLimitTime);

        }catch (Exception e){
            return  resultMap.success().message("更新失败");
        }
        return  resultMap.success().message("更新成功");
    }

    @Override
    public ResultMap insertSummary(GuideSummaryV2 guideSummaryV2) {
        int number=guideMapper.insertSummary(guideSummaryV2);
        System.out.println("影响行数-->"+number);
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

    /**
     * 根据单位id查询单位指南申报
     * @param id
     * @return
     */
    @Override
    public List<GuideCollection> getCollectionById(int id) {
        return guideMapper.getCollectionById(id);
    }

}
