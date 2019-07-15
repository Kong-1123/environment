package com.xdmd.environment.contractmanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 合同研发任务
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("contract_research_development_tasks")
public class ContractDevTask {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("要求研发任务编号")
    private String requireStoddTaskNo;

    @ApiModelProperty("要求研发任务内容")
    private String requireStoddTaskContent;

    public ContractDevTask() {
    }

}
