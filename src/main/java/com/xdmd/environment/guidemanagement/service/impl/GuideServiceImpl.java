package com.xdmd.environment.guidemanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.Dictionary;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.guidemanagement.mapper.GuideMapper;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import com.xdmd.environment.guidemanagement.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 指南征集业务实现类
 */
@Service
public class GuideServiceImpl implements GuideService {
    @Autowired
    GuideMapper guideMapper;
    ResultMap resultMap = new ResultMap();

    /**
     * 实现分页查询指南申报
     *
     * @param guideName
     * @param domain
     * @param category
     * @param fillUnit
     * @param fillContacts
     * @param contactPhone
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResultMap getCollectionByParam(String guideName, Integer domain, Integer category, String fillUnit, String fillContacts, String contactPhone, int pageNum, int pageSize) {

        try{
            PageHelper.startPage(pageNum, pageSize);
            List<Map> guideCollectionList = guideMapper.getCollectionByParam(guideName, domain, category, fillUnit, fillContacts, contactPhone);
            if(guideCollectionList.size()>0){
                resultMap.success().message(guideCollectionList);
            }else if(guideCollectionList.size()==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }

        return resultMap;
    }

    /**
     * 实现获取类别和领域
     *
     * @return
     */
    @Override
    public ResultMap getCategoryAndDomain() {
        List<Dictionary> getCategoryAndDomains = guideMapper.getCategoryAndDomain();
        return getCategoryAndDomains.size()>0? resultMap.success().message(getCategoryAndDomains) : resultMap.fail().message("查询失败");
    }

    /**
     * 实现新增指南申报信息
     *
     * @param guideCollection
     * @return
     */
    @Override
    public ResultMap insertGuideInfo(GuideCollection guideCollection) {

           int gm=guideMapper.insertGuideInfo(guideCollection);
        return resultMap.success().message("新增成功");
    }


    /**
     * 实现更新限制时间业务实现
     * 无论时间周期是否正确，都会导入正确数据到数据库
     *
     * @param guideCollectionLimitTime
     * @return
     */
    @Override
    public ResultMap updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime) {
        /**
         * 判断时间大小
         */
        try {
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            //开始时间
            Date begin = fmt.parse(guideCollectionLimitTime.getGuideCollectionStartTime());
            //结束时间
            Date end = fmt.parse(guideCollectionLimitTime.getGuideCollectionEndTime());
            //判断开始时间是否在结束时间之后,返回布尔值
            if (begin.after(end) || end.before(begin)) {
                String begintime = guideCollectionLimitTime.getGuideCollectionStartTime();
                String endtime = guideCollectionLimitTime.getGuideCollectionEndTime();
                guideCollectionLimitTime.setGuideCollectionStartTime(endtime);
                guideCollectionLimitTime.setGuideCollectionEndTime(begintime);
            }
            guideMapper.updateLimitTime(guideCollectionLimitTime);

        } catch (Exception e) {
            return resultMap.success().message("更新失败");
        }
        return resultMap.success().message("更新成功");
    }

    @Override
    public ResultMap insertSummary(GuideSummary guideSummary) {
        int number = guideMapper.insertSummary(guideSummary);
        return resultMap.success().message("汇总新增成功");
    }

    /**
     * 实现汇总信息分页
     *
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
    public List<Map> getSummaryByParam(String guideSummaryTitle, String fillUnit, Integer domain, Integer category, String projectTime, String researchContentTechnology, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> guideSummaryList = guideMapper.getSummaryByParam(guideSummaryTitle, fillUnit, domain, category, projectTime, researchContentTechnology);
        return guideSummaryList;
    }

    /**
     * 实现根据单位id查询单位指南申报
     *
     * @param Uid
     * @return
     */
    @Override
    public List<Map> getCollectionByUid(int Uid) {
        return guideMapper.getCollectionByUid(Uid);
    }

    /**
     * 根据勾选的指南id获取选相应指南申报信息
     *
     * @param
     * @return
     */
    @Override
    public ResultMap getCollectionByIds(List<Integer> ids) {
        ids.forEach(id -> System.out.println("id-->" + id));
        List<Map> guideMap=guideMapper.getCollectionByIds(ids);
        try{
            if(guideMap.size()>0){
                resultMap.success().message(guideMap);
            }else if(guideMap.size()==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }
}
