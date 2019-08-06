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
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/08/06
     **/
    ContentIndicatorsDTO getInfoById(@Param("id") int id);

    /**
     * [查詢] 查詢全部计划内容
     * @param
     * @return
     */
    List<ContentIndicatorsDTO> getAllInfo();
}
