package com.xdmd.environment.dailymanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;

public interface MidCheckService {
    /**
     * 新增中期检查表
     * @param midCheckDTO
     * @return
     */
    ResultMap insertMidCheck(MidCheckDTO midCheckDTO);

    /**
     * [新增] 中期检察记录
     * @author Kong
     * @date 2019/08/14
     **/
    ResultMap insertMidCheckRecord(MidCheckRecordDTO midCheckRecordDTO);

    /**
     * [更新] 中期检察记录状态
     * @return
     */
    ResultMap updateMidCheck();
}
