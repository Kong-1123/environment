package com.xdmd.environment.contractmanage.service;

import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理业务层
 */
public interface ContractManageService {


    /**
     * 获取最新的id用于保持最新课题编号
     * @return
     */
    ContractManageDTO getNewData();

    /**
     * [新增合同主表]
     * @param contractManageDTO
     * @return
     */
    int insert(ContractManageDTO contractManageDTO);

    /**
     * [查詢合同主表] 根据合同主表id查询
     * @param id
     * @return
     */
    ContractManageDTO getManageInfoById(int id);

    /**
     * [查詢合同主表] 查詢主表全部
     * @return
     */
    List<ContractManageDTO> getAllInfo();

    /**
     * 根据勾选的合同主表id修改相应的中期检查状态(内网)--中期检查
     * @param ids
     * @return
     */
    int updateContractByIds(List<Long> ids);

    /**
     * [查詢] 根据中期检查状态查詢相应合同主表
     * @return
     */
    List<ContractManageDTO> getInfoByMidState();
}
