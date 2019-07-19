package com.xdmd.environment.subjectAcceptance.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectAcceptance.mapper.StyleMapper;
import com.xdmd.environment.subjectAcceptance.pojo.AcceptMethod;
import com.xdmd.environment.subjectAcceptance.pojo.CommitInventory;
import com.xdmd.environment.subjectAcceptance.pojo.UnitNature;
import com.xdmd.environment.subjectAcceptance.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleMapper styleMapper;
    ResultMap resultMap = new ResultMap();

    //查询单位的性质
    public ResultMap queryUnitNature() {
        List<UnitNature> unitNatureList = styleMapper.queryUnitNature();
        resultMap.success().message(unitNatureList);
        return resultMap;
    }

    //查询申请的验收方式
    public ResultMap queryAcceptMethod() {
        List<AcceptMethod> acceptMethods = styleMapper.queryAcceptMethod();
        resultMap.success().message(acceptMethods);
        return resultMap;
    }

    //查询验收提交清单
    public ResultMap queryCommitInventory() {
        List<CommitInventory> commitInventoryList = styleMapper.queryCommitInventory();
        resultMap.success().message(commitInventoryList);
        return resultMap;
    }
}
