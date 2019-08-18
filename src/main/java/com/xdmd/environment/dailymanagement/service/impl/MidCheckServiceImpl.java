package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.mapper.MidCheckMapper;
import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import com.xdmd.environment.dailymanagement.pojo.MidCheckRecordDTO;
import com.xdmd.environment.dailymanagement.service.MidCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description: 中期检查记录实现
 */
@Service
public class MidCheckServiceImpl implements MidCheckService {
    @Autowired
    MidCheckMapper midCheckMapper;
    ResultMap resultMap=new ResultMap();

    @Override
    public ResultMap insertMidCheck(MidCheckDTO midCheckDTO) {
        try{
            int midcheck= midCheckMapper.insertMidCheck(midCheckDTO);
            if(midcheck>0){
                resultMap.success().message("新增成功");
            }else if(midcheck<0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;

    }

    /**
     * [新增] 中期检察记录
     * @param midCheckRecordDTO
     * @return
     */
    @Override
    public ResultMap insertMidCheckRecord(MidCheckRecordDTO midCheckRecordDTO) {
        try{
            int midcheckrecord= midCheckMapper.insertMidCheckRecord(midCheckRecordDTO);
            if(midcheckrecord>0){
                resultMap.success().message("新增成功");
            }else if(midcheckrecord<0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * [更新] 中期检察记录状态
     * @return
     */
    @Override
    public ResultMap updateMidCheck() {
        try{
            int midcheckrecord= midCheckMapper.updateMidCheck();
            if(midcheckrecord>0){
                resultMap.success().message("新增成功");
            }else if(midcheckrecord<0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }
}
