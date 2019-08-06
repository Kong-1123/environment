package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.ContentIndicatorsDTO;
import com.xdmd.environment.contractmanage.service.ContentIndicatorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/6
 * @description: 课题进度及考核指标接口
 */
@Api(tags = "课题进度及考核指标接口【合同子表一】")
@Controller
@RequestMapping(value = "environment/contentindicators")
public class ContentIndicatorsController {
    @Autowired
    ContentIndicatorsService contentIndicatorsService;
    ResultMap resultMap=new ResultMap();
    /**
     * 新增
     * @param contentIndicatorsDTO
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "新增计划内容信息")
    @PostMapping(value = "insertContentInfo")
    public ResultMap insert(ContentIndicatorsDTO contentIndicatorsDTO) {
        return contentIndicatorsService.insert(contentIndicatorsDTO)>0?resultMap.success().message("新增成功"):resultMap.fail().message("新增失败");

    }

    /**
     * 根据id单查
     * @param id
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "根据id单查计划内容信息")
    @GetMapping (value = "getInfoById")
    public ResultMap getInfoById(int id) {
        ContentIndicatorsDTO indicatorsDTO=contentIndicatorsService.getInfoById(id);
        return indicatorsDTO!=null?resultMap.success().message(indicatorsDTO):resultMap.fail().message("查询失败");
    }

    /**
     * 全部查询
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "全部查询计划内容信息）")
    @GetMapping (value = "getAllnfo")
    public ResultMap getAllnfo() {
        List<ContentIndicatorsDTO> dtoList=contentIndicatorsService.getAllInfo();
        return dtoList.size()>0?resultMap.success().message(dtoList):resultMap.fail().message("查询失败");
    }
}
