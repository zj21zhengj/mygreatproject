package com.liaoxuefeng.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * stream mytest
 * 把map里的值转为 对应的中文
 *
 // user对象List转user对象中name字符串的List
 List<String> stringList= list.stream().map(UserList::getName).collect(Collectors.toList())

 */
public class MyTest {
    public static void main(String[] args) {
        List<Integer> am = new ArrayList<>();
        am.add(1);
        am.add(2);
        am.add(3);
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1,"a");
        map2.put(2,"b");
        map2.put(3,"c");

        System.out.println(am.stream().map(i->map2.get(i)).collect(Collectors.toList()));
    }
}
