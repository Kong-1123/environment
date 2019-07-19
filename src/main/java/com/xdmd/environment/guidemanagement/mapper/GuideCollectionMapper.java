package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.common.Dictionary;
import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
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
     * [查詢] 分页查询
     * @return
     */
    @Select(value = "SELECT\n" +
            "\tgc.guide_name,\n" +
            "\tgc.domain,\n" +
            "\tgc.category,\n" +
            "\tgc.research_fund,\n" +
            "\tgc.research_period,\n" +
            "\tgc.fill_unit,\n" +
            "\tgc.fill_contacts,\n" +
            "\tgc.contact_phone \n" +
            "FROM\n" +
            "\tguide_collection AS gc")
    List<GuideCollection> findAllGuideInfo();


    @Select(value = "SELECT\n" +
            "\td.id,\n" +
            "\td.classification,\n" +
            "\td.content \n" +
            "FROM\n" +
            "\tdictionary d \n" +
            "WHERE\n" +
            "\tclassification = '所属类别' UNION ALL\n" +
            "SELECT\n" +
            "\tdic.id,\n" +
            "\tdic.classification,\n" +
            "\tdic.content \n" +
            "FROM\n" +
            "\tdictionary dic \n" +
            "WHERE\n" +
            "\tclassification = '所属领域'")
    List<Dictionary> findDic();
}
