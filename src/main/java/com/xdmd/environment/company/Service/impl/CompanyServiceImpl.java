package com.xdmd.environment.company.Service.impl;

import com.xdmd.environment.common.FileUploadUtil;
import com.xdmd.environment.common.MD5Utils;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.company.Pojo.ShiroCompany;
import com.xdmd.environment.company.Service.CompanyService;
import com.xdmd.environment.company.exception.FileSuffixJudgeException;
import com.xdmd.environment.company.exception.FileUploadException;
import com.xdmd.environment.company.mapper.CompanyMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    ResultMap resultMap = new ResultMap();
    private static Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);


    //公司的注册
    @Transactional(rollbackFor = Exception.class)
    public ResultMap companyRegister(ShiroCompany shiroCompany, MultipartFile businessFile, MultipartFile legalCardIdFile, MultipartFile contactCardFile) {
        //判断该公司是否已经注册过
        String cname = null;
        cname = companyMapper.queryCompanyName(shiroCompany.getCompanyName());
        if (!StringUtils.isEmpty(cname)) {
            //如果可以查询出来,则这个公司已经被注册过
            return resultMap.fail().message("该公司已经被注册过，请找公司管理员分配账号");
        }

        //对用户的密码进行加密
        String password = shiroCompany.getPassword();
        String newPassword = MD5Utils.md5(password);
        shiroCompany.setPassword(newPassword);

        //获取当前的时间 把util.date类型转换成sql.date存入数据库
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        shiroCompany.setCreateTime(sqlDate);

        //设置公司的人员的身份 0 为管理员
        shiroCompany.setStatus(0);

        //设置该账号启用
        shiroCompany.setIsDelete(1);


        //营业执照的上传
        List<String> businessSuffixList = new ArrayList<>(Arrays.asList(".jpg", ".png", ".jpeg"));
        try {
            String  businessFilePath = FileUploadUtil.fileUpload(businessFile, shiroCompany.getCompanyName(), "营业执照扫描件", businessSuffixList);
            shiroCompany.setBusinessUrl(businessFilePath);
        } catch (FileSuffixJudgeException e) {
            e.printStackTrace();
            return resultMap.fail().message(e.getMessage());
        } catch (FileUploadException e) {
            e.printStackTrace();
            return resultMap.fail().message(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("CompanyServiceImpl 中的文件上传失败");
            return resultMap.fail().message("系统异常");
        }

        //法人身份证的上传
        List<String> legalCardIdSuffixList = new ArrayList<>(Arrays.asList(".doc",".docx",".zip",".rar",".7z"));
        try {
            String legalCardIdFilePath = FileUploadUtil.fileUpload(legalCardIdFile, shiroCompany.getCompanyName(), "法人身份证文件", legalCardIdSuffixList);
            shiroCompany.setLegalCardIdUrl(legalCardIdFilePath);
        } catch (FileSuffixJudgeException e) {
            e.printStackTrace();
            return resultMap.fail().message(e.getMessage());
        } catch (FileUploadException e) {
            e.printStackTrace();
            return resultMap.fail().message(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("CompanyServiceImpl 中的文件上传失败");
            return resultMap.fail().message("系统异常");
        }

        //联系人身份证的上传
        List<String> contactCardSuffixList = new ArrayList<>(Arrays.asList(".doc",".docx",".zip",".rar",".7z"));
        try {
            String contactCardFilePath = FileUploadUtil.fileUpload(contactCardFile, shiroCompany.getCompanyName(), "联系人身份证文件", contactCardSuffixList);
            shiroCompany.setContactCardUrl(contactCardFilePath);
        } catch (FileSuffixJudgeException e) {
            e.printStackTrace();
            return resultMap.fail().message(e.getMessage());
        } catch (FileUploadException e) {
            e.printStackTrace();
            return resultMap.fail().message(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("CompanyServiceImpl 中的文件上传失败");
            return resultMap.fail().message("系统异常");
        }


        //把公司名称存放到公司表中
        int num2 = 0;
        num2 = companyMapper.addCompanyName(shiroCompany.getCompanyName());
        if (num2 == 0) {
            return resultMap.fail().message("新增失败");
        }

        //获取公司名对应的id
        int cid = companyMapper.queryCompanyId(shiroCompany.getCompanyName());
        shiroCompany.setCompanyId(cid);

        //对公司进行注册
        int num = 0;
        num = companyMapper.insertSelective(shiroCompany);
        if (num == 0) {
            log.error("CompanyServiceImpl 中 companyRegister 方法 对公司新增失败");
            return resultMap.fail().message("新增失败");
        }

        //同时新增公司与权限之间的中间表
        int num1 = 0;
        num1 = companyMapper.addCompanyAndRole(shiroCompany.getId());

        if (num1 == 0) {
            return resultMap.fail().message("新增失败");
        }
        return resultMap.success().message("注册成功");
    }

    //判断用户名是否存在
    @Override
    public String queryNameExist(String name) {
        String name2 = null;
        name2 = companyMapper.queryNameExist(name);
        return name2;
    }

    //判断用户输入的密码是否正确
    @Override
    public int comparePassword(String name, String password) {
        //先对用户的密码进行加密
        String newPassword = MD5Utils.md5(password);

        //取出存在数据库中对应的密码
        String sqlPassword = companyMapper.queryPassword(name);

        if (newPassword.equals(sqlPassword)) {
            return 1;
        }
        return 0;
    }

    //根据登陆名获取用户的所在公司名与公司id
    @Override
    public HashMap<String, Object> queryCompanyNameByname(String name) {
        //根据用户名获取公司id
        int cid = companyMapper.queryCompanyIdByname(name);
        //通过公司id 获取公司名
        String cname = companyMapper.queryCompanyNameByCid(cid);

        HashMap<String, Object> companyNameAndId = new HashMap<>();
        companyNameAndId.put("cid", cid);
        companyNameAndId.put("cname", cname);
        return companyNameAndId;
    }

    //根据登陆名获取用户的真实姓名与id
    @Override
    public HashMap<String, Object> queryLoginUsernameAndId(String name) {
        String username = companyMapper.queryLoginUsernameByname(name);
        int uid = companyMapper.queryUserIdByName(name);
        HashMap<String, Object> usernameAndId = new HashMap<>();
        usernameAndId.put("username", username);
        usernameAndId.put("uid", uid);
        return usernameAndId;
    }

}
