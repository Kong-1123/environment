package com.xdmd.environment.subjectAcceptance.pojo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

//验收证书主表

@Getter     //生成getter方法
@Setter     //生成setter方法
public class AcceptanceCertificate {
    //主键id
    private Integer id;

    //文号
    @NonNull
    private String translate;

    //课题编号
    @NonNull
    private String topicNumber;

    //课题名称
    @NonNull
    private String topicName;

    //完成单位
    @NonNull
    private String completionUnit;

    //验收组织部门
    @NonNull
    private String acceptanceDepartment;

    //验收日期
    @NonNull
    private Date acceptanceTime;

    //单位名称
    @NonNull
    private String unitName;

    //单位性质
    @NonNull
    private Integer unitNature;

    //所在地区
    @NonNull
    private String location;

    //法定代表人
    @NonNull
    private String legalRepresentative;

    //法定代表人电话
    @NonNull
    private String legalRepresentativePhone;

    //联系人
    @NonNull
    private String contacts;

    //联系人电话
    @NonNull
    private String contactsPhone;

    //邮政编码
    @NonNull
    private String postalCode;

    //电子邮箱
    @NonNull
    private String mail;

    //通信地址
    @NonNull
    private String mailingAddress;

    //主管部门
    @NonNull
    private String competentDepartment;

    //课题起始时间
    @NonNull
    private String projectStartTime;

    //课题完成时间
    @NonNull
    private String projectCompletionTime;

    //成果形式
    @NonNull
    private String achievementForm;

    //成果水平
    @NonNull
    private Integer achievementLevel;

    //课题研发人员总数
    @NonNull
    private String developmentTotalNumber;

    //课题研发博士人员数量
    @NonNull
    private String doctorTotalNumber;

    //课题研发硕士数量
    @NonNull
    private String masterTotalNumber;

    //课题研发高级职称数量
    @NonNull
    private String seniorTotalNumber;

    //课题研发中级职称数量
    @NonNull
    private String intermediateTotalNumber;

    //课题研发在校研究生数量
    @NonNull
    private String schoolMasterNumber;

    //课题实际到位经费项目总经费
    @NonNull
    private BigDecimal totalProjectFunds;

    //课题实际到位经费省环保科研课题经费
    @NonNull
    private BigDecimal environmentTopicFunds;

    //课题实际到位经费主管部门配套
    @NonNull
    private BigDecimal competentDepartmentMatch;

    //课题实际到位经费银行贷款
    @NonNull
    private BigDecimal bankLoans;

    //课题实际到位经费单位自筹
    @NonNull
    private BigDecimal unitRaiseMoney;

    //课题实际到位经费其他
    @NonNull
    private BigDecimal otherActualMoney;

    //课题经费支出设备费
    @NonNull
    private BigDecimal equipmentCost;

    //课题经费支出材料费
    @NonNull
    private BigDecimal materialFee;

    //课题经费支出测试化验加工费
    @NonNull
    private BigDecimal laboratoryFees;

    //课题经费支出燃料动力费
    @NonNull
    private BigDecimal fuelCosts;

    //课题经费支出差旅费
    @NonNull
    private BigDecimal travelExpenses;

    //课题经费支出会议费
    @NonNull
    private BigDecimal conferenceFee;

    //课题经费支出国际合作交流会
    @NonNull
    private BigDecimal internationalCommunication;

    //课题经费支出专家咨询费
    @NonNull
    private BigDecimal expertConsult;

    //课题经费支出管理及人员费
    @NonNull
    private BigDecimal managementExpense;

    //课题经费支出其他费用
    @NonNull
    private BigDecimal otherExpenditureMoney;

    //新增产值
    @NonNull
    private BigDecimal newOutput;

    //新增销售额
    @NonNull
    private BigDecimal newSalesVolume;

    //新增利税
    @NonNull
    private BigDecimal newProfitTax;

    //出口创汇
    @NonNull
    private BigDecimal exitEarn;

    //主要解决的关键技术与创新点
    @NonNull
    private String mainSolveTechnology;

    //主要技术
    @NonNull
    private String mainCompletion;

    //课题实施的绩效
    @NonNull
    private String implementationAchievement;

    //完成单位科技部门意见
    @NonNull
    private String scienceDepartmentOpinion;

    //组织验收部门意见
    @NonNull
    private String checkDepartmentOpinion;

