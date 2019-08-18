package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 下一步工作计划【课题进展第五部分】
 */
@Data
@ApiModel("next_work_plan")
public class NextWorkPlanDTO {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题进展id")
    private Integer progressId;

    @ApiModelProperty("下一步工作计划")
    private String nextWorkPlan;

    public NextWorkPlanDTO() {
    }

}
