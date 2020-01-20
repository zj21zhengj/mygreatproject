package com.designpattern.sigleton;


/**
 * 饿汉式
 * 类加载到内存中，就实例化一个单例，jvm保证线程安全 (jvm保证每个class只会load到内存一次，static的变量是load到内存之后，马上就进行初始化的，所以也一次)
 * 简单实用 推荐实用!
 *
 *  唯一缺点，不管用到与否，类装载时就完成实例
 *  Class.forName()  只放到内存里，但是不对它实例化，但是这个类会实例化
 * (不用，为什么装载呢)
 */
public class Mgr01 {
    //final必须初始化，或者后面紧跟static语句块
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){
        //System.out.println("1111111111111");
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        //System.out.println("22222222222");
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }
}
