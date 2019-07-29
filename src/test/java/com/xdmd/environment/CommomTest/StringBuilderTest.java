package com.xdmd.environment.CommomTest;

import org.junit.Test;

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
         * 获取当前年份
         */
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        //Date date = new Date();
        //String sDate = date.toString();
        //sDate = sdf.format(date);
            /**
         * 拼接课题编号和年份

        //StringBuilder number = new StringBuilder(sDate);
        //number.append("0000");
            OpenTender openTender=new OpenTender();
        String show=openTender.getProjectNo().toString();
            int num = Integer.parseInt(number.toString());
            num += 1;
            StringBuilder sBuilder = new StringBuilder("xdmd");
            sBuilder.insert(sBuilder.length(), num).toString();
            openTender.setProjectNo(sBuilder.toString());
            //System.out.println("最终编号为:" + num);
            System.out.println("课题编号为:" + openTender.getProjectNo());
              */


    }
}
