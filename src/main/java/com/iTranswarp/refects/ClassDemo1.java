package com.iTranswarp.refects;

/**
 * 每加载一种class,jvm就为其创建一个class类型的实例，并关联起来
 *
 * 只有 jvm 能这样做 Class cls = new Class(String);
 * 获取Class 的三种方法
 */
public class ClassDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "Hello";
        Class cls1 = String.class;
        Class cls2 = s.getClass();
        Class cls3 = Class.forName("java.lang.String");
        System.out.println(cls1 == cls2 && cls1 == cls3);
    }

}
