package com.blibli.notsafecollection03;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * hashMap是线程不安全的
 * hashTable是线程安全的，但是用hashTable并发性能太低了
 *
 * **/
public class NotSafeDemo03 {
    public static void main(String[] args) {
        Map<String,String> maps = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                maps.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(maps);
            },String.valueOf(i)).start();
        }
    }
}
