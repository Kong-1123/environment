package com.xdmd.environment.CommomTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Kong
 * @createDate: 2019/7/30
 * @description: JAVA中判断时间大小的方法
 */
public class DateTest {
    public static void main(String[] args) {
        //import java.text.DateFormat;
        //import java.text.SimpleDateFormat;
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date begin = fmt.parse("2017-07-30"); //开始时间
            Date end = fmt.parse("2017-08-30");   //结束时间
            //判断开始时间是否在结束时间之后,返回布尔值
            System.out.println(begin.after(end));   //false
            //判断开始时间是否在结束时间之前,返回布尔值
            System.out.println(begin.before(end));  //true
            //判断开始时间和结束时间是否相同,
            //返回1:begin大于end;
            //返回0:begin等于end;
            //返回-1:begin小于end
            System.out.println(begin.compareTo(end));   //-1
            begin = fmt.parse("2018-07-30");  //开始时间
            end = fmt.parse("2017-08-30");    //结束时间
            System.out.println(begin.compareTo(end));   //1
            begin = fmt.parse("2017-08-30");  //开始时间
            end = fmt.parse("2017-08-30");    //结束时间
            System.out.println(begin.compareTo(end));   //0
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
