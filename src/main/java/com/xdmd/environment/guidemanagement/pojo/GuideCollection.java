package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  guide_declaration
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("guide_collection")
public class GuideCollection implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("指南建议申报")
    private String guideName;

    @ApiModelProperty("所属领域")
    private Integer domain;

    @ApiModelProperty("所属类别")
    private Integer category;

    @ApiModelProperty("填报单位")
    private String fillUnit;

    @ApiModelProperty("填报联系人")
    private String fillContacts;

    @ApiModelProperty("单位负责人(签字)")
    private String headUnit;

    @ApiModelProperty("建议理由及依据(300字以内)")
    private String reasonBasis;

    @ApiModelProperty("主要研究内容和关键技术(300字以内)")
    private String researchContentTechnology;

    @ApiModelProperty("预期目标和成果（200字以内）")
    private String expectedGoalsResults;

    @ApiModelProperty("拟出标准、技术规范、法规名称")
    private String standardsSpecificationsRegulatory;

    @ApiModelProperty("研究期限")
    private Integer durationResearch;

    @ApiModelProperty("研究经费测算（万元）")
    private BigDecimal researchFundingEstimates;

    @ApiModelProperty("示范工程规模")
    private String demonstration;

    @ApiModelProperty("示范工程点")
    private String demonstrationEngineeringSites;

    @ApiModelProperty("省内从事该领域的主要研究机构")
    private String provinceDomainInstitutions;

    @ApiModelProperty("联系电话(手机)")
    private Integer contactPhone;

    @ApiModelProperty("申报状态（0 未审核 1 审核通过 2 审核未通过）")
    private Integer declarationStatus;

    public GuideCollection() {
    }

}