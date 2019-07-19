package com.xdmd.environment.guidemanagement.mapper;

import com.github.pagehelper.Page;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.annotations.Insert;
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
//    @Insert(value = "INSERT INTO guide_collection (guide_name,domain,category,fill_unit,fill_contacts,unit_principal,reason_basis,research_content_technology,expected_target_outcome,standards_specifications_regulatory,research_period,research_fund,demonstration_scale,demonstration_point,province_domain_mechanism,contact_phone,declaration_status ) VALUES(#{guideName},#{domain},#{category},#{fillUnit},#{fillContacts},#{unitPrincipal},#{reasonBasis},#{researchContentTechnology},#{expectedTargetOutcome},#{standardsSpecificationsRegulatory}#{researchPeriod},#{researchFund},#{demonstrationScale},#{demonstrationPoint},#{provinceDomainMechanism},#{contactPhone},#{declarationStatus})")
        @Insert(value = "INSERT INTO guide_collection (\n" +
                "\tguide_name,\n" +
                "\tdomain,\n" +
                "\tcategory,\n" +
                "\tfill_unit,\n" +
                "\tfill_contacts,\n" +
                "\tunit_principal,\n" +
                "\treason_basis,\n" +
                "\tresearch_content_technology,\n" +
                "\texpected_target_outcome,\n" +
                "\tstandards_specifications_regulatory,\n" +
                "\tresearch_period,\n" +
                "\tresearch_fund,\n" +
                "\tdemonstration_scale,\n" +
                "\tdemonstration_point,\n" +
                "\tprovince_domain_mechanism,\n" +
                "\tcontact_phone,\n" +
                "\tdeclaration_status \n" +
                ")\n" +
                "VALUES\n" +
                "\t(\n" +
                "\t\t#{guideName},\n" +
                "\t\t#{domain},\n" +
                "\t\t#{category},\n" +
                "\t\t#{fillUnit},\n" +
                "\t\t#{fillContacts},\n" +
                "\t\t#{unitPrincipal},\n" +
                "\t\t#{reasonBasis},\n" +
                "\t\t#{researchContentTechnology},\n" +
                "\t\t#{expectedTargetOutcome},\n" +
                "\t\t#{standardsSpecificationsRegulatory},\n" +
                "\t\t#{researchPeriod},\n" +
                "\t\t#{researchFund},\n" +
                "\t\t#{demonstrationScale},\n" +
                "\t\t#{demonstrationPoint},\n" +
                "\t\t#{provinceDomainMechanism},\n" +
                "\t#{contactPhone},\n" +
                "\t#{declarationStatus})")
    int insertGuideInfo(GuideCollection guideCollection);

    /**
     * [查詢] 根據主鍵 id 查詢（测试）
     * @param id
     * @return
     */
    @Select(value = "select gc.guide_name,d.content,dic.content,gc.research_fund,gc.research_period,gc.fill_unit,gc.fill_contacts,gc.contact_phone\n" +
            "from guide_collection as gc\n" +
            "inner join dictionary d on gc.Category=d.id\n" +
            "inner join dictionary dic on gc.domain=dic.id where gc.id=#{id}")
    GuideCollection findOneGuideInfo(int id);



    /**
     * [查詢] 分页查询
     * @return
     */
    @Select(value = "\tSELECT\n" +
            "\t\tgc.guide_name,\n" +
            "\t\tgc.d.content\n" +
            "\t\tgc.dic.content \n" +
            "\t\tgc.research_fund\n" +
            "\t\tgc.research_period,\n" +
            "\t\tgc.fill_unit,\n" +
            "\t\tgc.fill_contacts,\n" +
            "\t\tgc.contact_phone \n" +
            "\tFROM\n" +
            "\t\tguide_collection AS gc\n" +
            "\t\tINNER JOIN dictionary d ON gc.Category = d.id\n" +
            "\t\tINNER JOIN dictionary dic ON gc.domain = dic.id")
    Page<GuideCollection> findAllGuideInfo();
}
