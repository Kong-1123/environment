package com.xdmd.environment.CommomTest;

/**
 * @author: Kong
 * @createDate: 2019/07/30
 * @description: 截取string
 */
public class SubstringTest {
    public static void main(String[] args) {
        //OpenTenderServiceImpl openTenderService=new OpenTenderServiceImpl();
        //String projectNo=openTenderService.getNewData().getProjectNo();
        String string=new String("xdmd20190001");
        int num = Integer.parseInt(string.substring(4))+1;
        System.out.println("截取到的值为："+num);
    }
}
