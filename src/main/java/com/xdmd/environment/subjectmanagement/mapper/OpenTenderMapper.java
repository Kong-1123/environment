package com.xdmd.environment.subjectmanagement.mapper;

import com.xdmd.environment.subjectmanagement.pojo.OpenTender;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/07/26
 * @description:
 */
@Repository
public interface OpenTenderMapper {
    /**
     *
     * @param openTender
     * @return
     */
    @Select(value = "INSERT INTO open_tender (\n" +
            "project_name,\n" +
            "tender_no,\n" +
            "subcontracting_no,\n" +
            "subject_name,\n" +
            "bidders,\n" +
            "subject_leader,\n" +
            "leader_contact,\n" +
            "join_tender_units,\n" +
            "operator,\n" +
            "operator_contact,\n" +
            "winning_amount,\n" +
            "supporting_funds,\n" +
            "audit_status,\n" +
            "project_no)\n" +
            "VALUES(\n" +
            "#{projectName},\n" +
            "#{tenderNo},\n" +
            "#{subcontractingNo},\n" +
            "#{subjectName}," +
            "#{bidders},\n" +
            "#{subjectLeader},\n" +
            "#{leaderContact},\n" +
            "#{joinTenderUnits},\n" +
            "#{operator},\n" +
            "#{operatorContact},\n" +
            "#{winningAmount},\n" +
            "#{supportingFunds},\n" +
            "#{auditStatus},\n" +
            "#{projectNo})")
    int insertTender(OpenTender openTender);

    /**
     * 获取最新的id
     * @return
     */
    @Select(value = "SELECT id,project_no FROM open_tender ORDER BY id DESC LIMIT 1")
    OpenTender getNewData();



    /**
     * [查詢] 根據id查詢相应单位的课题
     * @author Kong
     * @date 2019/07/26
     **/
    @Select(value = "SELECT\n" +
            "ot.*\n" +
            "FROM\n" +
            "open_tender ot,\n" +
            "unit_tender ut\n" +
            "WHERE\n" +
            "ot.id = ut.tender_id\n" +
            "AND ut.unit_id =#{id}")
    List<OpenTender> getTenderById(int id);


    /**
     * [查詢] 分頁查詢
     * @author Kong
     * @date 2019/07/26
     **/
    @Select(value = "<script>" +
            "SELECT * FROM `open_tender`\n" +
            "<where>\n" +
            "<if test ='null != projectName'>\n" +
            "project_name like CONCAT('%',#{projectName},'%')\n" +
            "</if>\n" +
            "<if test ='null != subjectName'>\n" +
            "AND subject_name like CONCAT('%',#{subjectName},'%')\n" +
            "</if>\n" +
            " <if test ='null != subjectLeader'>\n" +
            " AND subject_leader like CONCAT('%',#{subjectLeader},'%')\n" +
            " </if>\n" +
            "<if test ='null != leaderContact'>\n" +
            "AND leader_contact like CONCAT('%',#{leaderContact},'%')</if>\n" +
            "</where>" +
            "</script>")
    List<OpenTender> getTenderPageList(String projectName,String subjectName,String subjectLeader,String leaderContact);
}

