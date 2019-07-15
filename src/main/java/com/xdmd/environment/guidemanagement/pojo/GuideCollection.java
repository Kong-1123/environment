package com.xdmd.environment.guidemanagement.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 *  guide_declaration
 * @author Kong 2019-07-15
 */
@Data
public class GuideCollection implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 指南建议申报
     */
    private String guideName;

    /**
     * 所属领域
     */
    private Integer domain;

    /**
     * 所属类别
     */
    private Integer category;

    /**
     * 填报单位
     */
    private String fillUnit;

    /**
     * 填报联系人
     */
    private String fillContacts;

    /**
     * 单位负责人(签字)
     */
    private String headUnit;

    /**
     * 建议理由及依据(300字以内)
     */
    private String reasonBasis;

    /**
     * 主要研究内容和关键技术(300字以内)
     */
    private String researchContentTechnology;

    /**
     * 预期目标和成果（200字以内）
     */
    private String expectedGoalsResults;

    /**
     * 拟出标准、技术规范、法规名称
     */
    private String standardsSpecificationsRegulatory;

    /**
     * 研究期限
     */
    private Integer durationResearch;

    /**
     * 研究经费测算（万元）
     */
    private Double researchFundingEstimates;

    /**
     * 示范工程规模
     */
    private String demonstration;

    /**
     * 示范工程点
     */
    private String demonstrationEngineeringSites;

    /**
     * 省内从事该领域的主要研究机构
     */
    private String provinceDomainInstitutions;

    /**
     * 联系电话(手机)
     */
    private Integer contactPhone;

    /**
     * 申报状态（0 未审核 1 审核通过 2 审核未通过）
     */
    private Integer declarationStatus;

    /**
     * 无参
     */
    public GuideCollection() {
    }

}
