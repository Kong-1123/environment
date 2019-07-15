package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * guide_summary
 * @author Kong
 * @date 2019/07/15
 */
@Mapper
@Repository
public interface GuideSummaryMapper {

    /**
     * [新增]
     * @author Kong
     * @date 2019/07/15
     **/
    int insert(@Param("guideSummary") GuideSummary guideSummary);

    /**
     * [刪除]
     * @author Kong
     * @date 2019/07/15
     **/
    int delete(@Param("id") int id);

    /**
     * [更新]
     * @author Kong
     * @date 2019/07/15
     **/
    int update(@Param("guideSummary") GuideSummary guideSummary);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/07/15
     **/
    GuideSummary load(@Param("id") int id);

    /**
     * [查詢] 分頁查詢
     * @author Kong
     * @date 2019/07/15
     **/
    List<GuideSummary> pageList(@Param("offset") int offset,
                                @Param("pagesize") int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author Kong
     * @date 2019/07/15
     **/
    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize);

}

