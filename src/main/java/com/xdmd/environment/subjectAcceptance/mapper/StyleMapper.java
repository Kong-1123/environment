package com.xdmd.environment.subjectAcceptance.mapper;

import com.xdmd.environment.subjectAcceptance.pojo.AcceptMethod;
import com.xdmd.environment.subjectAcceptance.pojo.CommitInventory;
import com.xdmd.environment.subjectAcceptance.pojo.UnitNature;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StyleMapper {
    //查询公司的性质
    @Select("select content,id from dictionary where classification_id = 1")
    List<UnitNature> queryUnitNature();

    //查询申请的验收方式
    @Select("select id,content from dictionary where classification_id = 2")
    List<AcceptMethod> queryAcceptMethod();

    //查询验收提交清单
    @Select("select id,content from dictionary where classification_id = 3")
    List<CommitInventory> queryCommitInventory();
}
