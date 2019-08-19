package com.xdmd.environment.dailymanagement.mapper;

import com.xdmd.environment.dailymanagement.pojo.AdjustTypeDTO;
import com.xdmd.environment.dailymanagement.pojo.AdjustmentMattersDTO;
import com.xdmd.environment.dailymanagement.pojo.MajorMattersFilingDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 重大事项管理
 */
@Repository
public interface MajorMattersFilingMapper {
    /**
     * [新增]重大事项变更
     * @author Kong
     * @date 2019/08/19
     **/
    @Insert("INSERT INTO major_matters_filing (\n" +
            "subject_name,\n" +
            "commitment_unit,\n" +
            "unit_head,\n" +
            "unit_head_phone,\n" +
            "adjust_type,\n" +
            "adjustment_matters,\n" +
            "specific_facts,\n" +
            ")\t" +
            "VALUES(\n" +
            "#{subjectName},\n" +
            "#{commitmentUnit},\n" +
            "#{unitHead},\n" +
            "#{unitHeadPhone},\n" +
            "#{adjustType},\n" +
            "#{adjustmentMatters},\n" +
            "#{specificFacts})")
    int insert(@Param("majorMattersFiling") MajorMattersFilingDTO majorMattersFiling);
    /**
     * [更新]重大事项附件id
     * @author Kong
     * @date 2019/08/19
     **/
    @Update("UPDATE major_matters_filing\t" +
            "SET change_application_attachment_id = #{changeApplicationAttachmentId},\n" +
            "expert_argumentation_attachment_id = #{expertArgumentationAttachmentId},\n" +
            "filing_application_attachment_id = #{filingApplicationAttachmentId} \n" +
            "approval_documents_attachment_id = #{approvalDocumentsAttachmentId} \n" +
            "WHERE id=#{id}")
    int updateAnnexId(int changeApplicationAttachmentId,int expertArgumentationAttachmentId,int filingApplicationAttachmentId,int approvalDocumentsAttachmentId,int id);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/08/19
     **/
    @Select("SELECT * FROM major_matters_filing WHERE id= #{id}")
    MajorMattersFilingDTO getMajorById(@Param("id") int id);

    /**
     * [查詢] 根據单位id查詢【暂不做】
     * @author Kong
     * @date 2019/08/19
     **/
    MajorMattersFilingDTO getMajorByUid(@Param("uid") int uid);

    /**
     * [查詢] 分頁筛选查詢【内网】
     * @author Kong
     * @date 2019/08/19
     **/
    @Select("<SCRIPT>" +
            "SELECT\n" +
            "mmf.subject_name,\n" +
            "mmf.commitment_unit,\n" +
            "adt.adjust_type,\n" +
            "am.adjustment_matters,\n" +
            "mmf.unit_head,\n" +
            "mmf.unit_head_phone\n" +
            "FROM \n" +
            "major_matters_filing mmf,adjust_type adt,adjustment_matters am\n" +
            "WHERE\n" +
            "mmf.adjust_type_id=adt.id and mmf.adjustment_matters_id=am.id\n" +
            "<if test ='null != subjectName'>\n" +
            "AND mmf.subject_name like CONCAT('%',#{subjectName},'%')\n" +
            "</if>\n" +
            "<if test ='null != commitmentUnit'>\n" +
            "AND mmf.commitment_unit like CONCAT('%',#{commitmentUnit},'%')\n" +
            "</if>\n" +
            "<if test ='null != adjustTypId'>\n" +
            "AND mmf.adjust_type_id =#{adjustTypId}\n" +
            "</if>\n" +
            "<if test ='null != adjustmentMattersId'>\n" +
            "AND mmf.adjustment_matters_id like CONCAT('%',#{adjustmentMattersId},'%')\n" +
            "</if>\n" +
            "LIMIT #{offset}, #{pageSize}" +
            "</script>")
    List<Map> pageList(String subjectName, String commitmentUnit, int adjustTypId, int adjustmentMattersId, int offset, int pagesize);

    /**
     * [查詢] 分頁查詢 count【内网】
     * @author Kong
     * @date 2019/08/19
     **/
    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize);

    /**
     * 查询所有调整类型
     * @return
     */
    List<AdjustTypeDTO>  getAllAdjustType();

    /**
     * 查询所有调整类型
     * @return
     */
    List<AdjustmentMattersDTO>  getAllAdjustmentMatters();
}
