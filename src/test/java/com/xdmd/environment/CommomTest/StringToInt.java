package com.xdmd.environment.CommomTest;

import java.util.*;

/**
 * @author: Kong
 * @createDate: 2019/8/3
 * @description: 字符串类型list转int类型list
 */
public class StringToInt {
    public static void main(String[] args) {
        //将循环出的id拆分转换成int类型存到List中
        List<String> list = new LinkedList<>();
        list.add("1,3,5");
        list.add("2,4,6");
        list.add("2,6,8");
        list.add("5,8,15,20");
        list.add("4,10,12,15,18,25");
        List<String> stringList = new LinkedList<>();
        List<Integer> integerList = new LinkedList<>();
        for (String str : list) {
            String[] a = str.split(",");
            stringList = Arrays.asList(a);
            integerList = new LinkedList<>();
            for (String string : stringList) {
                integerList.add(Integer.parseInt(string));
            }
            LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(integerList.size());
            set.addAll(integerList);
            integerList.clear();
            integerList.addAll(set);
            //for (Integer integer : integerList) {
            //    System.out.print(integer);
            //}
        }

    }
}
