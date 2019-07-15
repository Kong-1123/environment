package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 中期检查-part-1
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("mid_check_one")
public class MidCheckOne {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题编号")
    private String subjectNo;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("课题开始时间")
    private String subjectStartTime;

    @ApiModelProperty("课题结束时间")
    private String subjectEndTime;

    @ApiModelProperty("承担单位")
    private String commitmentUnit;

    @ApiModelProperty("课题联系人")
    private String topicContact;

    @ApiModelProperty("课题联系人电话")
    private String subjectContactPhone;

    @ApiModelProperty("课题负责人")
    private String subjectLeader;

    @ApiModelProperty("课题负责人电话")
    private String leaderPhone;

    @ApiModelProperty("课题按合同计划进度执行情况")
    private Integer contractPlanProgressExecution;

    @ApiModelProperty("课题未按时完成原因，分为：1.技术变化；2.经费未落实；3.项目负责人或技术骨干变动；4协作关系影响；5.其他原因（复选框）")
    private Integer notCompletingReason;

    public MidCheckOne() {
    }

}
