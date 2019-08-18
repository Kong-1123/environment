package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideCollectionLimitTime;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * guide_collection
 * @author Kong
 * @date 2019/07/15
 */

@Repository
public interface GuideMapper {
    /**
     * 新增指南申报建议(外网)
     * @param guideCollection
     * @return
     */
        @Insert(value = "INSERT INTO guide_collection\t"+
                "VALUES(" +
                "DEFAULT,\n" +
                "#{guideName},\n" +
                "#{category},\n" +
                "#{domain},\n" +
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
                "DEFAULT,DEFAULT,DEFAULT)")
    int insertGuideInfo(GuideCollection guideCollection);

    /**
     * 根据单位id查询单位指南申报(外网)
     * 注意:传的是单位id，不是指南申报id
     * @param Uid
     * @return
     */
    @Select(value = "<script>" +
            "SELECT\n" +
            "guide_name,\n" +
            "dic.content as domain,\n" +
            "d.content as category,\n" +
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
            "declaration_status\t\n" +
            "FROM\n" +
            "\tguide_collection gc,\n" +
            "\tdictionary d,\n" +
            "\tdictionary dic,\n" +
            "\tunit_guide_collection ugc \n" +
            "<where>" +
            "\tgc.id = ugc.collection_id \n" +
            "\tAND gc.category = d.id \n" +
            "\tAND gc.domain = dic.id \n" +
            "\tAND ugc.unit_id =#{Uid} \n" +
            "<if test ='null != guideName'>\n" +
            "gc.guide_name like CONCAT('%',#{guideName},'%')\n" +
            "</if>\n" +
            "<if test ='null != domain'>\n" +
            "AND gc.domain =#{domain}\n" +
            "</if>\n" +
            " <if test ='null != category'>\n" +
            " AND gc.category = #{category}\n" +
            " </if>\n" +
            "<if test ='null != fillUnit'>\n" +
            "AND gc.fill_unit like CONCAT('%',#{fillUnit},'%')</if>\n" +
            "<if test ='null != fillContacts'>\n" +
            "AND gc.fill_contacts like CONCAT('%',#{fillContacts},'%')\n" +
            "</if>\n" +
            "<if test ='null != contactPhone'>\n" +
            "AND gc.contact_phone like CONCAT('%',#{contactPhone},'%')</if>\n" +
            "</where>" +
            "</script>")
    List<Map> getCollectionByUid(String guideName, Integer domain, Integer category, String fillUnit, String fillContacts, String contactPhone,int Uid);

    /**
     * [新增]单位关联指南征集
     * @return
     */
    @Insert(value = "INSERT INTO unit_guide_collection (unit_id,collection_id)VALUES(#{unitId},#{collectionId})")
    int insert(int unitId,int collectionId);


    /**
     * 根据勾选的指南id获取选相应指南申报信息(内网)--汇总2
     * @param ids
     * @return
    */
    @Select(value ="<script>\n" +
            "SELECT\n" +
            "gc.id,\n" +
            "gc.guide_name,\n" +
            "dic.content As domain,\n" +
            "d.content As category,\n" +
            "gc.fill_unit,\n" +
            "gc.fill_contacts,\n" +
            "gc.reason_basis,\n" +
            "gc.research_content_technology,\n" +
            "gc.expected_target_outcome,\n" +
            "gc.standards_specifications_regulatory,\n" +
            "gc.research_period,\n" +
            "gc.research_fund,\n" +
            "gc.demonstration_scale,\n" +
            "gc.demonstration_point,\n" +
            "gc.province_domain_mechanism,\n" +
            "gc.contact_phone\n" +
            "FROM\n" +
            "guide_collection AS gc,dictionary AS dic,dictionary AS d\n" +
            "where gc.domain=dic.id AND gc.category=d.id AND gc.id in\n" +
            "<foreach\tcollection='list'\titem='gcId'\topen='(' separator=',' close=')'>" +
            "#{gcId}\n" +
            "</foreach>\n" +
            "</script>")
    @Results(value = { @Result(column = "id", property = "id") })
    List<Map> getCollectionByIds(List<Long> ids);
    /**
     * 分页查询指南申报(内网)--汇总1
     * @param guideName
     * @param domain
     * @param category
     * @param fillUnit
     * @param fillContacts
     * @param contactPhone
     * @return
     */
    @Select(value = "<script>" +
            "SELECT\t" +
            "gc.id," +
            "guide_name,\n" +
            "dic.content as domain,\n" +
            "d.content as category,\n" +
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
            "declaration_status\t" +
            "FROM\n" +
            "\tguide_collection gc\t\n" +
            "\tINNER JOIN dictionary d ON gc.category = d.id\n" +
            "\tINNER JOIN dictionary dic ON gc.domain = dic.id\t" +
            "<where>" +
            "<if test ='null != guideName'>\n" +
            "gc.guide_name like CONCAT('%',#{guideName},'%')\n" +
            "</if>\n" +
            "<if test ='null != domain'>\n" +
            "AND gc.domain =#{domain}\n" +
            "</if>\n" +
            " <if test ='null != category'>\n" +
            " AND gc.category = #{category}\n" +
            " </if>\n" +
            "<if test ='null != fillUnit'>\n" +
            "AND gc.fill_unit like CONCAT('%',#{fillUnit},'%')</if>\n" +
            "<if test ='null != fillContacts'>\n" +
            "AND gc.fill_contacts like CONCAT('%',#{fillContacts},'%')\n" +
            "</if>\n" +
            "<if test ='null != contactPhone'>\n" +
            "AND gc.contact_phone like CONCAT('%',#{contactPhone},'%')</if>\n" +
            "</where>" +
            "</script>")
    List<Map> getCollectionByParam(String guideName, Integer domain, Integer category, String fillUnit, String fillContacts, String contactPhone);

