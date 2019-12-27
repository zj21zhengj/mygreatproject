package com.blibli.notsafecollection03;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 知识点 arrayList 底层是个 Object类的数组
 * 用arraycopy 来复制 每次扩容为原大小的一半
 * <p>
 * arrayList是线程不安全的  但是性能高 2000年前都是 form表单 单线程的就是我现在做的
 * 自从阿里 京东出现后各种高并发
 * 1.错误现象
 * java.util.ConcurrentModificationException
 *
 *2.导致原因
 * 多线程共同争夺同一资源，且不加锁
 *
 *
 * 3.解决办法
 *    new Vector<>();   Collections.synchronizedList(new ArrayList<>());
 *
 *    CopyOnWriteArrayList https://www.cnblogs.com/simple-focus/p/7439919.html  只是在写上加锁，读不加锁
 *    写时复制   写时读旧的，写完后指向最新的
 *
 *
 * **/
public class NotSafeDemo01 {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList();
                //Collections.synchronizedList(new ArrayList<>());
                //new Vector<>();
                //new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
                },String.valueOf(i)).start();
        }
    }
}
