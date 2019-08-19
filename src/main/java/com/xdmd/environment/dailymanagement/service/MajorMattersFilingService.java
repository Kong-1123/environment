package com.xdmd.environment.dailymanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.MajorMattersFilingDTO;
import org.apache.ibatis.annotations.Param;

/**
 * 重大事项管理
 */
public interface MajorMattersFilingService {
    /**
     * 新增重大事项变更
     * @param majorMattersFiling
     * @return
     */
    ResultMap insert(@Param("majorMattersFiling") MajorMattersFilingDTO majorMattersFiling);

    /**
     * [更新]重大事项附件id
     * @return
     */
    ResultMap updateAnnexId(int changeApplicationAttachmentId,int expertArgumentationAttachmentId,int filingApplicationAttachmentId,int approvalDocumentsAttachmentId,int id);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    ResultMap getMajorById(@Param("id") int id);

    /**
     * [查詢] 分頁查詢【内网】
     * @param offset
     * @param pagesize
     * @return
     */
    ResultMap pageList(String subjectName,String commitmentUnit,int adjustTypId,int adjustmentMattersId,int offset,int pagesize);

    /**
     * [查詢] 分頁查詢 count【内网】
     * @param offset
     * @param pagesize
     * @return
     */
    ResultMap pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize);

    /**
     * 查询所有调整类型
     * @return
     */
    ResultMap  AdjustType();

    /**
     * 查询所有调整类型
     * @return
     */
    ResultMap  AdjustmentMatters();
}
