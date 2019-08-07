package com.xdmd.environment.contractmanage.service.impl;

import com.xdmd.environment.contractmanage.mapper.ContractManageMapper;
import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import com.xdmd.environment.contractmanage.service.ContractManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ContractManageDTO getNewData() {
        return contractManageMapper.getNewData();
    }

    /**
     * 新增
     * @param contractManageDTO
     * @return
     */
    @Override
    public int insert(ContractManageDTO contractManageDTO) {
        contractManageDTO.setProjectNo(setProjectNo());
        return contractManageMapper.insert(contractManageDTO);
    }

    /**
     * 课题编号自增设置
     * @param
     */
    public String setProjectNo(){
        getNewData();
        String subString = new String(contractManageMapper.getNewData().getProjectNo());
        /**
         * 分离出数字并转换成int类型
         */
        int num = Integer.parseInt(subString.substring(4));
        if (num<=20190000) {
            /**
             * 获取当前年份
             */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            String sDate = date.toString();
            sDate = sdf.format(date);
            /**
             * 拼接课题编号和年份
             */
            StringBuilder number = new StringBuilder(sDate);
            number.append("0000");
            num = Integer.parseInt(number.toString());
        }
            num += 1;
        StringBuilder sBuilder = new StringBuilder("xdmd");
        String finalResult=sBuilder.insert(sBuilder.length(), num).toString();
        return finalResult;
    }
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public ContractManageDTO getInfoById(int id) {
        return contractManageMapper.getInfoById(id);
    }

    /**
     * 全查
     * @return
     */
    @Override
    public List<ContractManageDTO> getAllInfo() {
        return contractManageMapper.getAllInfo();
    }
}
