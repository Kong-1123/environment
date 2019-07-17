package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * guide_collection
 * @author Kong
 * @date 2019/07/15
 */

@Repository
public interface GuideCollectionMapper {

    /**
     * [新增]
     * @author Kong
     * @date 2019/07/15
     **/
    @Insert(value = "INSERT INTO guide_collection (guide_name,domain,Category,fill_unit,Fill_contacts,head_unit,reason_basis,research_content_technology,expected_goals_results,standards_specifications_regulatory,duration_research,Research_funding_estimates,demonstration_project_scale,demonstration_engineering_sites,province_domain_Institutions,contact_phone,declaration_status )\n" +
            "VALUES(#{guideName},#{domain},#{category},#{fillUnit},#{fillContacts},#{headUnit},#{reasonBasis},#{reasonBasis},#{researchContentTechnology},#{expectedGoalsResults},#{durationResearch},#{researchFundingEstimates},#{demonstration},#{demonstrationEngineeringSites},#{provinceDomainInstitutions},#{contactPhone},#{declarationStatus})")
    Integer insertGuideInfo(@Param("guideCollection") GuideCollection guideCollection);

    /**
     * [查詢] 根據主鍵 id 查詢（测试）
     * @param id
     * @return
     */
    @Select(value = "select * from guide_collection where id=#{id}")
    GuideCollection findOneGuideInfo(@Param("id") int id);



    /**
     * [查詢] 根據不同参数筛选指南信息
     * @return
     */
    @SelectProvider(type=GuideInfoProvider.class,method="FindAllGuideInfoSql")
    List<GuideCollection> findAllGuideInfo();
}
