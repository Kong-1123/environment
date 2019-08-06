package com.xdmd.environment.contractmanage.mapper;

import com.xdmd.environment.contractmanage.pojo.SubjectFundsBudgetDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题经费预算数据层
 */
@Repository
public interface SubjectFundsBudgetMapper {
    /**
     * [新增]
     * @author Kong
     * @date 2019/08/06
     **/
    @Insert(value = "insert into subject_funds_budget\n" +
            "VALUES(\n" +
            "DEFAULT," +
            "#{budget},\n" +
            "#{currentYear},\n" +
            "#{nextYear},\n" +
            "#{afterYear},\n" +
            "#{note},\n" +
            "#{provincialCurrentBudget},\n" +
            "#{provincialNextBudget},\n" +
            "#{provincialAfterBudget},\n" +
            "#{provincialNoteBudget},\n" +
            "#{departmentCurrentBudget},\n" +
            "#{departmentNextBudget},\n" +
            "#{departmentAfterBudget},\n" +
            "#{departmentNoteBudget},\n" +
            "#{bearCurrentBudget},\n" +
            "#{bearNextBudget},\n" +
            "#{bearAfterBudget},\n" +
            "#{bearNoteBudget},\n" +
            "#{otherCurrentBudget},\n" +
            "#{otherNextBudget},\n" +
            "#{otherAfterBudget},\n" +
            "#{otherNoteBudget},\n" +
            "#{equipmentCurrentBudget},\n" +
            "#{equipmentNextBudget},\n" +
            "#{equipmentAfterBudget},\n" +
            "#{equipmentSupportingBudget},\n" +
            "#{equipmentNoteBudget},\n" +
            "#{materialCurrentBudget},\n" +
            "#{materialNextBudget},\n" +
            "#{materialAfterBudget},\n" +
            "#{materialSupportingBudget},\n" +
            "#{materialNoteBudget},\n" +
            "#{testCurrentBudget},\n" +
            "#{testNextBudget},\n" +
            "#{testAfterBudget},\n" +
            "#{testSupportingBudget},\n" +
            "#{testNoteBudget},\n" +
            "#{fuelCurrentBudget},\n" +
            "#{fuelNextBudget},\n" +
            "#{fuelAfterBudget},\n" +
            "#{fuelSupportingBudget},\n" +
            "#{fuelNoteBudget},\n" +
            "#{mettingCurrentBudget},\n" +
            "#{mettingNextBudget},\n" +
            "#{mettingAfterBudget},\n" +
            "#{mettingSupportingBudget},\n" +
            "#{mettingNoteBudget},\n" +
            "#{laborCurrentBudget},\n" +
            "#{laborNextBudget},\n" +
            "#{laborAfterBudget},\n" +
            "#{laborSupportingBudget},\n" +
            "#{laborNoteBudget},\n" +
            "#{expertsCurrentBudget},\n" +
            "#{expertsNextBudget},\n" +
            "#{expertsAfterBudget},\n" +
            "#{expertsSupportingBudget},\n" +
            "#{expertsNoteBudget},\n" +
            "#{dailyCurrentBudget},\n" +
            "#{dailyNextBudget},\n" +
            "#{dailyAfterBudget},\n" +
            "#{dailySupportingBudget},\n" +
            "#{dailyNoteBudget})\n")
    int insert(SubjectFundsBudgetDTO subjectFundsBudgetDTO);
    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/08/06
     **/
    @Select(value = "select * from subject_funds_budget where id=#{id}")
    SubjectFundsBudgetDTO getInfoById(@Param("id") int id);

    /**
     * [查詢] 获取全部预算信息
     * @return
     */
    @Select(value = "select * from subject_funds_budget")
    List<SubjectFundsBudgetDTO> getAllInfo();
}
