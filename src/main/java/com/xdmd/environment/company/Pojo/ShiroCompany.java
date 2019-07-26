package com.xdmd.environment.company.Pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class ShiroCompany {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "登陆名不可以为空")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,18}$",message = "登录名必须是大写字母加小写字母加数字的结合,必须是6-18位数")
    @Length(min = 6,max = 18,message = "登录名必须是6-18位")
    private String name;

    @NotNull(message = "真实姓名不能为空")
    private String username;

    @NotNull(message = "密码不可以为空")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\\d]{6,18}$",message = "密码必须是大写字母加小写字母加数字的结合,必须是6-18位数")
    @Length(min = 6,max = 18,message = "密码必须是6-18位")
    private String password;

    @Transient
    @NotNull(message = "公司名称不能为空")
    private String companyName;

    //公司地址
    @NotNull(message = "公司地址不能为空")
    private  String companyAddress;

    //社会信用号
    @NotNull(message = "社会信用号不能为空")
    @Pattern(regexp = "^[^_IOZSVa-z\\W]{2}\\d{6}[^_IOZSVa-z\\W]{10}$",message = "社会信用号不符合规范")
    private  String socialCreditCode;

    //法人姓名
    @NotNull(message ="法人姓名不能为空")
    private  String legalPerson;

    //联系人姓名
    @NotNull(message = "联系人不能为空")
    private  String contactPerson;

    //联系人身份证号
    @NotNull(message = "联系人身份证号码不能为空")
    @Pattern(regexp = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)",message ="联系人身份证号码不符合规范")
    private  String contactIdCard;

    //联系人手机号
    @NotNull(message = "联系人手机号不能为空")
    @Pattern(regexp = "^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$",message = "联系人手机号不符合规范")
    private  String contactPhone;

    //电子邮件
    @NotNull(message = "电子邮件不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(?!.*\\.\\..*)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",message = "电子邮件不符合规范")
    private  String email;

    //营业执照url
    private  String businessUrl;

    //法人身份证url
    private  String legalCardIdUrl;

    //联系人身份证url
    private  String contactCardUrl;

    //是否启用 0：逻辑删除 1：启用
    private  Integer isDelete;

    //员工修改登陆名次数 默认是1
    private  Integer modify;

    //单位性质
    @NotNull(message = "单位性质不能为空")
    private  Integer unitNature;

    //公司的id
    private Integer companyId;

    //用户的身份 0：管理员  1：员工
    private Integer status;

    //创建时间
    private Date createTime;


    public ShiroCompany(@NotNull(message = "登陆名不可以为空") @Pattern(regexp = "[A-Za-z0-9]", message = "登录名必须是大写字母加小写字母加数字的结合") @Size(min = 6, max = 18, message = "登录名必须是6-18位") String name, @NotNull(message = "真实姓名不能为空") String username, @NotNull(message = "密码不可以为空") @Pattern(regexp = "[A-Za-z0-9]", message = "密码必须是大写字母加小写字母加数字的结合") @Size(min = 6, max = 18, message = "密码必须是6-18位") String password, @NotNull(message = "公司名称不能为空") String companyName, @NotNull(message = "公司地址不能为空") String companyAddress, @NotNull(message = "社会信用号不能为空") @Pattern(regexp = "/^[^_IOZSVa-z\\W]{2}\\d{6}[^_IOZSVa-z\\W]{10}$/g", message = "社会信用号不符合规范") String socialCreditCode, @NotNull(message = "法人姓名不能为空") String legalPerson, @NotNull(message = "联系人不能为空") String contactPerson, @NotNull(message = "联系人身份证号码不能为空") @Pattern(regexp = "/(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)/", message = "联系人身份证号码不符合规范") String contactIdCard, @NotNull(message = "联系人手机号不能为空") @Pattern(regexp = "/^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$/", message = "联系人手机号不符合规范") String contactPhone, @NotNull(message = "电子邮件不能为空") @Pattern(regexp = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-z]{2,}$", message = "电子邮件不符合规范") String email, String businessUrl, String legalCardIdUrl, String contactCardUrl, Integer isDelete, Integer modify, @NotNull(message = "单位性质不能为空") Integer unitNature, Integer companyId, Integer status, Date createTime) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.socialCreditCode = socialCreditCode;
        this.legalPerson = legalPerson;
        this.contactPerson = contactPerson;
        this.contactIdCard = contactIdCard;
        this.contactPhone = contactPhone;
        this.email = email;
        this.businessUrl = businessUrl;
        this.legalCardIdUrl = legalCardIdUrl;
        this.contactCardUrl = contactCardUrl;
        this.isDelete = isDelete;
        this.modify = modify;
        this.unitNature = unitNature;
        this.companyId = companyId;
        this.status = status;
        this.createTime = createTime;
    }

    public ShiroCompany() {
    }
}
