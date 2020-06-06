package com.liaoxuefeng.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 用流水写法排序
 */
public class SortedList {
    public static void main(String[] args) {
        //定义一个100元素的集合，包含A-Z
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf((char) ('A' + Math.random() * ('Z' - 'A' + 1))));
        }
        System.out.println(list);
//统计集合重复元素出现次数，并且去重返回hashmap
        Map<String, Long> map = list.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
//由于hashmap无序，所以在排序放入LinkedHashMap里(key升序)
        Map<String, Long> sortMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).
                forEachOrdered(e -> sortMap.put(e.getKey(), e.getValue()));
        System.out.println(sortMap);
//获取排序后map的key集合
        List<String> keys = new LinkedList<>();
        sortMap.entrySet().stream().forEachOrdered(e -> keys.add(e.getKey()));
        System.out.println(keys);
//获取排序后map的value集合
        List<Long> values = new LinkedList<>();
        sortMap.entrySet().stream().forEachOrdered(e -> values.add(e.getValue()));
        System.out.println(values);


        List<Map<String,String>> list3 = new LinkedList<>();
        Map<String,String> am = new HashMap<>();
        am.put("哎","12");
        Map<String,String> bm = new HashMap<>();
        bm.put("哎2","22");
        Map<String,String> cm = new HashMap<>();
        cm.put("哎2","22");
        list3.add(am);
        list3.add(bm);
        list3.add(cm);
        Map<Map<String,String>, Long> map9 = list3.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(list3);
        System.out.println("--------------------------");
        System.out.println(map9);

        Map<Map<String,String>, Long> sortMap9 = new LinkedHashMap<>();
        //升序排序
        map9.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                forEachOrdered(e -> sortMap9.put(e.getKey(), e.getValue()));
        //降序排序
        map9.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                forEachOrdered(e -> sortMap9.put(e.getKey(), e.getValue()));
        System.out.println(sortMap9);
    }
}
