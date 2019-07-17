package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 根据入参获取相应结果信息
 */
public class GuideInfoProvider {

    public String FindAllGuideInfoSql(final GuideCollection guideCollection) {
        return new SQL() {{
            SELECT("gc.guide_name,d.content,dic.content,gc.Research_funding_estimates,gc.duration_research,gc.fill_unit,gc.Fill_contacts,gc.contact_phone");
            FROM("guide_collection as gc");
            INNER_JOIN("dictionary d on gc.Category=d.id");
            INNER_JOIN("dictionary dic on gc.domain=dic.id");
            if(guideCollection.getGuideName()!= null && guideCollection.getGuideName()!= ""){
                WHERE("gc.guide_name like CONCAT(CONCAT('%',#{guideName}),'%')");
            }
            if(guideCollection.getDomain()!= null){
                WHERE("gc.domain=#{domain}");
            }
            if(guideCollection.getCategory()!= null){
                WHERE("gc.category=#{category}");
            }
            if(guideCollection.getFillUnit()!= null && guideCollection.getFillUnit()!= ""){
                WHERE("gc.fill_unit like CONCAT(CONCAT('%',#{FillUnit}),'%')");
            }
            if(guideCollection.getFillContacts()!= null && guideCollection.getFillContacts()!= ""){
                WHERE("gc.Fill_contacts like CONCAT(CONCAT('%',#{FillContacts}),'%')");
            }
            if(guideCollection.getContactPhone()!= null && guideCollection.getContactPhone()!=""){
                WHERE("gc.contact_phone like CONCAT(CONCAT('%',#{ContactPhone}),'%')");
            }
            if(guideCollection.equals(null) && guideCollection.equals("")){
                WHERE("1=1");
            }
        }}.toString();
    }
}
