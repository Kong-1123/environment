package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 重大事项变更（申请）
 * @author Kong 2019-07-15
 */
@Data
@ApiModel("major_issues_manage")
public class MajorIssuesManage {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("承担单位")
    private String commitmentUnit;

    @ApiModelProperty("调整类型")
    private String adjustType;

    @ApiModelProperty("调整事项")
    private String adjustments;

    @ApiModelProperty("具体情况说明")
    private String details;

    @ApiModelProperty("单位负责人")
    private String unitHead;

    @ApiModelProperty("单位负责人电话")
    private String unitHeadPhone;

    @ApiModelProperty("变更申请表附件")
    private String changeApplicationAttachment;

    @ApiModelProperty("备案申请表附件")
    private String filingApplicationAttachment;

    @ApiModelProperty("专家论证意见附件")
    private String expertArgumentationAttachment;

    @ApiModelProperty("批准文件附件")
    private String approvalDocumentsAttachment;

    public MajorIssuesManage() {
    }

}
