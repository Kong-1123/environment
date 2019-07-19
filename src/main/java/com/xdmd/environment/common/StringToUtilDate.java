package com.xdmd.environment.common;

import com.xdmd.environment.subjectAcceptance.exception.StringToDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把String类型转换成Util.date类型
 * @Author: ZhangYuDeLong
 * @Date: 2019.7.17
 */
public class StringToUtilDate {

    public static Date stringToUtilDate(String date) throws StringToDateException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new StringToDateException("字符串转换成日期类型错误");
        }
        return parse;
    }
}
