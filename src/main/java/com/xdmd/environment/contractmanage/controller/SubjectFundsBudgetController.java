package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.SubjectFundsBudgetDTO;
import com.xdmd.environment.contractmanage.service.SubjectFundsBudgetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题经费预算接口
 */
@Api(tags = "课题经费预算【合同子表三】")
@RestController
@RequestMapping(value = "environment/contract/subjectfundbudget")
public class SubjectFundsBudgetController {
    @Autowired
    SubjectFundsBudgetService subjectFundsBudgetService;
    ResultMap resultMap=new ResultMap();
    /**
     * 新增
     * @param subjectFundsBudgetDTO
     * @return
     */
    @ApiOperation(value = "新增课题预算信息")
    @PostMapping(value = "insertInfo")
    public ResultMap insert(SubjectFundsBudgetDTO subjectFundsBudgetDTO) {
        int sfb=subjectFundsBudgetService.insert(subjectFundsBudgetDTO);
        return sfb>0?resultMap.success().message("新增成功"):resultMap.fail().message("新增失败");

    }
    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id单查课题预算信息")
    @GetMapping(value = "getInfoById")
    public ResultMap getInfoById(@RequestParam("id") int id) {
        SubjectFundsBudgetDTO sfbDTO= subjectFundsBudgetService.getInfoById(id);
        return sfbDTO!=null?resultMap.success().message(sfbDTO):resultMap.fail().message("查询失败");


    }
    /**
     * [查詢] 获取全部预算信息
     * @return
     */
    @ApiOperation(value = "获取全部预算信息")
    @GetMapping(value = "getAllInfo")
    public ResultMap getAllInfo() {
        List<SubjectFundsBudgetDTO>  sfbList=subjectFundsBudgetService.getAllInfo();
        return sfbList!=null?resultMap.success().message(sfbList):resultMap.fail().message("查询失败");

    }
}
