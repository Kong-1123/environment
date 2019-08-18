package com.xdmd.environment.contractmanage.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理主表
 */
@Data
@AllArgsConstructor
@ApiModel(description = "合同管理主表")
public class ContractManageDTO {
    @ApiModelProperty(name="主键【注:系统默认生成,新增时不用填】",required = false)
    private Integer id;

    @ApiModelProperty("课题类别")
    private String subjectCategory;

    @ApiModelProperty("课题编号")
    private String projectNo;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("合同开始时间()")
    private String contractStartTime;

    @ApiModelProperty("合同结束时间")
    private String contractEndTime;

    @ApiModelProperty("课题负责人")
    private String subjeceLeader;

    @ApiModelProperty("课题负责人电话及手机")
    private String subjectLeaderPhone;

    @ApiModelProperty("课题联系人")
    private String subjectContact;

    @ApiModelProperty("课题联系人电话及手机")
    private String subjectContactPhone;

    @ApiModelProperty("承担单位")
    private String commitmentUnit;

    @ApiModelProperty("承担单位地址")
    private String commitmentUnitAddress;

    @ApiModelProperty("承担单位邮编")
    private String commitmentUnitZip;

    @ApiModelProperty("课题主管部门")
    private String subjectSupervisorDepartment;

    @ApiModelProperty("开户银行")
    private String openBank;

    @ApiModelProperty("开户银行账号")
    private String openBankAccount;

    @ApiModelProperty("电子信箱")
    private String email;

    @ApiModelProperty("保证单位")
    private String guaranteedUnits;

    @ApiModelProperty("保证单位联系人")
    private String guaranteedUnitContact;

    @ApiModelProperty("保证单位联系人电话")
    private String guaranteedContactPhone;

    @ApiModelProperty("委托单位（甲方）")
    private String commissioningUnit;

    @ApiModelProperty("委托单位（甲方）法定代表人")
    private String legalRepresentativeEntrustingA;

    @ApiModelProperty("委托单位（甲方）地址")
    private String commissionedUnitAddressA;

    @ApiModelProperty("委托单位（甲方）邮政编码")
    private String commissionedUnitZipA;

    @ApiModelProperty("承担单位（乙方）")
    private String responsibilityUnitB;

    @ApiModelProperty("承担单位（乙方）法定代表人")
    private String responsibilityLegalRepresentativeB;

    @ApiModelProperty("承担单位（乙方）地址")
    private String commitUnitAddressB;

    @ApiModelProperty("承担单位（乙方）邮政编码")
    private String commitUnitZipB;

    @ApiModelProperty("承担单位（乙方）课题负责人")
    private String commitUnitLeaderB;

    @ApiModelProperty("承担单位（乙方）课题负责人电话（手机号）")
    private String commitunitLeadersPhoneB;

    @ApiModelProperty("承担单位（乙方）课题负责人电子邮件")
    private String commitmentUnitEmailB;

    @ApiModelProperty("保证单位（丙方）")
    private String guaranteedUnitC;

    @ApiModelProperty("保证单位（丙方）法定代表人/部门负责人")
    private String guaranteedUnitLeaderC;

    @ApiModelProperty("保证单位（丙方）地址")
    private String guaranteedUnitAddressC;

    @ApiModelProperty("保证单位（丙方）邮编")
    private String guaranteedUnitZipC;

    @ApiModelProperty("课题签订说明")
    private String subjectSigningDescription;

    @ApiModelProperty("课题的目标和主要研究内容")
    private String subjectObjectivesResearch;

    @ApiModelProperty("课题验收内容和考核指标")
    private String subjectAcceptanceAssessment;

    @ApiModelProperty("其他条款")
    private String otherTerms;

    @ApiModelProperty("合同审批状态【0-单位员工待提交 1-单位管理员待审批 2-评估中心员工待审批 3-法规科技处待审批 4-法规科技处已审批】")
    private Integer approvalStatus;

    @ApiModelProperty("中期检查记录（关联表）")
    private Integer midRecordId;

    @ApiModelProperty("中期检查表附件id")
    private Integer midCheckAnnexId;

    @ApiModelProperty("专家评估表附件id")
    private Integer expertAssessmentAnnexId;

    @ApiModelProperty("合同附件id")
    private Integer contractAnnexId;

    @ApiModelProperty("课题意见附件id")
    private Integer subjectSuggestAnnexId;

    public ContractManageDTO() {
    }
}