    //省生态环境厅意见
    @NonNull
    private String environmentOfficeOpinion;

    //验收证书url
    @NonNull
    private String acceptanceCertificateUrl;

    public AcceptanceCertificate(Integer id, String translate, String topicNumber, String topicName, String completionUnit, String acceptanceDepartment, Date acceptanceTime, String unitName, Integer unitNature, String location, String legalRepresentative, String legalRepresentativePhone, String contacts, String contactsPhone, String postalCode, String mail, String mailingAddress, String competentDepartment, String projectStartTime, String projectCompletionTime, String achievementForm, Integer achievementLevel, String developmentTotalNumber, String doctorTotalNumber, String masterTotalNumber, String seniorTotalNumber, String intermediateTotalNumber, String schoolMasterNumber, BigDecimal totalProjectFunds, BigDecimal environmentTopicFunds, BigDecimal competentDepartmentMatch, BigDecimal bankLoans, BigDecimal unitRaiseMoney, BigDecimal otherActualMoney, BigDecimal equipmentCost, BigDecimal materialFee, BigDecimal laboratoryFees, BigDecimal fuelCosts, BigDecimal travelExpenses, BigDecimal conferenceFee, BigDecimal internationalCommunication, BigDecimal expertConsult, BigDecimal managementExpense, BigDecimal otherExpenditureMoney, BigDecimal newOutput, BigDecimal newSalesVolume, BigDecimal newProfitTax, BigDecimal exitEarn, String mainSolveTechnology, String mainCompletion, String implementationAchievement, String scienceDepartmentOpinion, String checkDepartmentOpinion, String environmentOfficeOpinion, String acceptanceCertificateUrl) {
        this.id = id;
        this.translate = translate;
        this.topicNumber = topicNumber;
        this.topicName = topicName;
        this.completionUnit = completionUnit;
        this.acceptanceDepartment = acceptanceDepartment;
        this.acceptanceTime = acceptanceTime;
        this.unitName = unitName;
        this.unitNature = unitNature;
        this.location = location;
        this.legalRepresentative = legalRepresentative;
        this.legalRepresentativePhone = legalRepresentativePhone;
        this.contacts = contacts;
        this.contactsPhone = contactsPhone;
        this.postalCode = postalCode;
        this.mail = mail;
        this.mailingAddress = mailingAddress;
        this.competentDepartment = competentDepartment;
        this.projectStartTime = projectStartTime;
        this.projectCompletionTime = projectCompletionTime;
        this.achievementForm = achievementForm;
        this.achievementLevel = achievementLevel;
        this.developmentTotalNumber = developmentTotalNumber;
        this.doctorTotalNumber = doctorTotalNumber;
        this.masterTotalNumber = masterTotalNumber;
        this.seniorTotalNumber = seniorTotalNumber;
        this.intermediateTotalNumber = intermediateTotalNumber;
        this.schoolMasterNumber = schoolMasterNumber;
        this.totalProjectFunds = totalProjectFunds;
        this.environmentTopicFunds = environmentTopicFunds;
        this.competentDepartmentMatch = competentDepartmentMatch;
        this.bankLoans = bankLoans;
        this.unitRaiseMoney = unitRaiseMoney;
        this.otherActualMoney = otherActualMoney;
        this.equipmentCost = equipmentCost;
        this.materialFee = materialFee;
        this.laboratoryFees = laboratoryFees;
        this.fuelCosts = fuelCosts;
        this.travelExpenses = travelExpenses;
        this.conferenceFee = conferenceFee;
        this.internationalCommunication = internationalCommunication;
        this.expertConsult = expertConsult;
        this.managementExpense = managementExpense;
        this.otherExpenditureMoney = otherExpenditureMoney;
        this.newOutput = newOutput;
        this.newSalesVolume = newSalesVolume;
        this.newProfitTax = newProfitTax;
        this.exitEarn = exitEarn;
        this.mainSolveTechnology = mainSolveTechnology;
        this.mainCompletion = mainCompletion;
        this.implementationAchievement = implementationAchievement;
        this.scienceDepartmentOpinion = scienceDepartmentOpinion;
        this.checkDepartmentOpinion = checkDepartmentOpinion;
        this.environmentOfficeOpinion = environmentOfficeOpinion;
        this.acceptanceCertificateUrl = acceptanceCertificateUrl;
    }

    public AcceptanceCertificate() {
    }
}
