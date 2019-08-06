package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.SubjectKeyResearchDevelopersDTO;
import com.xdmd.environment.contractmanage.service.SubjectKeyResearchDevelopersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题承担单位、参加单位及主要研究开发人员接口
 */
@Api(tags = "课题承担单位、参加单位及主要研究开发人员【合同子表二】")
@RestController
@RequestMapping(value = "environment/contract/subjectkeydev")
public class SubjectKeyResearchDevelopersController {
    @Autowired
    SubjectKeyResearchDevelopersService subjectKeyResearchDevelopersService;
    ResultMap resultMap=new ResultMap();

    /**
     * [新增]
     * @param subjectKeyResearchDevelopersDTO
     * @return
     */
    @ApiOperation(value = "新增课题预算信息")
    @GetMapping(value = "insertInfo")
    public int insert(SubjectKeyResearchDevelopersDTO subjectKeyResearchDevelopersDTO) {
        return subjectKeyResearchDevelopersService.insert(subjectKeyResearchDevelopersDTO);
    }
    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询")
    @GetMapping(value = "getInfoById")
    public SubjectKeyResearchDevelopersDTO getInfoById(int id) {
        return subjectKeyResearchDevelopersService.getInfoById(id);
    }
    /**
     * [查询] 全部查询
     * @param
     * @return
     */
    @ApiOperation(value = "全部查询")
    @GetMapping(value = "getAllInfo")
    public List<SubjectKeyResearchDevelopersDTO> getAllInfo() {
        return subjectKeyResearchDevelopersService.getAllInfo();
    }
}
