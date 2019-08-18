package com.xdmd.environment.contractmanage.service;


import com.xdmd.environment.contractmanage.pojo.ContentIndicatorsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentIndicatorsService {
    /**
     * [新增]
     * @author Kong
     * @date 2019/08/06
     **/
    int insert(ContentIndicatorsDTO contentIndicatorsDTO);

    /**
     * [查詢] 根據合同管理id查詢
     * @author Kong
     * @date 2019/08/06
     **/
    ContentIndicatorsDTO getIndicatorById(@Param("id") int id);

    /**
     * [查詢] 查詢全部计划内容
     * @param
     * @return
     */
    List<ContentIndicatorsDTO> getAllInfo();
}
