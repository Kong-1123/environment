package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.mapper.MajorMattersFilingMapper;
import com.xdmd.environment.dailymanagement.pojo.AdjustTypeDTO;
import com.xdmd.environment.dailymanagement.pojo.AdjustmentMattersDTO;
import com.xdmd.environment.dailymanagement.pojo.MajorMattersFilingDTO;
import com.xdmd.environment.dailymanagement.service.MajorMattersFilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/08/19
 * @description: 重大事项变更
 */
@Service
public class MajorMattersFilingServiceImpl implements MajorMattersFilingService {
    @Autowired
    MajorMattersFilingMapper majorMattersFilingMapper;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增
     * @param majorMattersFiling
     * @return
     */
    @Override
    public ResultMap insert(MajorMattersFilingDTO majorMattersFiling) {
        try{
            int insertNo= majorMattersFilingMapper.insert(majorMattersFiling);
            if(insertNo>0){
                resultMap.success().message("成功新增"+insertNo+"条数据");
            }else if(insertNo==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [更新]重大事项附件id
     * @return
     */
    @Override
    public ResultMap updateAnnexId(int changeApplicationAttachmentId,int expertArgumentationAttachmentId,int filingApplicationAttachmentId,int approvalDocumentsAttachmentId,int id) {
        try{
            int updateNo= majorMattersFilingMapper.updateAnnexId(changeApplicationAttachmentId,expertArgumentationAttachmentId, filingApplicationAttachmentId, approvalDocumentsAttachmentId, id);
            if(updateNo>0){
                resultMap.success().message("成功更新"+updateNo+"条数据");
            }else if(updateNo==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @Override
    public ResultMap getMajorById(int id) {
        try{
            MajorMattersFilingDTO majors = majorMattersFilingMapper.getMajorById(id);
            if(majors!=null){
                resultMap.success().message(majors);
            }else if(majors==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [查詢] 分頁查詢【内网】
     * @param offset
     * @param pagesize
     * @return
     */
    @Override
    public ResultMap pageList(String subjectName,String commitmentUnit,int adjustTypId,int adjustmentMattersId,int offset,int pagesize) {
        try{
            List<Map> mapList = majorMattersFilingMapper.pageList(subjectName,commitmentUnit,adjustTypId,adjustmentMattersId,offset,pagesize);
            if(mapList!=null){
                resultMap.success().message(mapList);
            }else if(mapList==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }


    /**
     * [查詢] 分頁查詢 count【内网】
     * @param offset
     * @param pagesize
     * @return
     */
    @Override
    public ResultMap pageListCount(int offset, int pagesize) {
        try{
            int majorNo = majorMattersFilingMapper.pageListCount(offset,pagesize);
            if(majorNo>0){
                resultMap.success().message("共有"+majorNo+"条数据");
            }else if(majorNo==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * 查询所有调整类型
     * @return
     */
    @Override
    public ResultMap AdjustType() {
        try{
            List<AdjustTypeDTO> adjustTypeList = majorMattersFilingMapper.getAllAdjustType();
            if(adjustTypeList!=null){
                resultMap.success().message(adjustTypeList);
            }else if(adjustTypeList==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }


    /**
     * 查询所有调整类型
     * @return
     */
    @Override
    public ResultMap AdjustmentMatters() {
        try{
            List<AdjustmentMattersDTO> adjustmentMattersList = majorMattersFilingMapper.getAllAdjustmentMatters();
            if(adjustmentMattersList!=null){
                resultMap.success().message(adjustmentMattersList);
            }else if(adjustmentMattersList==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }
}
