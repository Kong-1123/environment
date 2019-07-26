package com.xdmd.environment.company.Controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.company.Pojo.User;
import com.xdmd.environment.company.Service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Login")
public class UserController {

    @Autowired
    private UserService userService;
    User user = new User();
    ResultMap resultMap = new ResultMap();

    @GetMapping("user")
    @ResponseBody
    public ResultMap userlogin(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        user = userService.userlogin(username, password);
        if (user != null) {
            //  从SecurityUtils里创建一个subject
            Subject subject = SecurityUtils.getSubject();
            //  在认证提交前准备token（令牌）
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //执行认证登陆
            subject.login(token);
            resultMap = new ResultMap().success().message("登陆成功");
        } else {
            resultMap = new ResultMap().fail().message("登陆失败");
        }
        return resultMap;
    }
}
