package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Administrator
 * @createDate: 2019/07/22
 * @description: 指南申报限制时间
 */
@Data
@ApiModel("指南申报限制时间")
public class GuideCollectionLimitTime implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("指南征集开始时间")
    private Date guideCollectionStartTime;

    @ApiModelProperty("指南征集结束时间")
    private Date guideCollectionEndTime;

    public GuideCollectionLimitTime() {
    }
}
