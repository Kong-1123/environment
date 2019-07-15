package com.xdmd.environment.contractmanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 计划内容及考核指标
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("content_indicators")
public class ContentIndicators {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("合同表id")
    private Integer contractId;

    @ApiModelProperty("日期")
    private String time;

    @ApiModelProperty("计划内容及考核指标")
    private String programContentAssessmentIndicators;

    public ContentIndicators() {
    }

}
