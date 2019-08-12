package com.xdmd.environment.contractmanage.mapper;

import com.xdmd.environment.contractmanage.pojo.SubjectKeyResearchDevelopersDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/06
 * @description: 课题承担单位、参加单位及主要研究开发人员
 */
@Repository
public interface SubjectKeyResearchDevelopersMapper {
    /**
     * [新增]
     * @author Kong
     * @date 2019/08/06
     **/
    @Insert(value = "insert into subject_key_research_developers\n" +
            "values(" +
            "DEFAULT," +
            "#{contractId}," +
            "#{bearingUnits}," +
            "#{participatingUnits}," +
            "#{overseasCooperationUnits}," +
            "#{country}," +
            "#{leaderName}," +
            "#{unitName}," +
            "#{gender}," +
            "#{age}," +
            "#{professionalTitle}," +
            "#{professional}," +
            "#{workTask}," +
            "#{workingTime}," +
            "#{keyResearchDevelopers}," +
            "#{isLeader})")
    int insert(SubjectKeyResearchDevelopersDTO subjectKeyResearchDevelopersDTO);


    /**
     * [查詢] 根據合同管理id查詢
     * @author Kong
     * @date 2019/08/06
     **/
    @Select(value = "select ci.* from subject_key_research_developers skrd,contract_manage cm\n" +
            "where skrd.contract_id=cm.id and cm.id=#{id}")
    SubjectKeyResearchDevelopersDTO getDeveloperInfoById(@Param("id") int id);

    /**
     * [查詢] 全部查詢
     * @author Kong
     * @date 2019/08/06
     **/
    @Select(value = "select * from subject_key_research_developers")
    List<SubjectKeyResearchDevelopersDTO> getAllInfo();
}
