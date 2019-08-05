package com.xdmd.environment.CommomTest;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Kong
 * @createDate: 2019/8/4
 * @description: 去重
 */
public class quchong {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(1);list.add(4);
        list.add(1);list.add(2);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(list.size());
        set.addAll(list);
        list.clear();
        list.addAll(set);
        for (Integer integer : list) {
            System.out.print(integer);
        }

    }
}
