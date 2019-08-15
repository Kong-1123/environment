package com.xdmd.environment.contractmanage.service;

import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理业务层
 */
public interface ContractManageService {


    /**
     * 获取最新的id用于保持最新课题编号
     * @return
     */
    ContractManageDTO getNewData();

    /**
     * [新增合同主表]
     * @param contractManageDTO
     * @return
     */
    int insert(ContractManageDTO contractManageDTO);

    /**
     * [查詢合同主表] 根据合同主表id查询
     * @param id
     * @return
     */
    ContractManageDTO getManageInfoById(int id);

    /**
     * [查詢合同主表] 查詢主表全部
     * @return
     */
    List<ContractManageDTO> getAllInfo();

    /**
     * 根据勾选的合同主表id修改相应的中期检查记录【内网中检】
     * @param ids
     * @return
     */
    int updateContractByIds(int mid,List<Long> ids);

    /**
     * [查詢] 根据中期检查记录id查詢相应合同主表
     * @return
     */
    List<Map> getInfoByMidRecord(@Param("mId")int mId);

    /**
     * [查詢] 根据单位id & 中检记录id查詢本单位的课题合同
     * @param Uid
     * @return
     */
    List<Map> getContractByUid(@Param("Uid") int Uid, @Param("Mid")int Mid);

    /**
     * 根据合同id更新相应的附件id
     * @param cid
     * @param midCheckAnnexId
     * @param expertAssessmentAnnexId
     * @param openReportAnnexId
     * @param subjectProgressAnnexId
     * @param fundProgressAnnexId
     * @param expertSuggestAnnexId
     * @return
     */
    int updateContractByCid(int midCheckAnnexId,int expertAssessmentAnnexId,
                            int openReportAnnexId,int subjectProgressAnnexId,int fundProgressAnnexId,
                            int expertSuggestAnnexId,int cid);
}
