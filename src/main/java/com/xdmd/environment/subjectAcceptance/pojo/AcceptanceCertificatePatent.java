package com.xdmd.environment.subjectAcceptance.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//专家验收表 专利
public class AcceptanceCertificatePatent {
    //主键id
    private  Integer id;

    //验收证书Id
    private  Integer acceptanceCertificateId;

    //专利申请发明
    private  String applicationInvention;

    //专利申请使用新型
    private  String useNewType;

    //专利申请外观设计
    private  String patentAppearance;

    //专利授权发明
    private  String patentInvention;

    //专利授权实用新型
    private  String empowerNewType;

    //专利授权外观设计
    private  String empowerAppearanceDesign;

    //发表论文总数
    private  String paperNumber;

    //发表论文科学英文索引
    private  String scienceIndexe;

    //发表论文工程索引
    private  String engineerIndex;

    //出版科技著作
    private  String publishWork;

    //制定技术标准
    private  String technicalStandard;

    //新产品
    private  String newProduct;

    //制定政策制度
    private  String policySystem;

    //建成新装置
    private  String newDevice;

    //新工艺
    private  String newTechnology;

    public AcceptanceCertificatePatent(Integer id, Integer acceptanceCertificateId, String applicationInvention, String useNewType, String patentAppearance, String patentInvention, String empowerNewType, String empowerAppearanceDesign, String paperNumber, String scienceIndexe, String engineerIndex, String publishWork, String technicalStandard, String newProduct, String policySystem, String newDevice, String newTechnology) {
        this.id = id;
        this.acceptanceCertificateId = acceptanceCertificateId;
        this.applicationInvention = applicationInvention;
        this.useNewType = useNewType;
        this.patentAppearance = patentAppearance;
        this.patentInvention = patentInvention;
        this.empowerNewType = empowerNewType;
        this.empowerAppearanceDesign = empowerAppearanceDesign;
        this.paperNumber = paperNumber;
        this.scienceIndexe = scienceIndexe;
        this.engineerIndex = engineerIndex;
        this.publishWork = publishWork;
        this.technicalStandard = technicalStandard;
        this.newProduct = newProduct;
        this.policySystem = policySystem;
        this.newDevice = newDevice;
        this.newTechnology = newTechnology;
    }

    public AcceptanceCertificatePatent() {
    }
}
