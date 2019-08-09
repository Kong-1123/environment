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
        list.add(12);
        list.add(113);
        list.add(1114);
        list.add(11115);
        List<Integer> list1=new LinkedList<>();
        //System.out.println("转换前");
        //list.forEach(li -> System.out.println("list-->" + (li+1)));
        System.out.println("转换后");
        list.forEach(l -> list1.add(Integer.valueOf(l)));
        list1.forEach(li -> System.out.println("list1-->" + (li+1)));
    }
}
