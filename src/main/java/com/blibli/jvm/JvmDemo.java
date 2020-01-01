package com.blibli.jvm;

import java.util.ArrayList;
import java.util.List;

public class JvmDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getClassLoader());
        System.out.println("**********************");
        JvmDemo jvmDemo = new JvmDemo();
        System.out.println(jvmDemo.getClass().getClassLoader());
        System.out.println(jvmDemo.getClass().getClassLoader().getParent());
        System.out.println(jvmDemo.getClass().getClassLoader().getParent().getParent());
    }
}
