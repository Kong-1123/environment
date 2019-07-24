package com.xdmd.environment.guidemanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/07/24
 * @description: 领域类
 */
@Data
@ApiModel("所属领域")
public class Domain {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("所属领域")
    private String domain;

    public Domain() {
    }

}