    /**
     * 获取所属领域和所属类别（内外网）
     * @return
     */
    @Select(value = "SELECT id,classification,content FROM dictionary WHERE classification IN ('所属类别','所属领域')")
    List<Map> getCategoryAndDomain();


    /**
     * 更新限制时间(内网)
     * @param guideCollectionLimitTime
     * @return
     */
    @Update(value = "UPDATE guide_collection_limit_time \n" +
            "SET guide_collection_start_time = date(#{guideCollectionStartTime}),\n" +
            "guide_collection_end_time = date(#{guideCollectionEndTime})")
    int updateLimitTime(GuideCollectionLimitTime guideCollectionLimitTime);


    /**
     * 新增汇总信息【单条插入】(内网)--汇总3
     * @param guideSummary
     * @return
     */
    @Insert(value = "INSERT INTO guide_summary\n" +
            "VALUES(\n" +
            "DEFAULT,\n" +
            "#{guideSummaryTitle},\n" +
            "#{guideName},\n" +
            "#{domain},\n" +
            "#{category},\n" +
            "#{unitCategory},\n" +
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
            "#{projectTime},\n" +
            "#{note},\n" +
            "#{checkBackResult},\n" +
            "#{checkBackNote},\n" +
            "#{ownershipCategory},\n" +
            "DEFAULt)")
    int insertSummary(GuideSummary guideSummary);

    /**
     * 新增汇总信息【批量插入】
     * @param guideSummary
     * @return
     */
    @InsertProvider(type = GuideCollectionProvider.class, method = "batchInsertSummary")
    int batchInsertSummary(@Param("list") List<GuideSummary> guideSummary);

    /**
     * 查询全部汇总信息(要修改)--汇总4
     * @return
     */
    @Select(value = "<script>" +
            "SELECT\t" +
            "gs.id," +
            "gs.guide_name,\n" +
            "dic.content as domain,\n" +
            "d.content as category,\n" +
            "gs.fill_unit,\n" +
            "gs.fill_contacts,\n" +
            "gs.reason_basis,\n" +
            "gs.research_content_technology,\n" +
            "gs.expected_target_outcome,\n" +
            "gs.standards_specifications_regulatory,\n" +
            "gs.research_period,\n" +
            "gs.research_fund,\n" +
            "gs.demonstration_scale,\n" +
            "gs.demonstration_point,\n" +
            "gs.province_domain_mechanism,\n" +
            "gs.contact_phone,\n" +
            "gs.guide_summary_title,\n" +
            "gs.unit_category,\n" +
            "gs.project_time,\n" +
            "gs.note,\n" +
            "gs.check_back_result,\n" +
            "gs.check_back_note,\n" +
            "gs.ownership_category\n" +
            "FROM\n" +
            "guide_summary gs,dictionary dic,dictionary d\n" +
            "where gs.domain = dic.id and gs.category=d.id\n" +
            "<if test ='null != guideSummaryTitle'>\n" +
            "AND gs.guide_summary_title like CONCAT('%',#{guideSummaryTitle},'%')\n" +
            "</if>\n" +
            "<if test ='null != fillUnit'>\n" +
            "AND gs.fill_unit like CONCAT('%',#{fillUnit},'%')\n" +
            "</if>\n" +
            "<if test ='null != domain'>\n" +
            "AND gs.domain =#{domain}\n" +
            "</if>\n" +
            "<if test ='null != category'>\n" +
            "AND gs.category like CONCAT('%',#{category},'%')\n" +
            "</if>\n" +
            "<if test ='null != projectTime'>\n" +
            "AND gs.project_time like CONCAT('%',#{projectTime},'%')\n" +
            "</if>\n" +
            "<if test ='null != researchContentTechnology'>\n" +
            "AND gs.research_content_technology like CONCAT('%',#{researchContentTechnology},'%')\n" +
            "</if>\n" +
            "</script>")
    List<Map> getSummaryByParam(@Param("guideSummaryTitle") String guideSummaryTitle,@Param("fillUnit")String fillUnit,@Param("domain") Integer domain,@Param("category") Integer category,@Param("projectTime") String projectTime,@Param("researchContentTechnology") String researchContentTechnology);

    /**
     * 根据汇总标题查询出汇总指南--汇总5
     * @return
     */
    @Select(value = "<script>" +
            "SELECT\t" +
            "gs.id," +
            "gs.guide_name,\n" +
            "dic.content as domain,\n" +
            "d.content as category,\n" +
            "gs.fill_unit,\n" +
            "gs.fill_contacts,\n" +
            "gs.reason_basis,\n" +
            "gs.research_content_technology,\n" +
            "gs.expected_target_outcome,\n" +
            "gs.standards_specifications_regulatory,\n" +
            "gs.research_period,\n" +
            "gs.research_fund,\n" +
            "gs.demonstration_scale,\n" +
            "gs.demonstration_point,\n" +
            "gs.province_domain_mechanism,\n" +
            "gs.contact_phone,\n" +
            "gs.guide_summary_title,\n" +
            "gs.unit_category,\n" +
            "gs.project_time,\n" +
            "gs.note,\n" +
            "gs.check_back_result,\n" +
            "gs.check_back_note,\n" +
            "gs.ownership_category\n" +
            "FROM\n" +
            "guide_summary gs,dictionary dic,dictionary d\n" +
            "where gs.domain = dic.id and gs.category=d.id\n" +
            "<if test ='null != guideSummaryTitle'>\n" +
            "AND gs.guide_summary_title like CONCAT('%',#{guideSummaryTitle},'%')\n" +
            "</if></script>")
    List<Map> getSummaryByGuideSummaryTitle(@Param("guideSummaryTitle") String guideSummaryTitle);

}