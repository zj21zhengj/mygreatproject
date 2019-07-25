package com.designpattern.zuheyouyujcheng.c;

//需求 制作一个集合 要求该集合能记录增经加过多少个元素 不是统计某一时刻集合中有多少个元素

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


//解决b包题的问题
//改进办法 不再调父类的addAll
class MySet extends HashSet {

    private int count = 0;

    @Override
    public boolean add(Object e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection c){
        boolean bb = false;
        for(Object obj:c){
            if(add(c)){
                bb = true;
            }
        }
        return bb;
    }


    public int getCount(){
        return count;
    }

}

//还是有问题 1. 如果新版本的jdk版本中 HashSet突然多了个元素加入集合的入口 比如addSome
//这是始料未及的 当使用addSome方法添加时 根本不会去统计元素的数量

//2.我们重写了addAll方法，没头没脑的重写了作者的方法 可能撼动整个作者的架构

public class AppTest {
    public static void main(String[] args) {
        MySet set = new MySet();
        Set set2 = new HashSet();
        set2.add("net");
        set2.add("n33");
        set2.add("n44");
        set.addAll(set2);
        System.out.println(set.getCount());
    }

}