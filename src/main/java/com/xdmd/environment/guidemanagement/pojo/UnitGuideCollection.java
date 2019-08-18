package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/18
 * @description: 单位关联指南
 */
@Data
@ApiModel("unit_guide_collection")
public class UnitGuideCollection {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("单位id")
    private Integer unitId;

    @ApiModelProperty("指南征集id")
    private Integer collectionId;

    public UnitGuideCollection() {
    }

}
