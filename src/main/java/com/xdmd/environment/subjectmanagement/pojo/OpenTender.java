package com.xdmd.environment.subjectmanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 公开招标
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("公开招标实体类")
public class OpenTender{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id【注:id为默认,新增时不用填】")
    private int id;

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
    private String leaderContact;

    @ApiModelProperty("课题联合投标单位（如有请填写，没有就填无）")
    private String joinTenderUnits;

    @ApiModelProperty("经办人")
    private String operator;

    @ApiModelProperty("经办人联系方式")
    private String operatorContact;

    @ApiModelProperty("中标（成交）金额")
    private BigDecimal winningAmount;

    @ApiModelProperty("配套经费")
    private BigDecimal supportingFunds;

    @ApiModelProperty("审核状态(1：企业的普通员工已提交2：企业的管理员已提交3：科室工作人员通过审核4：审核未通过)")
    private Integer auditStatus;

    @ApiModelProperty("课题编号【注:系统默认生成,新增时可不用填】")
    private String projectNo;

    public OpenTender() {
    }

}