package com.xdmd.environment.contractmanage.service;

import com.xdmd.environment.contractmanage.pojo.SubjectFundsBudgetDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题经费预算业务
 */
public interface SubjectFundsBudgetService {
    /**
     * 新增
     * @param subjectFundsBudgetDTO
     * @return
     */
    int insert(SubjectFundsBudgetDTO subjectFundsBudgetDTO);

    /**
     * [查詢] 根據合同管理id查詢
     * @param id
     * @return
     */
    SubjectFundsBudgetDTO getBudgetInfoById(@Param("id") int id);
    /**
     * [查詢] 获取全部预算信息
     * @return
     */
    List<SubjectFundsBudgetDTO> getAllInfo();
}
