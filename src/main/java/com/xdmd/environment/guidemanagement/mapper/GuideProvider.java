package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/07/25
 * @description: 注解实现类
 */
public class GuideProvider {

    /**
     * 指南申报分页查询
     *
     * @param map
     * @return
     */
    @Results({
            @Result(property = "guideName", column = "guide_name"),
            @Result(property = "domain", column = "domain"),
            @Result(property = "category", column = "category"),
            @Result(property = "fill_unit", column = "guide_name"),
            @Result(property = "fill_contacts", column = "guide_name"),
            @Result(property = "contact_hone", column = "guide_name")
    })
    public String collectionInfoSql(final Map<String, Object> map) {

        /**
         * 将参数存入map集合
         * concat('%',#{contactPhone},'%'
         */
        map.put("guideName", "guideName");
        map.put("domain", "domain");
        map.put("category", "category");
        map.put("fillUnit", "fillUnit");
        map.put("fillContacts", "fillContacts");
        map.put("contactPhone", "contactPhone");
        return new SQL() {
            {
                SELECT("*");
                FROM("guide_collection");
                if (map.get("guideName") != null && map.get("guideName") != "") {
                    WHERE("guide_name like concat('%',#{guideName},'%')");
                }
                if (map.get("domain") != null) {
                    WHERE("domain =#{domain}");
                }
                if (map.get("category") != null) {
                    WHERE("category =#{category}");
                }
                if (map.get("fillUnit") != null && map.get("fillUnit") != "") {
                    WHERE("fill_unit like concat('%',#{fillUnit},'%')");
                }
                if (map.get("fillContacts") != null && map.get("fillContacts") != "") {
                    WHERE("fill_contacts like concat('%',#{fillContacts},'%')");
                }
                if (map.get("contactPhone") != null && map.get("contactPhone") != "") {
                    WHERE("contact_phone like concat('%',#{contactPhone},'%')");
                }
            }
        }.toString();
    }

    /**
     * 新增申报信息
     *
     * @return
     */
    public String insertCollectionSql(final GuideCollection guideCollection) {
        return new SQL() {
            {
                INSERT_INTO("guide_collection");
                INTO_COLUMNS("guide_name", "domain", "category", "fill_unit", "fill_contacts", "unit_principal", "reason_basis", "research_content_technology", "expected_target_outcome", "standards_specifications_regulatory", "research_period", "research_fund", "demonstration_scale", "demonstration_point", "province_domain_mechanism", "contact_phone", "declaration_status", "create_time");
                INTO_VALUES("#{guideName}", "#{domain}", "#{category}", "#{fillUnit}", "#{fillContacts}", "#{unitPrincipal}", "#{reasonBasis}", "#{researchContentTechnology}", "#{expectedTargetOutcome}", "#{standardsSpecificationsRegulatory}", "#{researchPeriod}", "#{researchFund}", "#{demonstrationScale}", "#{demonstrationPoint}", "#{provinceDomainMechanism}", "#{contactPhone}", "#{declarationStatus}", "default");
            }
        }.toString();
    }

    /**
     * 新增汇总信息
     * @param guideSummary
     * @return
     */
    public String insertSummarySql(final GuideSummary guideSummary) {
        return new SQL() {
            {
                INSERT_INTO("guide_summary");
                INTO_COLUMNS("guide_name","domain","category","fill_unit","fill_contacts","research_period","reason_basis","research_content_technology","expected_target_outcome","standards_specifications_regulatory","research_fund","demonstration_scale","demonstration_point","province_domain_mechanism","contact_phone","guide_summary_title","unit_category","project_time","note","check_back_result","check_back_note","create_time"
                );
                INTO_VALUES("#{guideName}","#{domain}","#{category}","#{fillUnit}","#{fillContacts}","#{researchPeriod}","#{reasonBasis}","#{researchContentTechnology}","#{expectedTargetOutcome}","#{standardsSpecificationsRegulatory}","#{researchFund}","#{demonstrationScale}","#{demonstrationPoint}","#{provinceDomainMechanism}","#{contactPhone}","#{guideSummaryTitle}","#{unitCategory}","#{projectTime}","#{note}","#{checkBackResult}","#{checkBackNote}","DEFAULT"
                );
            }
        }.toString();
    }


}