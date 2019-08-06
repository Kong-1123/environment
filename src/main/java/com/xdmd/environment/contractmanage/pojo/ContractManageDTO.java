package com.xdmd.environment.contractmanage.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理主表
 */
@Data
@ApiModel("合同管理主表")
public class ContractManageDTO {
    @ApiModelProperty("主键")
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

    @ApiModelProperty("保证单位联系人电话\r\n")
    private String guaranteedContactPhone;

    @ApiModelProperty("委托单位（甲方）")
    private String commissioningUnit;

    @ApiModelProperty("委托单位法定代表人")
    private String legalRepresentativeEntrustingA;

    @ApiModelProperty("委托单位地址")
    private String commissionedUnitAddressA;

    @ApiModelProperty("委托单位邮政编码")
    private String commissionedUnitZipA;

    @ApiModelProperty("承担单位（乙方）")
    private String responsibilityUnitB;

    @ApiModelProperty("承担单位法定代表人")
    private String responsibilityLegalRepresentativeB;

    @ApiModelProperty("承担单位地址\r\n\r\n")
    private String commitUnitAddressB;

    @ApiModelProperty("承担单位邮政编码")
    private String commitUnitZipB;

    @ApiModelProperty("承担单位课题负责人")
    private String commitUnitLeaderB;

    @ApiModelProperty("承担单位课题负责人电话（手机号）")
    private String commitunitLeadersPhoneB;

    @ApiModelProperty("承担单位课题负责人电子邮件")
    private String commitmentUnitEmailB;

    @ApiModelProperty("保证单位（丙方）")
    private String guaranteedUnitC;

    @ApiModelProperty("保证单位法定代表人/部门负责人")
    private String guaranteedUnitLeaderC;

    @ApiModelProperty("保证单位地址")
    private String guaranteedUnitAddressC;

    @ApiModelProperty("保证单位邮编")
    private String guaranteedUnitZipC;

    @ApiModelProperty("课题签订说明\r\n")
    private String subjectSigningDescription;

    @ApiModelProperty("课题的目标和主要研究内容")
    private String subjectObjectivesResearch;

    @ApiModelProperty("课题验收内容和考核指标")
    private String subjectAcceptanceAssessment;

    @ApiModelProperty("课题进度及考核指标(关联子表)")
    private Integer subjectProgressMetrics;

    @ApiModelProperty("课题承担单位、参加单位及主要研究开发人员(关联子表)")
    private Integer undertakeParticipateResearchers;

    @ApiModelProperty("课题经费来源预算(关联子表)")
    private Integer budgetSourceFunding;

    @ApiModelProperty("课题总经费支出预算(关联子表)")
    private Integer subjectTotalExpenditure;

    @ApiModelProperty("合同表文件存放地址")
    private String contractAnnexAddress;

    @ApiModelProperty("其他条款")
    private String otherTerms;

    public ContractManageDTO() {
    }
}
