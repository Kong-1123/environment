package com.xdmd.environment.contractmanage.mapper;

import com.xdmd.environment.contractmanage.pojo.ContentIndicatorsDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/6
 * @description: 计划内容指标
 */
@Repository
public interface ContentIndicatorsMapper {
    /**
     * [新增]
     * @author Kong
     * @date 2019/08/06
     **/
    int insert(@Param("contentIndicators") ContentIndicatorsDTO contentIndicatorsDTO);

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
    @Select(value = "select * from content_indicators")
    List<ContentIndicatorsDTO> getAllInfo();
}
