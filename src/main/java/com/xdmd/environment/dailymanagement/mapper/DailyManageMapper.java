package com.xdmd.environment.dailymanagement.mapper;

import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import org.apache.ibatis.annotations.Insert;

/**
 * @author: Kong
 * @createDate: 2019/08/13
 * @description: 中期检查模板
 */
public interface DailyManageMapper {
    /**
     * [新增]
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
    int insert(MidCheckDTO midCheckDTO);
}
