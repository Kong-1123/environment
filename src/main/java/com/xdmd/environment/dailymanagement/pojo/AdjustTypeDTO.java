package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/19
 * @description: 重大调整类型
 */
@Data
@ApiModel(description = "adjust_type")
public class AdjustTypeDTO {

    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("调整类型")
    private String adjustType;

    public AdjustTypeDTO() {
    }

}
