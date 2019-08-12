package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import com.xdmd.environment.contractmanage.service.ContractManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理接口
 */
@Api(tags="合同管理【合同主表】")
@RestController
@RequestMapping(value = "environment/contract")
public class ContractManageController {
    @Autowired
    ContractManageService contractManageService;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增：
     * @param contractManageDTO
     * @return
     */
    @ApiOperation(value = "新增合同信息")
    @PostMapping(value = "addContractInfo")
    public ResultMap insertContractInfo(ContractManageDTO contractManageDTO) {
        int cm=contractManageService.insert(contractManageDTO);
        return cm>0?resultMap.success().message("新增成功"):resultMap.fail().message("新增失败");
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询")
    @GetMapping (value = "getManageInfoById")
    public ResultMap getManageInfoById(int id) {
         ContractManageDTO cmDTO=contractManageService.getManageInfoById(id);
        return cmDTO!=null?resultMap.success().message(cmDTO):resultMap.fail().message("查询失败");
    }

    /**
     * 全查
     * @return
     */
    @ApiOperation(value = "查询全部合同")
    @GetMapping (value = "getAllInfo")
    public List<ContractManageDTO> getAllInfo() {
        return contractManageService.getAllInfo();
    }

    /**
     * 根据勾选的合同主表id修改相应的中期检查状态(内网)--中期检查
     * @param ids
     * @return
     */
    @ApiOperation(value = "根据勾选的合同主表id修改相应的中期检查状态")
    @PostMapping (value = "updateContractByIds")
    public int updateContractByIds(@RequestBody List<Long> ids) {
        return contractManageService.updateContractByIds(ids);
    }
}
