package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 中期检查-part-2
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("mid_check_two")
public class MidCheckTwo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("预算总经费（万元）")
    private Integer totalBudget;

    @ApiModelProperty("省环保课题预算")
    private Integer provincialEnvironmentalProtectionSubjectBudget;

    @ApiModelProperty("单位自筹预算")
    private Integer unitFinancingBudget;

    @ApiModelProperty("其他预算")
    private Integer otherBudgets;

    @ApiModelProperty("经费使用总支出（万元）")
    private Integer totalExpenditure;

    @ApiModelProperty("省环保课题支出预算")
    private Integer provincialEnvironmentalSubjectExpenditureBudget;

    @ApiModelProperty("单位自筹支出预算")
    private Integer unitInancingExpenditureBudget;

    @ApiModelProperty("其他支出预算")
    private Integer otherExpenditureBudget;

    @ApiModelProperty("设备费使用情况")
    private String equipmentUsage;

    @ApiModelProperty("材料费使用情况")
    private String materialUsage;

    @ApiModelProperty("测试化验使用情况")
    private String testIngyUse;

    @ApiModelProperty("加工费使用情况")
    private String processingFeeUsage;

    @ApiModelProperty("燃料使用情况")
    private String fuelUsage;

    @ApiModelProperty("动力费使用情况")
    private String powerUsage;

    @ApiModelProperty("差旅费使用情况")
    private String travelExpenses;

    @ApiModelProperty("会议费使用情况")
    private String meetingFeeUsage;

    @ApiModelProperty("专家咨询费使用情况")
    private String expertConsultationFeesUsage;

    @ApiModelProperty("出版/文献/信息传播/知识产权事务费使用情况")
    private String publicationDocumentationNewsIntellectualproperty;

    @ApiModelProperty("劳务费（或管理及人员费中人员费）使用情况")
    private String labourCostsUsage;

    @ApiModelProperty("其他费用使用情况")
    private String otherExpenseUsage;

    @ApiModelProperty("间接费用（水、电、气消耗及管理费等）使用情况")
    private String indirectCostsUsage;

    @ApiModelProperty("外部合作费使用情况")
    private String externalCooperationFees;

    public MidCheckTwo() {
    }

}
