package com.xdmd.environment.guidemanagement.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  guide_summary
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("guide_summary")
public class GuideSummary implements Serializable {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("指南汇总标题")
    private String guideSummaryTitle;

    @ApiModelProperty("指南建议名称")
    private String guideName;

    @ApiModelProperty("所属领域")
    private String domain;

    @ApiModelProperty("填报类别（所属类别）")
    private String category;

    @ApiModelProperty("单位类别")
    private String unitCategory;

    @ApiModelProperty("填报单位")
    private String fillUnit;

    @ApiModelProperty("填报联系人")
    private String fillContacts;

    @ApiModelProperty("研究期限")
    private Integer researchPeriod;

    @ApiModelProperty("建议理由及依据")
    private String reasonBasis;

    @ApiModelProperty("主要研究内容和关键技术")
    private String researchContentTechnology;

    @ApiModelProperty("预期目标和成果")
    private String expectedTargetOutcome;

    @ApiModelProperty("拟出标准、技术规范、法规名称")
    private String standardsSpecificationsRegulatory;

    @ApiModelProperty("研究经费测算")
    private BigDecimal researchFund;

    @ApiModelProperty("示范工程规模")
    private String demonstrationScale;

    @ApiModelProperty("示范工程点")
    private String demonstrationPoint;

    @ApiModelProperty("省内从事该领域的主要研究机构")
    private String provinceDomainMechanism;

    @ApiModelProperty("联系电话(手机)")
    private String contactPhone;

    @DateTimeFormat(pattern="yyyy-MM-dd")//页面写入数据库时格式化
    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    @ApiModelProperty("建议立项时间")
    private Date projectTime;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("查重结果")
    private String checkBackResult;

    @ApiModelProperty("查重备注")
    private String checkBackNote;

    @ApiModelProperty("创建时间")
    private Date createTime;

    public GuideSummary() {
    }

}