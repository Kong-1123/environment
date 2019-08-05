package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/1
 * @description: 指南汇总实体
 */
@Data
@ApiModel("gue_summary")
public class GuideSummary {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("指南汇总标题")
    private String gueSummaryTitle;

    @ApiModelProperty("指南建议名称")
    private String gueName;

    @ApiModelProperty("所属领域")
    private String domain;

    @ApiModelProperty("填报类别（所属类别）")
    private String category;

    @ApiModelProperty("填报单位")
    private String fillUnit;

    @ApiModelProperty("填报联系人")
    private String fillContacts;

    @ApiModelProperty("研究期限")
    private Integer researchPeriod;

    @ApiModelProperty("建议理由及依据")
    private String reasonBasis;

    @ApiModelProperty("主要研究内容和关键技术")
    private String researchContentTechnology;

    @ApiModelProperty("预期目标和成果")
    private String expectedTargetOutcome;

    @ApiModelProperty("拟出标准、技术规范、法规名称")
    private String standardsSpecificationsRegulatory;

    @ApiModelProperty("研究经费测算")
    private Integer researchFund;

    @ApiModelProperty("示范工程规模")
    private String demonstrationScale;

    @ApiModelProperty("示范工程点")
    private String demonstrationPoint;

    @ApiModelProperty("省内从事该领域的主要研究机构")
    private String provinceDomainMechanism;

    @ApiModelProperty("联系电话(手机)")
    private String contactPhone;

    @ApiModelProperty("建议立项时间")
    private String projectTime;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("查重结果")
    private String checkBackResult;

    @ApiModelProperty("查重备注")
    private String checkBackNote;

    @ApiModelProperty("归属大类")
    private String ownershipCategory;

    public GuideSummary() {
    }
    
}
