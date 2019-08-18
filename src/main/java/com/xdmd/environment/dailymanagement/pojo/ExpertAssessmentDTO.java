package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 专家评估表
 */
@Data
@ApiModel("expert_assessment")
public class ExpertAssessmentDTO {
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

    @ApiModelProperty("汇报情况【53-内容清楚 54-内容基本清楚 55-内容不够清楚】")
    private Integer evaluationContent;

    @ApiModelProperty("进度执行情况【 56-超额完成 57-完成 58-基本完成 59-未完成】")
    private Integer progressExecution;

    @ApiModelProperty("课题实施所需条件【60-落实 61-基本落实 62-未落实】")
    private Integer projectImplementationConditions;

    @ApiModelProperty("技术、经济等考核指标 【63-达到合同规定【 64-基本达到合同 65-未达合同规定】")
    private Integer technicalEconomicAssessment;

    @ApiModelProperty("经费执行情况【66-合理 67-基本合理 68-不合理】")
    private Integer fundingPerformance;

    @ApiModelProperty("下一步工作计划【69-可行 70-基本可行 71-不可行 】")
    private Integer nextWorkPlan;

    @ApiModelProperty("评价等次【72-优秀 73-良好 74-一般 75-较差】")
    private Integer evaluationTime;

    @ApiModelProperty("取得重大技术突破以及成效等情况")
    private String majorTechnologicalBreakthroughs;

    @ApiModelProperty("存在问题")
    private String problem;

    @ApiModelProperty("建议")
    private String suggestions;

    @ApiModelProperty("专家组综合意见")
    private String expert;

    @ApiModelProperty("专家名称，用、分开")
    private String expertName;

    @ApiModelProperty("填写日期")
    private String fillDate;

    @ApiModelProperty("专家评估附件")
    private Integer expertAssessmentAnnexId;

    public ExpertAssessmentDTO() {
    }
}
