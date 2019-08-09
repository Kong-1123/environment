package com.xdmd.environment.contractmanage.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 计划内容及考核（合同子表一）
 */
@Data
@ApiModel(description = "计划内容及考核【合同子表一】")
public class ContentIndicatorsDTO {
    @ApiModelProperty("合同管理子表【注:id为默认,新增时不用填】")
    private Integer id;

    @ApiModelProperty("日期")
    private String time;

    @ApiModelProperty("计划内容及考核指标")
    private String programContentAssessmentIndicators;


    public ContentIndicatorsDTO() {
    }
}