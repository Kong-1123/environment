package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.mapper.DailyManageMapper;
import com.xdmd.environment.dailymanagement.pojo.MidCheckDTO;
import com.xdmd.environment.dailymanagement.service.DailyManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Kong
 * @createDate: 2019/8/12
 * @description: 中期检查记录实现
 */
@Service
public class DailyManageServiceImpl implements DailyManageService {
    @Resource
    DailyManageMapper dailyManageMapper;
    ResultMap resultMap=new ResultMap();

    @Override
    public ResultMap insert(MidCheckDTO midCheckDTO) {
        try{
            int midcheck=dailyManageMapper.insert(midCheckDTO);
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
}
