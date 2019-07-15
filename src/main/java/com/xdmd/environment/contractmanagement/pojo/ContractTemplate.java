package com.xdmd.environment.contractmanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 合同模板
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("contract_manage")
public class ContractTemplate{

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题类别")
    private Integer subjectCategory;

    @ApiModelProperty("课题编号")
    private String subjectNot;

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

    @ApiModelProperty("课题联系人手机")
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

    @ApiModelProperty("电子信箱(e-mail)")
    private String eMail;

    @ApiModelProperty("保证单位")
    private String guaranteedUnits;

    @ApiModelProperty("保证单位联系人")
    private String guaranteedUnitContact;

    @ApiModelProperty("保证单位联系人电话\r\n")
    private String guaranteedContactPhone;

    @ApiModelProperty("委托单位（甲方）")
    private String commissioningUnit;

    @ApiModelProperty("委托单位法定代表人")
    private String legalRepresentativeEntrustingPartya;

    @ApiModelProperty("委托单位地址")
    private String commissionedUnitAddressPartya;

    @ApiModelProperty("委托单位邮政编码")
    private String commissionedUnitZipPartya;

    @ApiModelProperty("承担单位（乙方）")
    private String responsibilityUnitPartyb;

    @ApiModelProperty("承担单位法定代表人")
    private String responsibilityLegalRepresentativePartyb;

    @ApiModelProperty("承担单位地址\r\n\r\n")
    private String commitmentUnitAddressPartyB;

    @ApiModelProperty("承担单位邮政编码")
    private String commitmentUnitZipPartyb;

    @ApiModelProperty("承担单位课题负责人")
    private String commitmentUnitLeaderPartyb;

    @ApiModelProperty("承担单位课题负责人电话（手机号）")
    private String commitmentunitLeadersPhonePartyb;

    @ApiModelProperty("承担单位课题负责人电子邮件")
    private String commitmentUnitEmailPartyb;

    @ApiModelProperty("保证单位（丙方）")
    private String guaranteedUnitPartyc;

    @ApiModelProperty("保证单位法定代表人/部门负责人")
    private String guaranteedUnitLeaderPartyc;

    @ApiModelProperty("保证单位地址")
    private String guaranteedUnitAddressPartyc;

    @ApiModelProperty("保证单位邮政编码")
    private String guaranteedUnitZipPartyc;

    @ApiModelProperty("课题签订说明\r\n")
    private String subjectSigningDescription;

    @ApiModelProperty("课题的目标和主要研究内容")
    private String subjectObjectivesResearch;

    @ApiModelProperty("课题验收内容和考核指标")
    private String subjectAcceptanceAssessment;

    @ApiModelProperty("课题进度及考核指标")
    private String subjectProgressMetrics;

    @ApiModelProperty("课题承担单位、参加单位及主要研究开发人员\r\n")
    private String undertakeParticipateResearchers;

    @ApiModelProperty("课题经费来源预算\r\n")
    private String budgetSourceFunding;

    @ApiModelProperty("课题总经费支出预算\r\n")
    private String subjectTotalExpenditure;

    @ApiModelProperty("合同表文件存放地址\r\n")
    private String contractAnnexAddress;

    @ApiModelProperty("是否需要进行中期检查(0：默认情况不需要1：需要进行中期检查)")
    private String isMidInspection;

    @ApiModelProperty("需要进行中期检查时规定时间（默认是1，单位是月）\r\n")
    private String midInspectionTime;

    @ApiModelProperty("验收状态(0：未验收失败1：验收成功，2验收失败3验收结题)")
    private String acceptanceStatus;

    @ApiModelProperty("\r\n其他条款\r\n")
    private String otherTerms;

    public ContractTemplate() {
    }

}
