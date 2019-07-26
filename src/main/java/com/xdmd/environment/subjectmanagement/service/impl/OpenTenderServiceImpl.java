package com.xdmd.environment.subjectmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectmanagement.mapper.OpenTenderMapper;
import com.xdmd.environment.subjectmanagement.pojo.OpenTender;
import com.xdmd.environment.subjectmanagement.service.OpenTenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/07/26
 * @description: 招标业务实现类
 */
@Service
public class OpenTenderServiceImpl implements OpenTenderService {
    @Autowired
    OpenTenderMapper openTenderMapper;
    ResultMap resultMap=new ResultMap();

    @Override
    public ResultMap insertTender(OpenTender openTender) {
        if(openTenderMapper.insertTender(openTender)>0){
            return resultMap.success().message("新增成功");
        }else{
            return resultMap.fail().message("新增失败");
        }
    }

    /**
     * 根據id查詢相应单位招标
     * @param id
     * @return
     */
    @Override
    public ResultMap getTenderById(int id) {
        List<OpenTender> getTenderByIdList=openTenderMapper.getTenderById(id);
        return getTenderByIdList.size()>0?resultMap.success().message(getTenderByIdList):resultMap.fail().message("查询失败");
    }

    @Override
    public List<OpenTender> getTenderPageList(String projectName, String subjectName, String subjectLeader, String leaderContact,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OpenTender> openTenderList= openTenderMapper.getTenderPageList(projectName, subjectName, subjectLeader, leaderContact);
        return openTenderList;
    }
}
