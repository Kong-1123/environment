package com.xdmd.environment.subjectmanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.subjectmanagement.mapper.OpenTenderMapper;
import com.xdmd.environment.subjectmanagement.pojo.OpenTender;
import com.xdmd.environment.subjectmanagement.service.OpenTenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    ResultMap resultMap = new ResultMap();

    /**
     * 新增
     * @param openTender
     * @return
     */
    @Override
    public ResultMap insertTender(OpenTender openTender) {
        openTender.setProjectNo(setProjectNo());
        try {
            int no=openTenderMapper.insertTender(openTender);
            System.out.println("影响行数"+no);
        }catch (Exception e){
            resultMap.fail().message("新增失败");
        }
        return resultMap.success().message("新增成功");
    }

    /**
     * 课题编号自增设置
     * @param
     */
    public String setProjectNo(){
        getNewData();
        String subString = new String(openTenderMapper.getNewData().getProjectNo());
        /**
         * 分离出数字并转换成int类型
         */
        int num = Integer.parseInt(subString.substring(4));
        if (num<=20190000) {
            /**
             * 获取当前年份
             */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date = new Date();
            String sDate = date.toString();
            sDate = sdf.format(date);
            /**
             * 拼接课题编号和年份
             */
            StringBuilder number = new StringBuilder(sDate);
            number.append("0000");
            num = Integer.parseInt(number.toString());
        }
        num += 1;

        StringBuilder sBuilder = new StringBuilder("xdmd");
        String finalResult=sBuilder.insert(sBuilder.length(), num).toString();
        return finalResult;
    }
    /**
     * 根據id查詢相应单位招标
     *
     * @param id
     * @return
     */
    @Override
    public ResultMap getTenderById(int id) {
        List<OpenTender> getTenderByIdList = openTenderMapper.getTenderById(id);
        return getTenderByIdList.size() > 0 ? resultMap.success().message(getTenderByIdList) : resultMap.fail().message("查询失败,该信息可能已被删除");
    }

    @Override
    public List<OpenTender> getTenderPageList(String projectName, String subjectName, String subjectLeader, String leaderContact, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OpenTender> openTenderList = openTenderMapper.getTenderPageList(projectName, subjectName, subjectLeader, leaderContact);
        return openTenderList;
    }


    @Override
    public OpenTender getNewData() {
        return openTenderMapper.getNewData();
    }
}
