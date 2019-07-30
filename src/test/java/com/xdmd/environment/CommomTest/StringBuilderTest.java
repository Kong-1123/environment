package com.xdmd.environment.CommomTest;

import com.xdmd.environment.subjectmanagement.service.impl.OpenTenderServiceImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Kong
 * @createDate: 2019/07/29
 * @description: Strign测试
 */
public class StringBuilderTest {
    @Test
    public static void main(String[] args) {
        /**
         * 控制台输入

         Scanner z=new Scanner(System.in);
         System.out.println("输入课题代码");
         String code=z.next();
         System.out.println("输入课题代号");
         String no=z.next();
         int nolength=no.toString().length();
         */

        /**
         * 调用getNewData方法获取最新数据
         */
        OpenTenderServiceImpl openTenderService = new OpenTenderServiceImpl();
        String projectNo = openTenderService.getNewData().getProjectNo();
        String string = new String(projectNo);
       // String string = new String("xdmd20190000");
        /**
         * 分离出数字并转换成int类型
         */
        int num = Integer.parseInt(string.substring(4));
        if (num==20190000) {
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
        System.out.println("递增后" + num);
        StringBuilder sBuilder = new StringBuilder("xdmd");
        sBuilder.insert(sBuilder.length(), num).toString();
        System.out.println("最终编号为:" + num);

    }
}
