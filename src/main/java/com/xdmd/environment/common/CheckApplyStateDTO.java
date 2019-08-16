package com.xdmd.environment.common;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author: Kong
 * @createDate: 2019/08/16
 * @description: 审核实体
 */
public class CheckApplyStateDTO {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("对应验收申请表的id")
    private Integer checkApplyId;

    @ApiModelProperty("交办人")
    private String fistHandler;

    @ApiModelProperty("处理人")
    private String secondHandler;

    @ApiModelProperty("审核步骤")
    private String auditStep;

    @ApiModelProperty("交办时间")
    private Date firstHandleTime;

    @ApiModelProperty("状态")
    private String state;

    @ApiModelProperty("处理内容")
    private String handleContent;

    @ApiModelProperty("处理时间")
    private Date secondHandleTime;

    public CheckApplyStateDTO() {
    }

}
