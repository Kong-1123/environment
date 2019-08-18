package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 课题进展情况主表
 */
@Data
@ApiModel("课题进展情况主表")
public class ProjectProgressDTO {
    @ApiModelProperty("课题进展情况主表id")
    private Integer id;

    @ApiModelProperty("承担单位")
    private String bearerUnit;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("课题编号")
    private String subjectNo;

    @ApiModelProperty("项目负责人")
    private String projectLeader;

    @ApiModelProperty("项目负责人电话")
    private String projectLeaderPhone;

    @ApiModelProperty("主要联系人")
    private String primaryContacts;

    @ApiModelProperty("项目负责人电话")
    private String primaryContactsPhone;

    @ApiModelProperty("进展情况类型/45-超前 46-正常 47-滞后")
    private Integer progress;

    @ApiModelProperty("目前进展情况完成百分比")
    private Double progressCompletedPercentage;

    @ApiModelProperty("已到位课题总经费（万元）")
    private BigDecimal totalFundsInplace;

    @ApiModelProperty("已使用课题经费（万元）")
    private BigDecimal projectFundsUsed;

    @ApiModelProperty("占总经费%")
    private Double totalFunding;

    @ApiModelProperty("已使用省环保课题经费（万元）")
    private BigDecimal provincialEnvironmentalFundsUsed;

    @ApiModelProperty("占省环保课题经费%")
    private Double provincialEnvironmentalFundsPercent;

    @ApiModelProperty("合同约定结题时间")
    private String contractAgreedClosingTime;

    @ApiModelProperty("能否按合同约定时间完成课题，分为：0-能、1-不能")
    private Integer isComplateContract;

    @ApiModelProperty("预计申请课题验收时间")
    private String estimatedAcceptanceTime;

    @ApiModelProperty("单位审核意见")
    private String unitAuditComments;

    @ApiModelProperty("开题报告附件")
    private Integer openReportAttachment;

    @ApiModelProperty("专家意见附件")
    private Integer expertOpinionAnnex;

    @ApiModelProperty("经费进展情况报告附件")
    private Integer progressReportAnnex;

    @ApiModelProperty("课题进展情况附件")
    private Integer subjectProgressAnnex;

    @ApiModelProperty("进展提交时间")
    private Date commitTime;



    public ProjectProgressDTO() {
    }
}
