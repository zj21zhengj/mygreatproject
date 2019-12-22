package com.liaoxuefeng.refects;


public class ClassDemo2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            create("aa");
        }
    }

    static void create(String name) {
        Person p = new Person(name);
    }
}
