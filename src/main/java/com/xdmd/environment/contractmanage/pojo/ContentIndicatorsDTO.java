package com.xdmd.environment.contractmanage.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 计划内容及考核（合同子表）
 */
@Data
@ApiModel("计划内容及考核（合同子表）")
public class ContentIndicatorsDTO {

    @ApiModelProperty("计划内容及考核指标id")
    private Integer id;

    @ApiModelProperty("合同表id")
    private Integer contractId;

    @ApiModelProperty("日期")
    private String time;

    @ApiModelProperty("计划内容及考核指标")
    private String programContentAssessmentIndicators;

    public ContentIndicatorsDTO() {
    }
}
