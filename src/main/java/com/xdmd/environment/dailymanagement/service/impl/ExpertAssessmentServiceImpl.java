package com.xdmd.environment.dailymanagement.service.impl;

import com.xdmd.environment.common.ResultMap;
import com.xdmd.environment.dailymanagement.mapper.ExpertAssessmentMapper;
import com.xdmd.environment.dailymanagement.pojo.ExpertAssessmentDTO;
import com.xdmd.environment.dailymanagement.service.ExpertAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Kong
 * @createDate: 2019/8/17
 * @description: 专家评估业务实现
 */
@Service
public class ExpertAssessmentServiceImpl implements ExpertAssessmentService {
    @Autowired
    ExpertAssessmentMapper expertAssessmentMapper;
    ResultMap resultMap=new ResultMap();

    /**
     * 新增
     * @param expertAssessment
     * @return
     */
    @Override
    public ResultMap insert(ExpertAssessmentDTO expertAssessment) {
        try{
            int insertNo=expertAssessmentMapper.insertEA(expertAssessment);
            if(insertNo>0){
                resultMap.success().message("成功新增"+insertNo+"条数据");
            }else if(insertNo==0){
                resultMap.success().message("新增失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * 根据id查询专家评估
     * @param id
     * @return
     */
    @Override
    public ResultMap getEAByid(int id) {
        try{
            ExpertAssessmentDTO ea=expertAssessmentMapper.getEAByid(id);
            if(ea!=null){
                resultMap.success().message(ea);
            }else if(ea==null){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * 查询全部专家评估
     * @return
     */
    @Override
    public ResultMap getAllEA() {
        try{
            List<ExpertAssessmentDTO> eaList=expertAssessmentMapper.getAllEA();
            if(eaList.size()>0){
                resultMap.success().message(eaList);
            }else if(eaList.size()==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }

    /**
     * 从字典里查询全部评估内容
     * @return
     */
    @Override
    public ResultMap getAllEvaluationContent() {
        try{
            List<Map> pinggucontent=expertAssessmentMapper.getAllEvaluationContent();
            if(pinggucontent.size()>0){
                resultMap.success().message(pinggucontent);
            }else if(pinggucontent.size()==0){
                resultMap.success().message("没有查到相关信息");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.success().message("系统异常");
        }
        return resultMap;
    }
}
