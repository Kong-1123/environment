package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/19
 * @description: 重大调整事项
 */
@Data
@ApiModel(description = "adjustment_matters")
public class AdjustmentMattersDTO {

    @ApiModelProperty("调整事项主键id")
    private Integer id;

    @ApiModelProperty("调整事项")
    private String adjustmentMatters;

    @ApiModelProperty("调整原因id")
    private Integer adjustTypeId;

    public AdjustmentMattersDTO() {
    }

}
