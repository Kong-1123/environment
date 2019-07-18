package com.xdmd.environment.guidemanagement.mapper;

import com.github.pagehelper.Page;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
    @Insert(value = "INSERT INTO guide_collection (guide_name,domain,category,fill_unit,fill_contacts,unit_principal,reason_basis,research_content_technology,expected_target_outcome,standards_specifications_regulatory,research_period,research_fund,demonstration_scale,demonstration_point,province_domain_mechanism,contact_phone,declaration_status ) VALUES(#{guideName},#{domain},#{category},#{fillUnit},#{fillContacts},#{unitPrincipal},#{reasonBasis},#{researchContentTechnology},#{expectedTargetOutcome},#{standardsSpecificationsRegulatory}#{researchPeriod},#{researchFund},#{demonstrationScale},#{demonstrationPoint},#{provinceDomainMechanism},#{contactPhone},#{declarationStatus})")
    int insertGuideInfo(@Param("guideCollection") GuideCollection guideCollection);

    /**
     * [查詢] 根據主鍵 id 查詢（测试）
     * @param id
     * @return
     */
    @Select(value = "select gc.guide_name,d.content,dic.content,gc.research_fund,gc.research_period,gc.fill_unit,gc.fill_contacts,gc.contact_phone\n" +
            "from guide_collection as gc\n" +
            "inner join dictionary d on gc.Category=d.id\n" +
            "inner join dictionary dic on gc.domain=dic.id where gc.id=#{id}")
    GuideCollection findOneGuideInfo(@Param("id") int id);



    /**
     * [查詢] 根據不同参数筛选指南信
     * @return
     */
    @Select(value = "select gc.guide_name,d.content,dic.content,gc.research_fund,gc.research_period,gc.fill_unit,gc.fill_contacts,gc.contact_phone from guide_collection as gc inner join dictionary d on gc.category=d.id inner join dictionary as dic on gc.domain=dic.id")
    Page<GuideCollection> findAllGuideInfo();
}
