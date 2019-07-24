package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * guide_collection
 * @author Kong
 * @date 2019/07/15
 */

@Repository
public interface GuideMapper {

    /**
     * 新增指南申报建议
     * @param guideCollection
     * @return
     */
        @Insert(value = "INSERT INTO guide_collection (\n" +
                "guide_name,\n" +
                "domain,\n" +
                "category,\n" +
                "fill_unit,\n" +
                "fill_contacts,\n" +
                "unit_principal,\n" +
                "reason_basis,\n" +
                "research_content_technology,\n" +
                "expected_target_outcome,\n" +
                "standards_specifications_regulatory,\n" +
                "research_period,\n" +
                "research_fund,\n" +
                "demonstration_scale,\n" +
                "demonstration_point,\n" +
                "province_domain_mechanism,\n" +
                "contact_phone,\n" +
                "declaration_status,\n" +
                "create_time\n" +
                ")\n" +
                "VALUES\n" +
                "\t(\n" +
                "#{guideName},\n" +
                "#{domain},\n" +
                "#{category},\n" +
                "#{fillUnit},\n" +
                "#{fillContacts},\n" +
                "#{unitPrincipal},\n" +
                "#{reasonBasis},\n" +
                "#{researchContentTechnology},\n" +
                "#{expectedTargetOutcome},\n" +
                "#{standardsSpecificationsRegulatory},\n" +
                "#{researchPeriod},\n" +
                "#{researchFund},\n" +
                "#{demonstrationScale},\n" +
                "#{demonstrationPoint},\n" +
                "#{provinceDomainMechanism},\n" +
                "#{contactPhone},\n" +
                "#{declarationStatus},default)")
    int insertGuideInfo(GuideCollection guideCollection);

    /**
     * 分页查询
     * @param id
     * @return
     */
    @Select(value = "SELECT\n" +
            "gc.guide_name,\n" +
            "gc.domain,\n" +
            "gc.category,\n" +
            "gc.fill_unit,\n" +
            "gc.fill_contacts,\n" +
            "gc.unit_principal,\n" +
            "gc.reason_basis,\n" +
            "gc.research_content_technology,\n" +
            "gc.expected_target_outcome,\n" +
            "gc.standards_specifications_regulatory,\n" +
            "gc.research_period,+ gc.research_fund,\n" +
            "gc.demonstration_scale,\n" +
            "gc.demonstration_point,\n" +
            "gc.province_domain_mechanism,\n" +
            "gc.contact_phone,\n" +
            "gc.declaration_status,\n" +
            "gc.create_time \n" +
            "FROM\n" +
            "guide_collection gc,\n" +
            "domain d,\n" +
            "category c \n" +
            "WHERE\n" +
            "gc.domain = d.id \n" +
            "AND gc.category = c.id")
    List<GuideCollection> getAllGuideInfo();

    /**
     * 获取所属领域
     * @return
     */
    @Select(value = "select * from domain")
    List<Domain> getAllDomain();
    /**
     * 获取所属类别
     * @return
     */
    @Select(value = "select * from Category")
    List<Category> getAllCategory();

    /**
     * 更新限制时间
     * @param guideCollectionLimitTime
     * @return
     */
    @Update(value = "UPDATE guide_collection_limit_time \n" +
            "SET guide_collection_start_time = date(#{guideCollectionStartTime}),\n" +
            "guide_collection_end_time = date(#{guideCollectionEndTime})")
    int updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime);


    /**
     * 新增汇总信息
     * @param guideSummary
     * @return
     */
    @Insert(value = "INSERT INTO guide_summary (" +
            "guide_name,\n" +
            "domain,\n" +
            "category,\n" +
            "fill_unit,\n" +
            "fill_contacts,\n" +
            "research_period,\n" +
            "reason_basis,\n" +
            "research_content_technology,\n" +
            "expected_target_outcome,\n" +
            "standards_specifications_regulatory,\n" +
            "research_fund,\n" +
            "demonstration_scale,\n" +
            "demonstration_point,\n" +
            "province_domain_mechanism,\n" +
            "contact_phone,\n" +
            "guide_summary_title,\n" +
            "unit_category,\n" +
            "project_time,\n" +
            "note,\n" +
            "check_back_result,\n" +
            "check_back_note,\n" +
            "create_time)" +
            "VALUES(" +
            "#{guideName},\n" +
            "#{domain},\n" +
            "#{category},\n" +
            "#{fillUnit},\n" +
            "#{fillContacts},\n" +
            "#{researchPeriod},\n" +
            "#{reasonBasis},\n" +
            "#{researchContentTechnology},\n" +
            "#{expectedTargetOutcome},\n" +
            "#{standardsSpecificationsRegulatory},\n" +
            "#{researchFund},\n" +
            "#{demonstrationScale},\n" +
            "#{demonstrationPoint},\n" +
            "#{provinceDomainMechanism},\n" +
            "#{contactPhone},\n" +
            "#{guideSummaryTitle},\n" +
            "#{unitCategory},\n" +
            "#{projectTime},\n" +
            "#{note},\n" +
            "#{checkBackResult},\n" +
            "#{checkBackNote},\n" +
            "DEFAULT)")
    int insertSummary(GuideSummary guideSummary);

    /**
     * 查询全部汇总信息(未完成)
     * @return
     */
    @Select(value = "select * from guide_summary where")

    List<GuideSummary> getAllSummary();





}
