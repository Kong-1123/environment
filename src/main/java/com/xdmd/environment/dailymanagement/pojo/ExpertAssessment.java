package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 专家评估
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("expert_assessment")
public class ExpertAssessment {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("课题编号")
    private String subjectNo;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("课题负责人")
    private String subjectLeader;

    @ApiModelProperty("承担单位")
    private String commitmentUnit;

    @ApiModelProperty("汇报情况")
    private String report;

    @ApiModelProperty("进度执行情况")
    private String progressPerformance;

    @ApiModelProperty("课题实施所需条件")
    private String conditionsImplementation;

    @ApiModelProperty("技术、经济等考核指标")
    private String assessmentMetrics;

    @ApiModelProperty("取得重大技术突破以及成效等情况")
    private String majorTechnologicalBreakthroughs;

    @ApiModelProperty("经费执行情况")
    private String implementationFunds;

    @ApiModelProperty("下一步工作计划")
    private String nextWork;

    @ApiModelProperty("存在问题")
    private String problem;

    @ApiModelProperty("建议")
    private String suggestions;

    @ApiModelProperty("专家组综合意见")
    private String expert;

    @ApiModelProperty("评价等次")
    private String evaluationGrade;

    @ApiModelProperty("专家名称，用、分开")
    private String expertName;

    @ApiModelProperty("fill_date")
    private String fillDate;

    public ExpertAssessment() {
    }

}
