package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: Kong
 * @createDate: 2019/8/1
 * @description: 指南汇总实体
 */
@Data
@ApiModel(description ="指南汇总信息")
public class GuideSummary {
    @ApiModelProperty("主键【注:系统默认生成,新增时不用填】")
    private Integer id;

    @ApiModelProperty("指南汇总标题")
    private String guideSummaryTitle;

    @ApiModelProperty("指南建议名称")
    private String guideName;

    @ApiModelProperty("所属领域")
    private Integer domain;

    @ApiModelProperty("填报类别（所属类别）")
    private Integer category;

    @ApiModelProperty("单位类别")
    private String unitCategory;

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

    @ApiModelProperty("研究经费预算")
    private BigDecimal researchFund;

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
    private Integer ownershipCategory;

    @ApiModelProperty("创建时间【注:系统默认生成,新增时不用填】")
    private Date createTime;

    public GuideSummary() {
    }
    
}
