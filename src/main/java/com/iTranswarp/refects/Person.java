package com.iTranswarp.refects;

public class Person {

    private String name;

    static {
        System.out.println("加载时候运行");
    }

    public Person(String name){
        this.name = name;
    }
}
