package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.dailymanagement.mapper.MidCheckRecordMapper;
import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;
import com.xdmd.environment.dailymanagement.service.MidCheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description: 中期检查记录实现
 */
@Service
public class MidCheckRecordServiceImpl implements MidCheckRecordService {
    @Autowired
    MidCheckRecordMapper midCheckRecordMapper;
    /**
     * 新增中期检查记录
     * @param midCheckRecord
     * @return
     */
    @Override
    public int insertMidRecord(MidCheckRecordDTO midCheckRecord) {
        return midCheckRecordMapper.insertMidRecord(midCheckRecord);
    }

}
