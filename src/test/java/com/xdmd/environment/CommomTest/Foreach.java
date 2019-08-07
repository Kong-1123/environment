package com.xdmd.environment.CommomTest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/08/07
 * @description: 遍历
 */
public class Foreach {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(10);
        list.add(100);
        list.add(1000);
        list.add(10000);
        list.add(100000);
        list.add(1000000);
        //测试新的遍历写法
        list.forEach(li -> System.out.println("list-->" + li));

    }
}
