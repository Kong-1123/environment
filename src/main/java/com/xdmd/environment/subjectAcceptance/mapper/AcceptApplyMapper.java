package com.xdmd.environment.subjectAcceptance.mapper;

import com.xdmd.environment.common.MyBaseMapper;
import com.xdmd.environment.subjectAcceptance.pojo.CheckApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcceptApplyMapper<T> extends MyBaseMapper<CheckApply> {
    //查询验收申请表
    List<CheckApply> queryAcceptApply(@Param("topicName") String subjectName, @Param("projectLeader") String projectLeader, @Param("page") Integer newpage, @Param("total") Integer total);

    //查询总数据量
    Integer queryAllTotal(@Param("topicName") String subjectName, @Param("projectLeader") String projectLeader, @Param("page") Integer newpage, @Param("total") Integer total);
}
