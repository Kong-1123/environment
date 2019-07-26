package com.xdmd.environment.company.Service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.company.Pojo.ShiroCompany;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public interface CompanyService {
    //判断用户名是否存在
    String queryNameExist(String name);

    //判断用户输入的密码是否正确
    int comparePassword(String name, String password);

    //根据用户的登陆名获取用户所在的公司
    HashMap<String, Object> queryCompanyNameByname(String name);

    //根据用户的登陆名，获取用户的真实姓名与id
    HashMap<String, Object> queryLoginUsernameAndId(String name);

    //用户的注册
    ResultMap companyRegister(ShiroCompany shiroCompany, MultipartFile businessFile, MultipartFile legalCardIdFile, MultipartFile contactCardFile);
}
