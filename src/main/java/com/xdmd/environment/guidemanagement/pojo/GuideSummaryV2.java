package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: Kong
 * @createDate: 2019/8/1
 * @description: 指南汇总实体类v2版
 */
@Data
@ApiModel("guide_summary_v2")
public class GuideSummaryV2 {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("指南汇总标题")
    private String guideSummaryTitle;

    @ApiModelProperty("填报类别（所属类别）")
    private String category;

    @ApiModelProperty("单位类别")
    private String unitCategory;

    @ApiModelProperty("建议立项时间")
    private String projectTime;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("查重结果")
    private String checkBackResult;

    @ApiModelProperty("查重备注")
    private String checkBackNote;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("指南申报id")
    private String guideCollectionId;

    public GuideSummaryV2() {
    }
}
