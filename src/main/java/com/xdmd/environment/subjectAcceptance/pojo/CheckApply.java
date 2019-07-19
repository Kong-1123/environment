package com.xdmd.environment.subjectAcceptance.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 验收申请表
 * @Author: ZhangYuDeLong
 * @Date: 2019.7.15
 */
@Data
public class CheckApply  implements Serializable {
    //主键Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;

    //课题名称
    @NotNull(message = "课题名称不能为空")
    private  String topicName;

    //课题编号
    @NotNull(message = "课题编号不能为空")
    private  String topicNumber;

    //课题承担单位
    @NotNull(message = "课题承担单位不能为空")
    private  String subjectUndertakingUnit;

    //单位性质
    @NotNull(message = "单位性质不能为空")
    private  Integer unitNature;

    //课题负责人
    @NotNull(message = "单位负责人不能为空")
    private  String projectLeader;

    //课题负责人联系电话
    @NotNull(message = "课题负责人联系电话不能为空")
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "课题负责人手机号格式不正确")
    private  String projectLeaderPhone;

    //课题负责人联系邮箱
    @NotNull(message = "课题负责人联系邮箱")
    @Email
    @Pattern(regexp = "^[0-9|A-z|]{6,18}[@][0-9|A-z]{1,3}.(com)$",message = "课题负责人邮箱格式不正确")
    private  String projectLeaderMail;

    //通讯地址
    @NotNull(message = "通讯地址不能为空")
    private  String postalAddress;

    //合同开始时间
    private Date agreementStartTime;

    //合同结束时间
    private  Date agreementEndTime;

    //申请验收时间
    private Date applicationAcceptanceTime;

    //申请验收方式
    @NotNull(message = "申请验收方式不能为空")
    private  Integer applicationAcceptanceMode;

    //申请验收地点
    @NotNull(message = "申请验收地点不能为空")
    private  String applicationAcceptancePlace;

    //验收联系人
    @NotNull(message = "验收联系人不能为空")
    private  String acceptanceContact;

    //验收联系人联系电话
    @Pattern(regexp = "^1[34578]\\d{9}$",message = "验收联系人手机号格式不正确")
    @NotNull(message = "验收联系人联系电话不能为空")
    private  String acceptanceContactPhone;

    //主要研究内容完成情况
    @Size(min = 1,max = 500,message = "请输入范围内字数")
    @NotNull(message = "主要研究内容完成情况不能为空")
    private  String mainContentSituation;

    //提交成果情况
    @NotNull(message = "提交成果情况不能为空")
    @Size(min = 1,max = 500,message = "请输入范围内字数")
    private  String submissionAchievementsSituation;

    //课题承担单位意见
    @NotNull(message = "课题承担单位意见不能为空")
    @Size(min = 1,max = 500,message = "请输入范围内字数")
    private  String subjectUndertakingUnitOpinion;

    //所在环保部门意见
    @NotNull(message ="所在环保部门意见不能为空")
    @Size(min = 1,max = 500,message = "请输入范围内字数")
    private  String environmentalDepartmentsOpinion;

    //省生态环境评估中心初审意见
    @NotNull(message ="省生态环境评估中心初审意见不能为空")
    @Size(min = 1,max = 500,message = "请输入范围内字数")
    private  String provinceAssessmentCenterOpinion;

    //省环保厅主管部门意见
    @NotNull(message = "省环保厅主管部门意见不能为空")
    @Size(min = 1,max = 500,message = "请输入范围内字数")
    private  String competentDepartmentOinion;

    @NotNull(message = "提交资料清单不能为空")
    //提交资料清单
    private String submitInventory;

    //提交清单url
    @Transient  //做sql映射的时候 忽略该字段
    private String submitInventoryUrl;

    //验收申请表url
    @Transient
    private  String applicationAcceptanceUrl;

    //成果附件url
    @Transient
    private  String achievementsUrl;

    //专项审计报告url
    @Transient
    private  String specialAuditUrl;

    //初审报告url
    @Transient
    private  String firstInspectionUrl;

    //验收申请表Id
    @Transient
    private Integer applicationId;

    //成果附件Id
    @Transient
    private Integer achievementId;

    //提交清单Id
    @Transient
    private Integer submitId;

    //验收审核流程
    private  Integer acceptancePhase;

    private Date createTime;

    private String createAuthor;


    public CheckApply(@NotNull(message = "课题名称不能为空") String topicName, @NotNull(message = "课题编号不能为空") String topicNumber, @NotNull(message = "课题承担单位不能为空") String subjectUndertakingUnit, @NotNull(message = "单位性质不能为空") Integer unitNature, @NotNull(message = "单位负责人不能为空") String projectLeader, @NotNull(message = "课题负责人联系电话不能为空") @Pattern(regexp = "^1[34578]\\d{9}$", message = "课题负责人手机号格式不正确") String projectLeaderPhone, @NotNull(message = "课题负责人联系邮箱") @Email @Pattern(regexp = "^[0-9|A-z|]{6,18}[@][0-9|A-z]{1,3}.(com)$", message = "课题负责人邮箱格式不正确") String projectLeaderMail, @NotNull(message = "通讯地址不能为空") String postalAddress, Date agreementStartTime, Date agreementEndTime, Date applicationAcceptanceTime, @NotNull(message = "申请验收方式不能为空") Integer applicationAcceptanceMode, @NotNull(message = "申请验收地点不能为空") String applicationAcceptancePlace, @NotNull(message = "验收联系人不能为空") String acceptanceContact, @Pattern(regexp = "^1[34578]\\d{9}$", message = "验收联系人手机号格式不正确") @NotNull(message = "验收联系人联系电话不能为空") String acceptanceContactPhone, @Size(min = 1, max = 500, message = "请输入范围内字数") @NotNull(message = "主要研究内容完成情况不能为空") String mainContentSituation, @NotNull(message = "提交成果情况不能为空") @Size(min = 1, max = 500, message = "请输入范围内字数") String submissionAchievementsSituation, @NotNull(message = "课题承担单位意见不能为空") @Size(min = 1, max = 500, message = "请输入范围内字数") String subjectUndertakingUnitOpinion, @NotNull(message = "所在环保部门意见不能为空") @Size(min = 1, max = 500, message = "请输入范围内字数") String environmentalDepartmentsOpinion, @NotNull(message = "省生态环境评估中心初审意见不能为空") @Size(min = 1, max = 500, message = "请输入范围内字数") String provinceAssessmentCenterOpinion, @NotNull(message = "省环保厅主管部门意见不能为空") @Size(min = 1, max = 500, message = "请输入范围内字数") String competentDepartmentOinion, @NotNull(message = "提交资料清单不能为空") String submitInventory, String submitInventoryUrl, String applicationAcceptanceUrl, String achievementsUrl, String specialAuditUrl, String firstInspectionUrl, Integer applicationId, Integer achievementId, Integer submitId, Integer acceptancePhase, Date createTime, String createAuthor) {
        this.topicName = topicName;
        this.topicNumber = topicNumber;
        this.subjectUndertakingUnit = subjectUndertakingUnit;
        this.unitNature = unitNature;
        this.projectLeader = projectLeader;
        this.projectLeaderPhone = projectLeaderPhone;
        this.projectLeaderMail = projectLeaderMail;
        this.postalAddress = postalAddress;
        this.agreementStartTime = agreementStartTime;
        this.agreementEndTime = agreementEndTime;
        this.applicationAcceptanceTime = applicationAcceptanceTime;
        this.applicationAcceptanceMode = applicationAcceptanceMode;
        this.applicationAcceptancePlace = applicationAcceptancePlace;
        this.acceptanceContact = acceptanceContact;
        this.acceptanceContactPhone = acceptanceContactPhone;
        this.mainContentSituation = mainContentSituation;
        this.submissionAchievementsSituation = submissionAchievementsSituation;
        this.subjectUndertakingUnitOpinion = subjectUndertakingUnitOpinion;
        this.environmentalDepartmentsOpinion = environmentalDepartmentsOpinion;
        this.provinceAssessmentCenterOpinion = provinceAssessmentCenterOpinion;
        this.competentDepartmentOinion = competentDepartmentOinion;
        this.submitInventory = submitInventory;
        this.submitInventoryUrl = submitInventoryUrl;
        this.applicationAcceptanceUrl = applicationAcceptanceUrl;
        this.achievementsUrl = achievementsUrl;
        this.specialAuditUrl = specialAuditUrl;
        this.firstInspectionUrl = firstInspectionUrl;
        this.applicationId = applicationId;
        this.achievementId = achievementId;
        this.submitId = submitId;
        this.acceptancePhase = acceptancePhase;
        this.createTime = createTime;
        this.createAuthor = createAuthor;
    }

    public CheckApply() {
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
