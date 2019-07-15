package com.xdmd.environment.Demo.controller;

import com.xdmd.environment.Demo.service.DemoService;
import com.xdmd.environment.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;
    ResultMap resultMap = new ResultMap();

    @ResponseBody
    @RequestMapping("test")
    public ResultMap Demotest(){
        resultMap  = demoService.test();
        return resultMap;
    }
}
