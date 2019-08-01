package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.common.Dictionary;
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
     * 根据单位id查询单位指南申报
     * @param id
     * @return
     */
    @Select(value = "SELECT\n" +
            "gc.*\n" +
            "FROM\n" +
            "guide_collection gc,\n" +
            "unit_guide_collection ugc\n" +
            "WHERE\n" +
            "gc.id = ugc.guide_collection_id\n" +
            "AND ugc.unit_id =#{id}")
    List<GuideCollection> getCollectionById(int id);


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
            "SELECT\n" +
            "\tgc.*,\n" +
            "\td.content AS 类别,\n" +
            "\tdic.content AS 领域 \n" +
            "FROM\n" +
            "\tguide_collection gc\n" +
            "\tINNER JOIN dictionary d ON gc.category = d.id\n" +
            "\tINNER JOIN dictionary dic ON gc.domain = dic.id" +
            "<where>" +
            "<if test ='null != guideName'>\n" +
            "AND guide_name like CONCAT('%',#{guideName},'%')\n" +
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
    List<GuideCollection> getCollectionByParam(String guideName,Integer domain,Integer category,String fillUnit,String fillContacts,String contactPhone);

    /***
     * @Description:
     * @Param: [] 获取指南申报全部信息
     * @return: java.util.List<com.xdmd.environment.guidemanagement.pojo.GuideCollection>
     * @Author: Kong
     * @Date: 2019/8/2
    */
    @Select(value = "SELECT\n" +
            "\tgc.* ,d.content as 类别,dic.content as 领域\n" +
            "FROM\n" +
            "\tguide_collection gc,dictionary d,dictionary dic\n" +
            "WHERE gc.category=d.id and gc.domain=dic.id")
    List<GuideCollection> getAllCollections();

    /**
     * 获取所属领域和所属类别
     * @return
     */
    @Select(value = "SELECT classification,content FROM dictionary WHERE classification IN ('所属类别','所属领域')")
    List<Dictionary> getCategoryAndDomain();

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
     * @param guideSummaryV2
     * @return
     */
    @Insert(value = "INSERT INTO guide_summary_v2 (" +
            "category," +
            "guide_collection_id," +
            "guide_summary_title," +
            "unit_category," +
            "project_time," +
            "note," +
            "check_back_result," +
            "check_back_note)\t" +
            "VALUES(" +
            "#{category}," +
            "#{guideCollectionId}," +
            "#{guideSummaryTitle}," +
            "#{unitCategory}," +
            "#{projectTime}," +
            "#{note}," +
            "#{checkBackResult}," +
            "#{checkBackNote})")
    int insertSummary(GuideSummaryV2 guideSummaryV2);

    /**
     * 查询全部汇总信息
     * @return
     */
    @Select(value = "<script>" +
            "select * from guide_summary_v2\n" +
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
