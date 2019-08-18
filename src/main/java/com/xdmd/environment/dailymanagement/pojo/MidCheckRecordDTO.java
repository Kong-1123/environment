package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description: 中期检查记录(备用)
 */
@Data
@ApiModel("mid_check_record")
public class MidCheckRecordDTO {

    @ApiModelProperty("中期检查记录id")
    private Integer id;

    @ApiModelProperty("中期检查名称")
    private String midCheckName;

    @ApiModelProperty("中期检查发起时间")
    private String midCheckInitiateTime;

    @ApiModelProperty("中期检查状态（0--未完成 1--已完成）")
    private String midCheckState;

    public MidCheckRecordDTO() {
    }

}