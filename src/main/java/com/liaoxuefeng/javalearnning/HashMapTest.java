package com.liaoxuefeng.javalearnning;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * hashmap put后输出是由随机性的
 * 需要转为LinkedHashMap 可是我测不出来
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        System.out.println(map);
        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }
    }
}
