package com.xdmd.environment.company.Controller;

import com.xdmd.environment.company.Pojo.Time;
import com.xdmd.environment.company.mapper.DateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("date")
public class DateController {
    @Autowired
    private DateMapper dateMapper;

    @RequestMapping("demo")
    @ResponseBody
    public String Demo(){
        try {
            String time ="1951-2-6";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateAgreementStartTime = sdf.parse(time);
            long timeAgreementStartTime = dateAgreementStartTime.getTime();
            java.sql.Date sqlAgreementStartTime = new java.sql.Date(timeAgreementStartTime);
            Time time1 = new Time();
            time1.setTime(sqlAgreementStartTime);
            dateMapper.insert(time1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "成功";
    }
}
