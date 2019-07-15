package com.xdmd.environment.Demo.service.impl;

import com.xdmd.environment.Demo.mapper.DemoMapper;
import com.xdmd.environment.Demo.pojo.User;
import com.xdmd.environment.Demo.service.DemoService;
import com.xdmd.environment.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;
    ResultMap resultMap = new ResultMap();

    public ResultMap test() {
        User user = demoMapper.query();
        resultMap.success().message(user);
        return resultMap;
    }
}
