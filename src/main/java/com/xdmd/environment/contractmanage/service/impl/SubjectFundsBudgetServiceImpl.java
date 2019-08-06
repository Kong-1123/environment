package com.xdmd.environment.contractmanage.service.impl;

import com.xdmd.environment.contractmanage.mapper.SubjectFundsBudgetMapper;
import com.xdmd.environment.contractmanage.pojo.SubjectFundsBudgetDTO;
import com.xdmd.environment.contractmanage.service.SubjectFundsBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题经费预算业务实现
 */
@Service
public class SubjectFundsBudgetServiceImpl implements SubjectFundsBudgetService {
    @Autowired
    SubjectFundsBudgetMapper subjectFundsBudgetMapper;
    /**
     * 新增
     * @param subjectFundsBudgetDTO
     * @return
     */
    @Override
    public int insert(SubjectFundsBudgetDTO subjectFundsBudgetDTO) {
        return subjectFundsBudgetMapper.insert(subjectFundsBudgetDTO);
    }
    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @Override
    public SubjectFundsBudgetDTO getInfoById(int id) {
        return subjectFundsBudgetMapper.getInfoById(id);
    }
    /**
     * [查詢] 获取全部预算信息
     * @return
     */
    @Override
    public List<SubjectFundsBudgetDTO> getAllInfo() {
        return subjectFundsBudgetMapper.getAllInfo();
    }
}
