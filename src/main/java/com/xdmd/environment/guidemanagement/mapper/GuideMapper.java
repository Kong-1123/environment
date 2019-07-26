package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.*;
import org.apache.ibatis.annotations.*;
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
     * 根据id查询单位指南申报
     * @param id
     * @return
     */
    @Select(value = "select ")
    List<GuideCollection> getAllCollection(int id);


    /**
     * 指南申报分页查询
     * @param guideName
     * @param domain
     * @param category
     * @param fillUnit
     * @param fillContacts
     * @param contactPhone
     * @return
     */
    @Select(value = "<script>" +
            "SELECT * FROM guide_collection" +
            "<where>\n" +
            "<if test ='null != guideName'>\n" +
            "guide_name like CONCAT('%',#{guideName},'%')\n" +
            "</if>\n" +
            "<if test ='null != domain'>\n" +
            "AND domain =#{domain}\n" +
            "</if>\n" +
            " <if test ='null != category'>\n" +
            " AND category = #{category}\n" +
            " </if>\n" +
            "<if test ='null != fillUnit'>\n" +
            "AND fill_unit like CONCAT('%',#{fillUnit},'%')</if>\n" +
            "<if test ='null != fillContacts'>\n" +
            "AND fill_contacts like CONCAT('%',#{fillContacts},'%')\n" +
            "</if>\n" +
            "<if test ='null != contactPhone'>\n" +
            "AND contact_phone like CONCAT('%',#{contactPhone},'%')</if>\n" +
            "</where>" +
            "</script>")
    List<GuideCollection> getAllCollection(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone);

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
     * 查询全部汇总信息
     * @return
     */
    @Select(value = "<script>" +
            "select * from guide_summary\n" +
            "<where>\n" +
            " <if test ='null != guideSummaryTitle'>\n" +
            " guide_summary_title like CONCAT('%',#{guideSummaryTitle},'%')\n" +
            " </if>\n" +
            " <if test ='null != fillUnit'>\n" +
            " AND fill_unit like CONCAT('%',#{fillUnit},'%')\n" +
            " </if>\n" +
            " <if test ='null != domain'>\n" +
            " AND domain =#{domain}\n" +
            " </if>\n" +
            " <if test ='null != category'>\n" +
            " AND category like CONCAT('%',#{category},'%')\n" +
            " </if>\n" +
            " <if test ='null != projectTime'>\n" +
            "AND project_time like CONCAT('%',#{projectTime},'%')\n" +
            " </if>\n" +
            " <if test ='null != researchContentTechnology'>\n" +
            " AND research_content_technology like CONCAT('%',#{researchContentTechnology},'%')\n" +
            " </if>\n" +
            "</where>" +
            "</script>")
    List<GuideSummary> getAllSummary(@Param("guideSummaryTitle") String guideSummaryTitle,@Param("fillUnit")String fillUnit,@Param("domain") Integer domain,@Param("category") Integer category,@Param("projectTime") String projectTime,@Param("researchContentTechnology") String researchContentTechnology);

}
