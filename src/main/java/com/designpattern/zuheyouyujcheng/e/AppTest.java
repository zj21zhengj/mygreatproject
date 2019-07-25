package com.designpattern.zuheyouyujcheng.e;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// 组合就没有这个问题了
class MySet{

    private Set set = new HashSet<>();

    private int count;

    public boolean add(Object e) {
        count++;
        return set.add(e);
    }

    public boolean addAll(Collection c) {
        count+=c.size();
        return set.addAll(c);
    }

    public int getCount(){
        return count;
    }
}

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
