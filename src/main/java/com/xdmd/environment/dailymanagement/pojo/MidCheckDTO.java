package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 中期检查模板
 */
@Data
@ApiModel(description = "中期检查模板")
public class MidCheckDTO {

    @ApiModelProperty("主键【注:系统默认生成,新增时不用填】")
    private Integer id;

    @ApiModelProperty("课题编号")
    private String subjectNo;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("课题开始时间")
    private String subjectStartTime;

    @ApiModelProperty("课题结束时间")
    private String subjectEndTime;

    @ApiModelProperty("承担单位")
    private String commitmentUnit;

    @ApiModelProperty("课题联系人")
    private String topicContact;

    @ApiModelProperty("课题联系人电话")
    private String subjectContactPhone;

    @ApiModelProperty("课题负责人")
    private String subjectLeader;

    @ApiModelProperty("课题负责人电话")
    private String leaderPhone;

    @ApiModelProperty("课题按合同计划进度执行情况")
    private Integer contractPlanCrogressExecution;

    @ApiModelProperty("课题未按时完成原因，分为：1.技术变化；2.经费未落实；3.项目负责人或技术骨干变动；4协作关系影响；5.其他原因（复选框）")
    private Integer notCompletingReason;

    @ApiModelProperty("预算总经费（万元）")
    private Integer totalBudget;

    @ApiModelProperty("省环保课题预算")
    private Integer provincialSubjectBudget;

    @ApiModelProperty("单位自筹预算")
    private Integer unitFinancingBudget;

    @ApiModelProperty("其他预算")
    private Integer otherBudgets;

    @ApiModelProperty("经费使用总支出（万元）")
    private Integer totalExpenditure;

    @ApiModelProperty("省环保课题支出预算")
    private Integer provincialSubjectExpenditureBudget;

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

    @ApiModelProperty("新增销售额（万元）")
    private BigDecimal newSales;

    @ApiModelProperty("新增利润（万元）")
    private BigDecimal newProfit;

    @ApiModelProperty("新增税金（万元）")
    private BigDecimal newTax;

    @ApiModelProperty("创汇（万美元）")
    private BigDecimal foreignExchange;

    @ApiModelProperty("新产品（个）")
    private Integer newProducts;

    @ApiModelProperty("新装备（装置）（台）")
    private Integer newEquipment;

    @ApiModelProperty("新材料(件）")
    private Integer newMaterials;

    @ApiModelProperty("新工艺（项）")
    private Integer newProcess;

    @ApiModelProperty("新品种（个）")
    private Integer newVarieties;

    @ApiModelProperty("发明专利")
    private String foreignPatents;

    @ApiModelProperty("实用新型")
    private String utilityModel;

    @ApiModelProperty("外观设计")
    private String design;

    @ApiModelProperty("国外专利")
    private String foreignPatents1;

    @ApiModelProperty("论文总数（篇）")
    private Integer totalNumberPapers;

    @ApiModelProperty("核心期刊（篇）")
    private Integer coreJournals;

    @ApiModelProperty("sci索引（篇）")
    private Integer sciIndex;

    @ApiModelProperty("ei索引（篇）")
    private Integer eiIndex;

    @ApiModelProperty("出版专著（部）")
    private Integer publicationMonograph;

    @ApiModelProperty("研究（咨询）")
    private String research;

    @ApiModelProperty("报告（份）")
    private Integer report;

    @ApiModelProperty("制定技术标准（个）")
    private Integer developTechnicalStandards;

    @ApiModelProperty("出台文件（个）")
    private Integer releaseDocuments;

    @ApiModelProperty("高级人才（人）")
    private Integer seniorTalent;

    @ApiModelProperty("其中，国家杰出青年（长江学者、千人计划或其他）人数（分别列出）")
    private Integer nationalOutstandingYoungPeople;

    @ApiModelProperty("培养研究生人数")
    private Integer graduateStudentsNumber;

    @ApiModelProperty("参加单位")
    private String participatingUnits;

    @ApiModelProperty("项目实际进度情况（包括经济、技术等指标完成情况，重点介绍课题进展、重大突破及工作成效等）（限300字以内）")
    private String actualProgressProject;

    @ApiModelProperty("课题资金使用情况（包括资金落实、使用及存在问题）（限200字以内）")
    private String projectFundsUsage;

    @ApiModelProperty("项目执行过程中存在的问题、解决措施及有关建议（限200字以内）")
    private String recommendationsProblemsSolutions;

    @ApiModelProperty("承担单位联系人")
    private String bearContaacter;

    @ApiModelProperty("承担单位联系人电话")
    private String bearContaactPhone;

    @ApiModelProperty("中期检查附件")
    private String annexMidInspection;

    public MidCheckDTO() {

    }

}
