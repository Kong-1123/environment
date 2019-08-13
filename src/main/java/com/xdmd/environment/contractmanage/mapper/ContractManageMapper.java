package com.xdmd.environment.contractmanage.mapper;

import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理数据层
 */
@Repository
public interface ContractManageMapper {

    /**
     * 获取最新的id用于保持最新课题编号
     * @return
     */
    @Select(value = "SELECT id,project_no FROM contract_manage ORDER BY id DESC LIMIT 1")
    ContractManageDTO getNewData();

    /**
     * [新增]
     * @param contractManageDTO
     * @return
     */
    @Insert(value = "INSERT INTO contract_manage\n" +
            "VALUES(\n" +
            "DEFAULT,\n" +
            "#{subjectCategory},\n" +
            "#{projectNo},\n" +
            "#{subjectName},\n" +
            "#{contractStartTime},\n" +
            "#{contractEndTime},\n" +
            "#{subjeceLeader},\n" +
            "#{subjectLeaderPhone},\n" +
            "#{subjectContact},\n" +
            "#{subjectContactPhone},\n" +
            "#{commitmentUnit},\n" +
            "#{commitmentUnitAddress},\n" +
            "#{commitmentUnitZip},\n" +
            "#{subjectSupervisorDepartment},\n" +
            "#{openBank},\n" +
            "#{openBankAccount},\n" +
            "#{email},\n" +
            "#{guaranteedUnits},\n" +
            "#{guaranteedUnitContact},\n" +
            "#{guaranteedContactPhone},\n" +
            "#{commissioningUnit},\n" +
            "#{legalRepresentativeEntrustingA},\n" +
            "#{commissionedUnitAddressA},\n" +
            "#{commissionedUnitZipA},\n" +
            "#{responsibilityUnitB},\n" +
            "#{responsibilityLegalRepresentativeB},\n" +
            "#{commitUnitAddressB},\n" +
            "#{commitUnitZipB},\n" +
            "#{commitUnitLeaderB},\n" +
            "#{commitunitLeadersPhoneB},\n" +
            "#{commitmentUnitEmailB},\n" +
            "#{guaranteedUnitC},\n" +
            "#{guaranteedUnitLeaderC},\n" +
            "#{guaranteedUnitAddressC},\n" +
            "#{guaranteedUnitZipC},\n" +
            "#{subjectSigningDescription},\n" +
            "#{subjectObjectivesResearch},\n" +
            "#{subjectAcceptanceAssessment},\n" +
            "#{isMidCheck}" +
            "#{otherTerms})")
    int insert(ContractManageDTO contractManageDTO);

    /**
     * [查詢] 根據合同管理id查詢
     * @param id
     * @return
     */
    @Select(value = "select * from contract_manage where id=#{id}")
    ContractManageDTO getManageInfoById(@Param("id") int id);

    /**
     * [查詢] 查詢全部合同主表
     * @param
     * @return
     */
    @Select(value = "select * from contract_manage")
    List<ContractManageDTO> getAllInfo();

    /**
     * 根据勾选的合同主表id修改相应的中期检查状态(内网)--中期检查
     * @param ids
     * @return
     */
    @Update(value ="<script>" +
            "UPDATE contract_manage \n" +
            "SET is_mid_check = 1 \n" +
            "WHERE\n" +
            "\tid IN" +
            "<foreach\tcollection='list'\titem='cId'\topen='(' separator=',' close=')'>" +
            "#{cId}\n" +
            "</foreach>\n" +
            "</script>")
    @Results(value = {@Result(column = "id", property = "id")})
    int updateContractByIds(List<Long> ids);

    /**
     * [查詢] 根据中期检查状态查詢相应合同主表
     * @param
     * @return
     */
    @Select(value = "select id subject_name,contract_start_time,subject_objectives_research from contract_manage where is_mid_check=1")
    List<Map> getInfoByMidState();

    /**
     * [查詢] 根据单位id查詢本单位的课题合同
     * @param Uid
     * @return
     */
    @Select(value = "SELECT\n" +
            "cm.id,\n" +
            "uc.contract_id,\n" +
            "cm.subject_name,\n" +
            "cm.contract_start_time,\n" +
            "cm.subject_objectives_research \n" +
            "FROM\n" +
            "contract_manage cm,unit_contract uc\n" +
            "where cm.id=uc.contract_id and uc.unit_id=#{Uid} and cm.id in (select id from contract_manage where is_mid_check=1)")
    List<Map> getContractByUid(int Uid);
}
