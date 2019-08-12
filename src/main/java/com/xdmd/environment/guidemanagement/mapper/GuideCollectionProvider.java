package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideSummary;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/08/08
 * @description: 指南征集sql工具类
 */
public class GuideCollectionProvider {
    /**
     * 新增汇总信息【批量插入】
     *
     * @param map
     * @return
     */
    public String batchInsertSummary(Map map) {
        List<GuideSummary> summaryList = (List<GuideSummary>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO guide_summary VALUES");
        MessageFormat mf = new MessageFormat(
                "(DEFAULT," +
                        "#'{'list[{0}].guideSummaryTitle},#'{'list[{0}].guideName},#'{'list[{0}].domain}," +
                        "#'{'list[{0}].category},#'{'list[{0}].unitCategory},#'{'list[{0}].fillUnit}," +
                        "#'{'list[{0}].fillContacts},#'{'list[{0}].researchPeriod},#'{'list[{0}].reasonBasis}," +
                        "#'{'list[{0}].researchContentTechnology},#'{'list[{0}].expectedTargetOutcome},#'{'list[{0}].standardsSpecificationsRegulatory}," +
                        "#'{'list[{0}].researchFund},#'{'list[{0}].demonstrationScale},#'{'list[{0}].demonstrationPoint}," +
                        "#'{'list[{0}].provinceDomainMechanism},#'{'list[{0}].contactPhone},#'{'list[{0}].projectTime}," +
                        "#'{'list[{0}].note},#'{'list[{0}].checkBackResult},#'{'list[{0}].checkBackNote}," +
                        "#'{'list[{0}].ownershipCategory},DEFAULT)"
        );

        for (int i = 0; i < summaryList.size(); i++) {
            sb.append(mf.format(new Object[]{0}));
            if (i < summaryList.size() - 1) {
                sb.append(",");
            }

        }
        return sb.toString();
    }
}
