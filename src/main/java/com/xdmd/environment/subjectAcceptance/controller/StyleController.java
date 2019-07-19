package com.xdmd.environment.subjectAcceptance.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectAcceptance.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("AcceptApply")
public class StyleController {

    @Autowired
    private StyleService styleService;
    ResultMap resultMap = new ResultMap();

    //查询单位的性质
    @PostMapping("unitNature")
    @ResponseBody
    public ResultMap queryUnitNature(){
        try {
            resultMap = styleService.queryUnitNature();
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.fail().message("系统异常");
            return resultMap;
        }
        return resultMap;
    }

    //查询申请的验收方式
    @PostMapping("acceptMethod")
    @ResponseBody
    public ResultMap queryAcceptMethod(){
        try {
            resultMap = styleService.queryAcceptMethod();
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.fail().message("系统异常");
            return resultMap;
        }
        return resultMap;
    }

    //查询验收提交清单
    @PostMapping("commitInventory")
    @ResponseBody
    public ResultMap queryCommitInventory(){
        try {
            resultMap = styleService.queryCommitInventory();
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.fail().message("系统异常");
            return resultMap;
        }
        return resultMap;
    }

}
