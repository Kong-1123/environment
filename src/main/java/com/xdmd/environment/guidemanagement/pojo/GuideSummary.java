package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  guide_summary
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("guide_summary")
public class GuideSummary implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("指南汇总标题")
    private String guideSummaryTitle;

    @ApiModelProperty("指南建议名称id")
    private Integer guideNameId;

    @ApiModelProperty("所属领域id")
    private Integer domainId;

    @ApiModelProperty("填报类别（所属类别id）")
    private Integer categoryId;

    @ApiModelProperty("填报单位id")
    private Integer fillUnitId;

    @ApiModelProperty("填报联系人id")
    private Integer fillContactsId;

    @ApiModelProperty("研究期限id")
    private Integer durationResearchId;

    @ApiModelProperty("建议理由及依据id")
    private Integer reasonBasisId;

    @ApiModelProperty("主要研究内容和关键技术id")
    private Integer researchContentTechnologyId;

    @ApiModelProperty("预期目标和成果id")
    private Integer expectedGoalsResultsId;

    @ApiModelProperty("拟出标准、技术规范、法规名称id")
    private Integer standardsSpecificationsRegulatoryId;

    @ApiModelProperty("研究经费测算id")
    private Integer researchFundingEstimateId;

    @ApiModelProperty("示范工程规模id")
    private Integer demonstrationProjectScaleId;

    @ApiModelProperty("示范工程点id")
    private Integer demonstrationEngineeringSitesId;

    @ApiModelProperty("省内从事该领域的主要研究机构id")
    private Integer provinceDomainResearchinstitutionsId;

    @ApiModelProperty("联系电话(手机)")
    private Integer contactPhoneId;

    @ApiModelProperty("建议立项时间")
    private String projectTime;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("查重结果")
    private String checkBackResult;

    @ApiModelProperty("查重备注")
    private String checkBackNote;

    public GuideSummary() {
    }

}