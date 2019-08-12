package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 目前进展情况【课题进展第二部分】
 */
@Data
@ApiModel("目前进展情况【课题进展第二部分】")
public class CurrentProgressDTO {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题进展id")
    private Integer progressId;

    @ApiModelProperty("目前进展情况内容")
    private String currentProgressContent;

    public CurrentProgressDTO() {
    }

}
