package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.ContentIndicatorsDTO;
import com.xdmd.environment.contractmanage.service.ContentIndicatorsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/6
 * @description: 课题进度及考核指标接口
 */
@Api(tags = "课题进度及考核指标【合同子表一】")
@RestController
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
    @ApiOperation(value = "添加",notes="新增计划内容信息")
    @PostMapping(value = "addContentInfo")
    public ResultMap insert(ContentIndicatorsDTO contentIndicatorsDTO) {
        return contentIndicatorsService.insert(contentIndicatorsDTO)>0?resultMap.success().message("新增成功"):resultMap.fail().message("新增失败");

    }

    /**
     * 根据id单查
     * @param id
     * @return
     */
    @ApiOperation(value = "获取计划内容信息",notes = "根据id查询")
    @GetMapping (value = "getInfoById")
    public ResultMap getInfoById(int id) {
        ContentIndicatorsDTO indicatorsDTO=contentIndicatorsService.getInfoById(id);
        return indicatorsDTO!=null?resultMap.success().message(indicatorsDTO):resultMap.fail().message("查询失败");
    }

    /**
     * 全部查询
     * @return
     */
    @ApiOperation(value = "获取计划内容信息",notes = "查询全部")
    @GetMapping (value = "getAllnfo")
    public ResultMap getAllnfo() {
        List<ContentIndicatorsDTO> dtoList=contentIndicatorsService.getAllInfo();
        return dtoList.size()>0?resultMap.success().message(dtoList):resultMap.fail().message("查询失败");
    }
}
