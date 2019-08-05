package com.xdmd.environment.contractmanage.service.impl;

import com.xdmd.environment.contractmanage.mapper.ContractManageMapper;
import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import com.xdmd.environment.contractmanage.service.ContractManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理业务层实现
 */
@Service
public class ContractManageServiceImpl implements ContractManageService {
    @Autowired
    private ContractManageMapper contractManageMapper;

    @Override
    public int insert(ContractManageDTO contractManageDTO) {
        return contractManageMapper.insert(contractManageDTO);
    }

    @Override
    public ContractManageDTO getInfoById(int id) {
        return contractManageMapper.getInfoById(id);
    }

    @Override
    public List<ContractManageDTO> getAllInfo() {
        return contractManageMapper.getAllInfo();
    }
}
