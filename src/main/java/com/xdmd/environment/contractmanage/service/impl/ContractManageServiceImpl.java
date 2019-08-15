package com.xdmd.environment.contractmanage.service.impl;

import com.xdmd.environment.contractmanage.mapper.ContractManageMapper;
import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import com.xdmd.environment.contractmanage.service.ContractManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理业务层实现
 */
@Service
public class ContractManageServiceImpl implements ContractManageService {
    @Autowired
    private ContractManageMapper contractManageMapper;

    @Override
    public ContractManageDTO getNewData() {
        return contractManageMapper.getNewData();
    }

    /**
     * 新增
     * @param contractManageDTO
     * @return
     */
    @Override
    public int insert(ContractManageDTO contractManageDTO) {
        return contractManageMapper.insert(contractManageDTO);
    }

    /**
     * 根据合同主表id查询
     * @param id
     * @return
     */
    @Override
    public ContractManageDTO getManageInfoById(int id) {
        return contractManageMapper.getManageInfoById(id);
    }

    /**
     * 全查
     * @return
     */
    @Override
    public List<ContractManageDTO> getAllInfo() {
        return contractManageMapper.getAllInfo();
    }

    /**
     * 根据勾选的合同主表id修改相应的中期检查记录【内网中检】
     * @param ids
     * @return
     */
    @Override
    public int updateContractByIds(int mid,List<Long> ids) {
        return contractManageMapper.updateContractByIds(mid,ids);
    }

    /**
     * [查詢] 根据中期检查记录查詢相应合同主表
     * @return
     */
    @Override
    public List<Map> getInfoByMidRecord(int mId) {
        return contractManageMapper.getInfoByMidRecord(mId);
    }

    /**
     * [查詢] 根据单位id和中检记录id 查詢本单位的课题合同
     * @param Uid
     * @param Mid
     * @return
     */
    @Override
    public List<Map> getContractByUid(int Uid,int Mid) {
        return contractManageMapper.getContractByUid(Uid,Mid);
    }

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
    @Override
    public int updateContractByCid(int midCheckAnnexId,int expertAssessmentAnnexId,
                                   int openReportAnnexId,int subjectProgressAnnexId,int fundProgressAnnexId,
                                   int expertSuggestAnnexId,int cid) {
        int num= contractManageMapper.updateContractByCid(cid, midCheckAnnexId, expertAssessmentAnnexId, openReportAnnexId, subjectProgressAnnexId, fundProgressAnnexId, expertSuggestAnnexId);
        System.out.println("影响行数"+num);
        return num;
    }
}
