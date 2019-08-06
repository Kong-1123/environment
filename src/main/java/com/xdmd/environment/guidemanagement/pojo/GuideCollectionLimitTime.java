package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Administrator
 * @createDate: 2019/07/22
 * @description: 指南申报限制时间
 */
@Data
@ApiModel("指南申报限制时间")
public class GuideCollectionLimitTime{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("指南征集开始时间")
    private String guideCollectionStartTime;

    @ApiModelProperty("指南征集结束时间")
    private String guideCollectionEndTime;

    public GuideCollectionLimitTime() {
    }
}
