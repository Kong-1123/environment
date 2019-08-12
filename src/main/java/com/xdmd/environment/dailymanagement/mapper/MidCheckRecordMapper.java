package com.xdmd.environment.dailymanagement.mapper;

import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description: 中期检查记录
 */
@Repository
public interface MidCheckRecordMapper {
    /**
     * [新增]
     * @author Kong
     * @date 2019/08/12
     **/
    @Insert(value = "insert into mid_check_record VALUES(DEFAULT,#{midCheckName},#{midCheckInitiateTime},#{spotCheckSubject},DEFAULT,#{annexId})")
    int insertMidRecord(MidCheckRecordDTO midCheckRecord);
}
