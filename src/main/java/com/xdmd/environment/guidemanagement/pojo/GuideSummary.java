package com.xdmd.environment.guidemanagement.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *  guide_summary
 * @author Kong 2019-07-15
 */
@Data
public class GuideSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 指南汇总标题
     */
    private String guideSummaryTitle;

    /**
     * 指南建议名称id
     */
    private Integer guideNameId;

    /**
     * 所属领域id
     */
    private Integer domainId;

    /**
     * 填报类别（所属类别id）
     */
    private Integer categoryId;

    /**
     * 填报单位id
     */
    private Integer fillUnitId;

    /**
     * 填报联系人id
     */
    private Integer fillContactsId;

    /**
     * 研究期限id
     */
    private Integer durationResearchId;

    /**
     * 建议理由及依据id
     */
    private Integer reasonBasisId;

    /**
     * 主要研究内容和关键技术id
     */
    private Integer researchContentTechnologyId;

    /**
     * 预期目标和成果id
     */
    private Integer expectedGoalsResultsId;

    /**
     * 拟出标准、技术规范、法规名称id
     */
    private Integer standardsSpecificationsRegulatoryId;

    /**
     * 研究经费测算id
     */
    private Integer researchFundingEstimateId;

    /**
     * 示范工程规模id
     */
    private Integer demonstrationProjectScaleId;

    /**
     * 示范工程点id
     */
    private Integer demonstrationEngineeringSitesId;

    /**
     * 省内从事该领域的主要研究机构id
     */
    private Integer provinceDomainResearchinstitutionsId;

    /**
     * 联系电话(手机)
     */
    private Integer contactPhoneId;

    /**
     * 建议立项时间
     */
    private String projectTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 查重结果
     */
    private String checkBackResult;

    /**
     * 查重备注
     */
    private String checkBackNote;

    public GuideSummary() {
    }

}
