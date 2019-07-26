package com.xdmd.environment.company.Controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.company.Pojo.JwtInformation;
import com.xdmd.environment.company.Pojo.ShiroCompany;
import com.xdmd.environment.company.Service.CompanyService;
import com.xdmd.environment.company.Utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    ResultMap resultMap = new ResultMap();
    private static Logger log = LoggerFactory.getLogger(CompanyController.class);


    //公司的注册
    @PostMapping("register")
    @ResponseBody
    public ResultMap CompanyRegister(@CookieValue(value = "check", required = false) String check,
                                     @Valid ShiroCompany shiroCompany, BindingResult result,
                                     @RequestParam("code") String code,
                                     @RequestParam("businessFile") MultipartFile businessFile, //营业执照扫描件
                                     @RequestParam("legalCardIdFile") MultipartFile legalCardIdFile,//法人身份证文件
                                     @RequestParam("contactCardFile") MultipartFile contactCardFile) { //联系人身份证文件
        if (!businessFile.getOriginalFilename().contains(".") || !legalCardIdFile.getOriginalFilename().contains(".") || !contactCardFile.getOriginalFilename().contains(".")) {
            return resultMap.fail().message("上传的文件不可以为空");
        }

        //用于判断用户传输的参数是否有误
        if (result.hasErrors()) {
            List<ObjectError> ls = result.getAllErrors();
            String errorMessage = ls.get(0).getDefaultMessage();
            return resultMap.fail().message(errorMessage);
        }

        //判断cookie中是否有验证码
        if (StringUtils.isEmpty(check)) {
            //获取在cookie中获取不到验证码，则让他先去获取验证码
            return resultMap.fail().message("请先获取验证码");
        }
        if (!check.equalsIgnoreCase(code)) {
            //用户输入的验证码有误
            return resultMap.fail().message("输入的验证码有误");
        }

        //判断登陆名是否已存在
        String num2 = null;
        num2 = companyService.queryNameExist(shiroCompany.getName());
        if (!StringUtils.isEmpty(num2)) {
            return resultMap.fail().message("登陆名已存在，请重新输入");
        }

        try {
            resultMap = companyService.companyRegister(shiroCompany,businessFile,legalCardIdFile,contactCardFile);
        } catch (Exception e) {
            log.error("CompanyController 中 CompanyRegister方法 中注册失败");
            return resultMap.fail().message("注册失败");
        }
        return resultMap;
    }

    //公司登陆
    @ResponseBody
    @PostMapping("login")
    public ResultMap CompanyLogin(@RequestParam("name") String name,
                                  @RequestParam("password") String password,
                                  @CookieValue(value = "check", required = false) String check,
                                  @RequestParam("code") String code,
                                  HttpServletResponse response) {
        try {
            //判断cookie中是否有验证码
            if (StringUtils.isEmpty(check)) {
                //获取在cookie中获取不到验证码，则让他先去获取验证码
                return resultMap.fail().message("请先获取验证码");
            }
            if (!check.equalsIgnoreCase(code)) {
                //用户输入的验证码有误
                return resultMap.fail().message("输入的验证码有误");
            }
            //判断该用户是否存在
            String num = null;
            num = companyService.queryNameExist(name);
            if (StringUtils.isEmpty(num)) {
                return resultMap.fail().message("没有此用户");
            }
            //校验用户密码是否正确
            int num1 = 0;

            num1 = companyService.comparePassword(name, password);
            if (num1 == 0) {
                return resultMap.fail().message("密码错误");
            }

            //获取用户登陆名所在的公司名与公司Id
            HashMap<String, Object> companyNameAndId = new HashMap<>();
            companyNameAndId = companyService.queryCompanyNameByname(name);

            //获取登陆人的id 与 登陆人的真实姓名
            HashMap<String, Object> loginUsernameAndId = new HashMap<>();
            loginUsernameAndId = companyService.queryLoginUsernameAndId(name);


            //生成存放在cookie中的token
            JwtInformation jwtInformation = new JwtInformation();
            Object cname = companyNameAndId.get("cname");
            String cname2 = String.valueOf(cname);
            jwtInformation.setCompanyName(cname2);
            Object cid = companyNameAndId.get("cid");
            int i = Integer.parseInt(String.valueOf(cid));
            jwtInformation.setCid(i);

            Object username = loginUsernameAndId.get("username");
            String username2 = String.valueOf(username);
            jwtInformation.setUsername(username2);
            Object uid = loginUsernameAndId.get("uid");
            int uid2 = Integer.parseInt(String.valueOf(uid));
            jwtInformation.setUid(uid2);

            //通过JwtUtil 工具生成token
            String token = JwtUtil.geneJsonWebToken(jwtInformation);
            //把生成的token存放在cookie中
            //设置cookie的最大有效时间
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 30);//三十分钟
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
            return resultMap.fail().message("系统异常");
        }
        return resultMap.success().message("登陆成功");
    }
}
