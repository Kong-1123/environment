package com.xdmd.environment.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换成字符串类型
 * @Author: ZhangYuDeLong
 * @Date 2019.7017
 */
public class SqlDateToString {

    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        return format;
    }
}
