package com.xdmd.environment.dailymanagement.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/08/19
 * @description: 重大事项
 */
@Data
@ApiModel("major_matters_filing")
public class MajorMattersFilingDTO {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("课题名称")
    private String subjectName;

    @ApiModelProperty("承担单位")
    private String commitmentUnit;

    @ApiModelProperty("单位负责人")
    private String unitHead;

    @ApiModelProperty("单位负责人电话")
    private String unitHeadPhone;

    @ApiModelProperty("调整类型")
    private Integer adjustTypeId;

    @ApiModelProperty("调整事项")
    private Integer adjustmentMattersId;

    @ApiModelProperty("具体情况说明")
    private String specificFacts;

    @ApiModelProperty("变更申请表附件")
    private Integer changeApplicationAttachment;

    @ApiModelProperty("专家论证意见附件")
    private Integer expertArgumentationAttachment;

    @ApiModelProperty("备案申请表附件")
    private Integer filingApplicationAttachment;

    @ApiModelProperty("批准文件附件")
    private Integer approvalDocumentsAttachment;

    public MajorMattersFilingDTO() {
    }
}
