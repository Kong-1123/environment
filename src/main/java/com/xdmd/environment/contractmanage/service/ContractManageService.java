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
     * [查詢合同主表] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    ContractManageDTO getInfoById(int id);

    /**
     * [查詢合同主表] 查詢全部
     * @return
     */
    List<ContractManageDTO> getAllInfo();
}
