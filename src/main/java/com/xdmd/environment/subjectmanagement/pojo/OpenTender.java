package com.xdmd.environment.subjectmanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * open_tender
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("open_tender")
public class OpenTender {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String projectName;

    @ApiModelProperty("标书标号")
    private String tenderNo;

    @ApiModelProperty("分包号")
    private String subcontractingNo;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("投标人")
    private String bidders;

    @ApiModelProperty("课题负责人")
    private String subjectLeader;

    @ApiModelProperty("课题负责人联系方式")
    private String leaderContect;

    @ApiModelProperty("课题联合投标单位（如有请填写，没有就填无）")
    private String jointTenderUnits;

    @ApiModelProperty("经办人")
    private String operator;

    @ApiModelProperty("经办人联系方式")
    private String operatorContact;

    @ApiModelProperty("中标（成交）金额")
    private BigDecimal winningAmount;

    @ApiModelProperty("配套经费")
    private BigDecimal supportingFunds;

    @ApiModelProperty("中标文件附件地址")
    private String winningAttachmentAddress;

    @ApiModelProperty("成交公告附件地址")
    private String dealAttachmentAddress;

    @ApiModelProperty("成交通知书附件地址")
    private String dealNoticeAnnexAddress;

    @ApiModelProperty("其他附件地址")
    private String otherAccessories;

    @ApiModelProperty("审核状态(1：企业的普通员工已提交2：企业的管理员已提交3：科室工作人员通过审核4：审核未通过)")
    private Integer auditStatus;

    public OpenTender() {
    }

}