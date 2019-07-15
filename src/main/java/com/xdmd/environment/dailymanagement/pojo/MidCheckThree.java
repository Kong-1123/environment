package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 中期检查-part-3
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("mid_check_three")
public class MidCheckThree {

    @ApiModelProperty("id")
    private Integer id;

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

    public MidCheckThree() {
    }

}
