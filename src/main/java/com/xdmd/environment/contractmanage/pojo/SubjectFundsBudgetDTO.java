package com.xdmd.environment.contractmanage.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 课题经费预算【合同子表三】
 */
@Data
@ApiModel(description = "课题经费预算【合同子表三】")
public class SubjectFundsBudgetDTO {

    @ApiModelProperty(name="主键【注:系统默认生成,新增时不用填】",required = false,example ="1")
    private Integer id;

    @ApiModelProperty("合同主表id")
    private Integer contractId;

    @ApiModelProperty("预算数")
    private BigDecimal budget;

    @ApiModelProperty("当前年")
    private String currentYear;

    @ApiModelProperty("明年")
    private String nextYear;

    @ApiModelProperty("后年")
    private String afterYear;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("省环保科研课题经费当前年预算")
    private BigDecimal provincialCurrentBudget;

    @ApiModelProperty("省环保科研课题经费明年预算")
    private BigDecimal provincialNextBudget;

    @ApiModelProperty("省环保科研课题经费后年预算")
    private BigDecimal provincialAfterBudget;

    @ApiModelProperty("省环保科研课题经费预算备注")
    private String provincialNoteBudget;

    @ApiModelProperty("部门、地方配套当前年预算")
    private BigDecimal departmentCurrentBudget;

    @ApiModelProperty("部门、地方配套明年预算")
    private BigDecimal departmentNextBudget;

    @ApiModelProperty("部门、地方配套后年预算")
    private BigDecimal departmentAfterBudget;

    @ApiModelProperty("部门、地方配套预算备注")
    private String departmentNoteBudget;

    @ApiModelProperty("承担单位自筹当前年预算")
    private BigDecimal bearCurrentBudget;

    @ApiModelProperty("承担单位自筹明年预算")
    private BigDecimal bearNextBudget;

    @ApiModelProperty("承担单位自筹后年预算")
    private BigDecimal bearAfterBudget;

    @ApiModelProperty("承担单位自筹预算备注")
    private String bearNoteBudget;

    @ApiModelProperty("其他来源当前年预算")
    private BigDecimal otherCurrentBudget;

    @ApiModelProperty("其他来源明年预算")
    private BigDecimal otherNextBudget;

    @ApiModelProperty("其他来源后年预算")
    private BigDecimal otherAfterBudget;

    @ApiModelProperty("其他来源预算备注")
    private String otherNoteBudget;

    @ApiModelProperty("设备费支出当前年预算")
    private BigDecimal equipmentCurrentBudget;

    @ApiModelProperty("设备费支出明年预算")
    private BigDecimal equipmentNextBudget;

    @ApiModelProperty("设备费支出后年预算")
    private BigDecimal equipmentAfterBudget;

    @ApiModelProperty("设备费支出自筹配套经费预算")
    private BigDecimal equipmentSupportingBudget;

    @ApiModelProperty("设备费支出预算备注")
    private String equipmentNoteBudget;

    @ApiModelProperty("材料费支出当前年预算")
    private BigDecimal materialCurrentBudget;

    @ApiModelProperty("材料费支出明年预算")
    private BigDecimal materialNextBudget;

    @ApiModelProperty("材料费支出后年预算")
    private BigDecimal materialAfterBudget;

    @ApiModelProperty("材料费支出自筹配套经费预算")
    private BigDecimal materialSupportingBudget;

    @ApiModelProperty("材料费支出预算备注")
    private String materialNoteBudget;

    @ApiModelProperty("测试化验加工费支出当前年预算")
    private String testCurrentBudget;

    @ApiModelProperty("测试化验加工费支出明年预算")
    private BigDecimal testNextBudget;

    @ApiModelProperty("测试化验加工费支出后年预算")
    private BigDecimal testAfterBudget;

    @ApiModelProperty("测试化验加工费支出自筹配套经费预算")
    private BigDecimal testSupportingBudget;

    @ApiModelProperty("测试化验加工费支出预算备注")
    private String testNoteBudget;

    @ApiModelProperty("燃料动力费支出当前年预算")
    private BigDecimal fuelCurrentBudget;

    @ApiModelProperty("燃料动力费支出明年预算")
    private BigDecimal fuelNextBudget;

    @ApiModelProperty("燃料动力费支出后年预算")
    private BigDecimal fuelAfterBudget;

    @ApiModelProperty("燃料动力费支出自筹配套经费预算")
    private BigDecimal fuelSupportingBudget;

    @ApiModelProperty("燃料动力费支出预算备注")
    private String fuelNoteBudget;

    @ApiModelProperty("会议差旅费支出当前年预算")
    private BigDecimal mettingCurrentBudget;

    @ApiModelProperty("会议差旅费支出明年预算")
    private BigDecimal mettingNextBudget;

    @ApiModelProperty("会议差旅费支出后年预算")
    private BigDecimal mettingAfterBudget;

    @ApiModelProperty("会议差旅费支出自筹配套经费预算")
    private BigDecimal mettingSupportingBudget;

    @ApiModelProperty("会议差旅费支出预算备注")
    private String mettingNoteBudget;

    @ApiModelProperty("劳务费支出当前年预算")
    private BigDecimal laborCurrentBudget;

    @ApiModelProperty("劳务费支出明年预算")
    private BigDecimal laborNextBudget;

    @ApiModelProperty("劳务费支出后年预算")
    private BigDecimal laborAfterBudget;

    @ApiModelProperty("劳务费支出自筹配套经费预算")
    private BigDecimal laborSupportingBudget;

    @ApiModelProperty("劳务费支出预算备注")
    private String laborNoteBudget;

    @ApiModelProperty("专家咨询费支出当前年预算")
    private BigDecimal expertsCurrentBudget;

    @ApiModelProperty("专家咨询费支出明年预算")
    private BigDecimal expertsNextBudget;

    @ApiModelProperty("专家咨询费支出后年预算")
    private BigDecimal expertsAfterBudget;

    @ApiModelProperty("专家咨询费支出自筹配套经费预算")
    private BigDecimal expertsSupportingBudget;

    @ApiModelProperty("专家咨询费支出预算备注")
    private String expertsNoteBudget;

    @ApiModelProperty("日常水、电、气、暖消耗等支出当前年预算")
    private BigDecimal dailyCurrentBudget;

    @ApiModelProperty("日常水、电、气、暖消耗等支出明年预算")
    private BigDecimal dailyNextBudget;

    @ApiModelProperty("日常水、电、气、暖消耗等支出后年预算")
    private BigDecimal dailyAfterBudget;

    @ApiModelProperty("日常水、电、气、暖消耗等支出自筹配套经费预算")
    private BigDecimal dailySupportingBudget;

    @ApiModelProperty("日常水、电、气、暖消耗等支出预算备注")
    private String dailyNoteBudget;

    public SubjectFundsBudgetDTO() {
    }
}
