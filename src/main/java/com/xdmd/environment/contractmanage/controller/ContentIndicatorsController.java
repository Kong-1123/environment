package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.ContentIndicatorsDTO;
import com.xdmd.environment.contractmanage.service.ContentIndicatorsService;
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
 * @description: url接口
 */
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
    @ApiOperation(value = "新增计划内容信息（合同子表）")
    @ResponseBody
    @PostMapping(value = "insertContentInfo")
    public ResultMap insert(ContentIndicatorsDTO contentIndicatorsDTO) {
        return contentIndicatorsService.insert(contentIndicatorsDTO)>0?resultMap.success().message("新增成功"):resultMap.fail().message("新增失败");

    }

    /**
     * 根据id单查
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id单查计划内容信息（合同子表）")
    @ResponseBody
    @GetMapping (value = "getInfoById")
    public ContentIndicatorsDTO getInfoById(int id) {
        return contentIndicatorsService.getInfoById(id);
    }

    /**
     * 全部查询
     * @return
     */
    @ApiOperation(value = "全部查询计划内容信息（合同子表）")
    @ResponseBody
    @GetMapping (value = "全部查询")
    public List<ContentIndicatorsDTO> 全部查询() {
        return contentIndicatorsService.getAllInfo();
    }
}
