package com.xdmd.environment.dailymanagement.mapper;

import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author: Kong
 * @createDate: 2019/08/13
 * @description: 中期检查模板
 */
@Repository
public interface MidCheckMapper {
    /**
     * [新增] 中期检查表
     * @author Kong
     * @date 2019/08/13
     **/
    @Insert(value = "insert into mid_check VALUES(" +
            "DEFAULT,\n" +
            "#{subjectNo},\n" +
            "#{subjectName},\n" +
            "#{subjectStartTime},\n" +
            "#{subjectEndTime},\n" +
            "#{commitmentUnit},\n" +
            "#{topicContact},\n" +
            "#{subjectContactPhone},\n" +
            "#{subjectLeader},\n" +
            "#{leaderPhone},\n" +
            "#{contractPlanCrogressExecution},\n" +
            "#{notCompletingReason},\n" +
            "#{totalBudget},\n" +
            "#{provincialSubjectBudget},\n" +
            "#{unitFinancingBudget},\n" +
            "#{otherBudgets},\n" +
            "#{totalExpenditure},\n" +
            "#{provincialSubjectExpenditureBudget},\n" +
            "#{unitInancingExpenditureBudget},\n" +
            "#{otherExpenditureBudget},\n" +
            "#{equipmentUsage},\n" +
            "#{materialUsage},\n" +
            "#{testIngyUse},\n" +
            "#{processingFeeUsage},\n" +
            "#{fuelUsage},\n" +
            "#{travelExpenses},\n" +
            "#{meetingFeeUsage},\n" +
            "#{expertConsultationFeesUsage},\n" +
            "#{publicationDocumentationNewsIntellectualproperty},\n" +
            "#{labourCostsUsage},\n" +
            "#{otherExpenseUsage},\n" +
            "#{indirectCostsUsage},\n" +
            "#{externalCooperationFees},\n" +
            "#{newSales},\n" +
            "#{newProfit},\n" +
            "#{newTax},\n" +
            "#{foreignExchange},\n" +
            "#{newProducts},\n" +
            "#{newEquipment},\n" +
            "#{newMaterials},\n" +
            "#{newProcess},\n" +
            "#{newVarieties},\n" +
            "#{inventionPatents},\n" +
            "#{utilityModel},\n" +
            "#{design},\n" +
            "#{foreignPatents},\n" +
            "#{totalNumberPapers},\n" +
            "#{coreJournals},\n" +
            "#{sciIndex},\n" +
            "#{eiIndex},\n" +
            "#{publicationMonograph},\n" +
            "#{research},\n" +
            "#{report},\n" +
            "#{developTechnicalStandards},\n" +
            "#{releaseDocuments},\n" +
            "#{seniorTalent},\n" +
            "#{nationalOutstandingYoungPeople},\n" +
            "#{graduateStudentsNumber},\n" +
            "#{participatingUnits},\n" +
            "#{actualProgressProject},\n" +
            "#{projectFundsUsage},\n" +
            "#{recommendationsProblemsSolutions},\n" +
            "#{bearContaacter},\n" +
            "#{bearContaactPhone},\n" +
            "#{midInspectionAnnex})")
    int insertMidCheck(MidCheckDTO midCheckDTO);

    /**
     * [新增] 中期检察记录
     * @author Kong
     * @date 2019/08/14
     **/
    @Insert(value = "INSERT INTO mid_check_record\n" +
            "VALUES(" +
            "DEFAULT,\n" +
            "#{midCheckName},\n" +
            "#{midCheckInitiateTime},\n" +
            "DEFAULT)")
    int insertMidCheckRecord(MidCheckRecordDTO midCheckRecordDTO);


    /**
     * [更新] 中期检察记录状态
     * @author Kong
     * @date 2019/08/14
     **/
    @Update(value = "UPDATE mid_check_record set mid_check_state=1 where mid_check_state=0")
    int updateMidCheck();

}
