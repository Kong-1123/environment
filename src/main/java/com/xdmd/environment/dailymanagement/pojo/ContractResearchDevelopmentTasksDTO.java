package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/12
 * @description: 合同要求研发任务【课题进展第一部分】
 */
@Data
@ApiModel(description = "合同要求研发任务【课题进展第一部分】")
public class ContractResearchDevelopmentTasksDTO {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题进展id")
    private Integer progressId;

    @ApiModelProperty("要求研发任务内容")
    private String requireStoddTaskContent;

    public ContractResearchDevelopmentTasksDTO() {
    }
}