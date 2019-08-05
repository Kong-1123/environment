package com.xdmd.environment.contractmanage.controller;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.contractmanage.pojo.ContractManageDTO;
import com.xdmd.environment.contractmanage.service.ContractManageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 合同管理接口层
 */
@Controller
@RequestMapping(value = "environment/contract")
public class ContractManageController {
    @Autowired
    private ContractManageService contractManageService;
    ResultMap resultMap=new ResultMap();

    /**
     * 测试url：
     * http://localhost:8086/environment/contract/addContractInfo?subjectCategory=kong&projectNo=lmp520&subjectName=fghttj76j&contractStartTime=gnyru76&contractEndTime=hgnyyujr7j&subjeceLeader=ntyjrj67&subjectLeaderPhone=gytjt&subjectContact=rjghytt&subjectContactPhone=ughtr7u6y&commitmentUnit=yj67u6&commitmentUnitAddress=yh6ut&commitmentUnitZip=ty5u&subjectSupervisorDepartment=tu5u&openBank=thy5u5&openBankAccount=uujuyh&guaranteedUnits=uyh57u&guaranteedUnitContact=5ujutyu&guaranteedContactPhone=jtjytk76&commissioningUnit=ty5uj7&legalRepresentativeEntrustingA=ty7i6i7&commissionedUnitAddressA=jtr7u6u7tu&commissionedUnitZipA=56u6utu&responsibilityUnitB=6tuutuy&responsibilityLegalRepresentativeB=6u5u&commitUnitAddressB=tu6uu&commitUnitZipB=tyj7u674&commitUnitLeaderB=tu67u64&commitunitLeadersPhoneB=u67u75&commitmentUnitEmailB=ttru64u&guaranteedUnitC=yt7ru6&guaranteedUnitLeaderC=y5u544&guaranteedUnitAddressC=6u7u64&guaranteedUnitZipC=6u5u4&subjectSigningDescription=tru56&subjectObjectivesResearch=ty6r7i4&subjectAcceptanceAssessment=y677i6&subjectProgressMetrics=yjr67676&undertakeParticipateResearchers=yt6u54i&budgetSourceFunding=56&subjectTotalExpenditure=20&contractAnnexAddress=ytu56u65u&otherTerms=u65u8
     * @param contractManageDTO
     * @return
     */
    @ApiOperation(value = "新增合同信息")
    @ResponseBody
    @PostMapping(value = "addContractInfo")
    public ResultMap insertContractInfo(ContractManageDTO contractManageDTO) {
        return contractManageService.insert(contractManageDTO)>0?resultMap.success().message("新增成功"):resultMap.fail().message("新增失败");
    }

    @ApiOperation(value = "根据id查询")
    @ResponseBody
    @GetMapping (value = "getInfoById")
    public ResultMap getContractInfoInfoById(int id) {
        return contractManageService.getInfoById(id)!=null?resultMap.success().message(contractManageService.getInfoById(id)):resultMap.fail().message("查询失败");
    }
    @ApiOperation(value = "查询全部合同")
    @ResponseBody
    @GetMapping (value = "getAllInfo")
    public List<ContractManageDTO> getAllInfo() {
        return contractManageService.getAllInfo();
    }

}
