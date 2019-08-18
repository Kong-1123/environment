package com.xdmd.environment.contractmanage.service;

import com.xdmd.environment.contractmanage.pojo.SubjectKeyResearchDevelopersDTO;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题承担单位、参加单位及主要研究开发人员
 */
public interface SubjectKeyResearchDevelopersService {
    /**
     * [新增]
     * @param subjectKeyResearchDevelopersDTO
     * @return
     */
    int insert(SubjectKeyResearchDevelopersDTO subjectKeyResearchDevelopersDTO);


    /**
     * [查詢] 根據合同管理id查詢
     * @param id
     * @return
     */
    SubjectKeyResearchDevelopersDTO getDeveloperInfoById(int id);

    /**
     * [查詢] 全部查詢
     * @return
     */
    List<SubjectKeyResearchDevelopersDTO> getAllInfo();
}
