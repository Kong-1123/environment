package com.xdmd.environment.contractmanage.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 课题承担单位、参加单位及主要研究开发人员（合同子表）
 */
@Data
@ApiModel("课题承担单位、参加单位及主要研究开发人员")
public class SubjectKeyResearchDevelopersDTO {

    @ApiModelProperty("合同管理主表id")
    private Integer id;

    @ApiModelProperty("课题承担单位")
    private String bearingUnits;

    @ApiModelProperty("课题参加单位")
    private String participatingUnits;

    @ApiModelProperty("境外合作单位")
    private String overseasCooperationUnits;

    @ApiModelProperty("国家或地区")
    private String country;

    @ApiModelProperty("课题负责人姓名")
    private String leaderName;

    @ApiModelProperty("所在单位")
    private String unitName;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("职称")
    private String professionalTitle;

    @ApiModelProperty("从事专业")
    private String professional;

    @ApiModelProperty("本课题中承担工作")
    private String workTask;

    @ApiModelProperty("为本课题工作时间（%）")
    private String workingTime;

    @ApiModelProperty("主要研究开发人员（手工填写）")
    private String keyResearchDevelopers;

    @ApiModelProperty("是否为课题负责人")
    private String isLeader;

    @ApiModelProperty("合同id")
    private Integer contractId;

    public SubjectKeyResearchDevelopersDTO() {
    }
}
