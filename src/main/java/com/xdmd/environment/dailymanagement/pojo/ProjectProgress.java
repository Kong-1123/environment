package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * project_progress
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("project_progress")
public class ProjectProgress {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("课题编号")
    private String subjectNo;

    @ApiModelProperty("项目负责人")
    private String projectLeader;

    @ApiModelProperty("项目负责人电话")
    private String projectLeaderPhone;

    @ApiModelProperty("进展情况")
    private String progress;

    @ApiModelProperty("合同要求研发任务")
    private String contractResearchTask;

    @ApiModelProperty("目前进展情况（该字段新建关联表，内容为：目前进展情况编号，目前进展情况内容）")
    private String currentProgress;

    @ApiModelProperty("目前进展情况完成百分比")
    private Integer progressCompletedPercentage;

    @ApiModelProperty("已到位课题总经费（万元）")
    private Integer totalFundsInplace;

    @ApiModelProperty("已使用课题经费（万元）")
    private Integer projectFundsUsed;

    @ApiModelProperty("占总经费%")
    private Integer totalFunding;

    @ApiModelProperty("已使用省环保课题经费（万元）")
    private Integer provincialEnvironmentalFundsUsed;

    @ApiModelProperty("占省环保课题经费%")
    private Integer provincialEnvironmentalFunds;

    @ApiModelProperty("课题实施中存在的主要问题（研究遇到的困难及技术、方案、人员等变动情况）")
    private String majorProblems;

    @ApiModelProperty("下一步研发工作安排")
    private String nextStepPlan;

    @ApiModelProperty("合同约定结题时间")
    private String contractAgreedClosingTime;

    @ApiModelProperty("能否按合同约定时间完成课题，分为：能、不能")
    private Integer isComplateContract;

    @ApiModelProperty("预计申请课题验收时间")
    private String estimatedAcceptanceTime;

    @ApiModelProperty("s varchar(255)")
    private String unitAuditComments;

    @ApiModelProperty("开题报告附件")
    private String openReportAttachment;

    @ApiModelProperty("专家意见附件")
    private String expertOpinionAnnex;

    @ApiModelProperty("进展情况报告附件")
    private String progressReportAnnex;

    @ApiModelProperty("课题进展情况附件")
    private String subjectProgressAnnex;

    public ProjectProgress() {
    }

}
