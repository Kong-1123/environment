package com.xdmd.environment.subjectAcceptance.service;

import com.xdmd.environment.common.ResultMap;

public interface StyleService {
    //查询单位的性质
    ResultMap queryUnitNature();

    //查询申请的验收方式
    ResultMap queryAcceptMethod();

    //查询验收提交清单
    ResultMap queryCommitInventory();
}
