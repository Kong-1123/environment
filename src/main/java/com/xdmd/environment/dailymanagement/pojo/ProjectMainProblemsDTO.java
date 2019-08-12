package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 课题实施中存在的主要问题【课题进展第三部分】
 */
@Data
@ApiModel("project_main_problems")
public class ProjectMainProblemsDTO {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题进展id")
    private Integer progressId;

    @ApiModelProperty("课题实施中存在的主要问题（研究遇到的困难及技术、方案、人员等变动情况)")
    private String mainProblems;

    public ProjectMainProblemsDTO() {
    }

}
