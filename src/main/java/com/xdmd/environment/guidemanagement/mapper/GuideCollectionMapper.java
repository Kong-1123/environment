package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * guide_collection
 * @author Kong
 * @date 2019/07/15
 */
@Mapper
@Repository
public interface GuideCollectionMapper {

    /**
     * [新增]
     * @author Kong
     * @date 2019/07/15
     **/
    @Insert(value ="insert into guide_collection \n" +
            "(guide_name,domain,Category,fill_unit,Fill_contacts,head_unit,reason_basis,research_content_technology,expected_goals_results,standards_specifications_regulatory,duration_research,Research_funding_estimates,demonstration_ project_scale,demonstration_engineering_sites,province_domain_Institutions,contact_phone,declaration_status)\n" +
            "values (#{guideName},#{domain},#{category},#{fillUnit},#{fillContacts},#{headUnit},#{reasonBasis},#{researchContentTechnology},#{expectedGoalsResults},#{standardsSpecificationsRegulatory},#{durationResearch},#{researchFundingEstimates},#{demonstration},#{demonstrationEngineeringSites},#{provinceDomainInstitutions},#{contactPhone},#{declarationStatus})")
    Integer insertGuideInfo(@Param("guideCollection") GuideCollection guideCollection);

    /**
     * [刪除]
     * @author Kong
     * @date 2019/07/15
     **/
    //int delete(@Param("id") int id);

    /**
     * [更新]
     * @author Kong
     * @date 2019/07/15
     **/
    //int update(@Param("guideCollection") GuideCollection guideCollection);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @param id
     * @return
     */
    @Select(value = "select * from guide_collection where id=#{id}")
    GuideCollection findOneGuideInfo(@Param("id") int id);



    /**
     * [查詢] 获取所有指南信息
     * @return
     */
    @Select(value = "select * from guide_collection")
    List<GuideCollection> findAllGuideInfo();
}
