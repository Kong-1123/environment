package com.xdmd.environment.guidemanagement.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @author: Administrator
 * @createDate: 2019/07/16
 * @description: 根据入参获取相应结果信息
 */
public class FindGuideInfoByParamsProvider {
    public String FindGuideInfoByParams(Map<String, Object> params) {
        String guidename = (String) params.get("param1");
        String domain = (String) params.get("param2");
        String category = (String) params.get("param3");
        String fillunit = (String) params.get("param4");
        String fillcontact = (String) params.get("param5");
        String contactphone = (String) params.get("param6");

        return new SQL() {{
            SELECT("gc.guide_name,d.content,dic.content,gc.Research_funding_estimates,gc.duration_research,gc.fill_unit,gc.Fill_contacts,gc.contact_phone");
            FROM("guide_collection as gc");
            INNER_JOIN("dictionary d on gc.Category=d.id");
            INNER_JOIN("dictionary dic on gc.domain=dic.id");
            WHERE("gc.guide_name=#{guidename}");
        }}.toString();
    }
}
