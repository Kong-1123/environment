package com.xdmd.environment.dailymanagement.service;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;

public interface DailyManageService {
    /**
     * 新增中期检查表
     * @param midCheckDTO
     * @return
     */
    ResultMap insert(MidCheckDTO midCheckDTO);
}
