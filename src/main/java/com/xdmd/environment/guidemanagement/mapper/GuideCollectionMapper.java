package com.xdmd.environment.guidemanagement.mapper;

import com.xdmd.environment.guidemanagement.pojo.GuideCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * guide_collection
 * @author Kong
 * @date 2019/07/15
 */
@Mapper
@Repository
public interface GuideCollectionMapper {

    /**
     * [新增]
     * @author Kong
     * @date 2019/07/15
     **/
    int insert(@Param("guideCollection") GuideCollection guideCollection);

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
    int update(@Param("guideCollection") GuideCollection guideCollection);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Kong
     * @date 2019/07/15
     **/
    GuideCollection load(@Param("id") int id);

    /**
     * [查詢] 分頁查詢
     * @author Kong
     * @date 2019/07/15
     **/
    List<GuideCollection> pageList(@Param("offset") int offset,
                                   @Param("pagesize") int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author Kong
     * @date 2019/07/15
     **/
    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize);

}
