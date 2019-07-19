package com.xdmd.environment.subjectAcceptance.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
//验收证书 主要参加人员
public class AcceptanceCertificatePrincipalPersonnel {
    //主键id
    private  Integer id;

    //验收证书id
    private  Integer acceptanceCertificateId;

    //主要参与人员姓名
    private  String participantName;

    //主要参与人员性别
    private  String participantSex;

    //主要参与人员出生年月
    private Date participantBirthDate;

    //主要参与人员技术职称
    private  String participantTechnicalTitle;

    //主要参与人员学历
    private  String participantEducation;

    //主要参与人员工作单位
    private  String participantWorkUnit;

    //主要参与人员承担的主要研究任务
    private  String taskTaking;

    public AcceptanceCertificatePrincipalPersonnel(Integer id, Integer acceptanceCertificateId, String participantName, String participantSex, Date participantBirthDate, String participantTechnicalTitle, String participantEducation, String participantWorkUnit, String taskTaking) {
        this.id = id;
        this.acceptanceCertificateId = acceptanceCertificateId;
        this.participantName = participantName;
        this.participantSex = participantSex;
        this.participantBirthDate = participantBirthDate;
        this.participantTechnicalTitle = participantTechnicalTitle;
        this.participantEducation = participantEducation;
        this.participantWorkUnit = participantWorkUnit;
        this.taskTaking = taskTaking;
    }

    public AcceptanceCertificatePrincipalPersonnel() {
    }
}
