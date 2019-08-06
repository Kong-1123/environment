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
            "values(\n" +
            "DEFAULT,\n" +
            "#{bearingUnits},\n" +
            "#{participatingUnits},\n" +
            "#{overseasCooperationUnits},\n" +
            "#{country},\n" +
            "#{leaderName},\n" +
            "#{unitName},\n" +
            "#{gender},\n" +
            "#{age},\n" +
            "#{professionalTitle},\n" +
            "#{professional},\n" +
            "#{workTask},\n" +
            "#{workingTime},\n" +
            "#{keyResearchDevelopers},\n" +
            "#{isLeader})")
    int insert(SubjectKeyResearchDevelopersDTO subjectKeyResearchDevelopersDTO);


    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/08/06
     **/
    @Select(value = "select * from subject_key_research_developers where id=#{id}")
    SubjectKeyResearchDevelopersDTO getInfoById(@Param("id") int id);

    /**
     * [查詢] 全部查詢
     * @author Kong
     * @date 2019/08/06
     **/
    @Select(value = "select * from subject_key_research_developers")
    List<SubjectKeyResearchDevelopersDTO> getAllInfo();
}
