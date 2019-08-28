package com.liaoxuefeng.stream;


/**
 * lambda表达式
 *
 *
 *  lambda使用条件
 *  1.接口中只能有一个方法
 *  2.有默认的方法除外 default
 *  3.Object类对应的方法外
 *  叫做函数式接口
 *  用@FunctionalInterface 来检测 没有实际作用
 *
 */
public class Lambada {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        new Thread(()-> System.out.println("jo")).start();

        say((n,m)->n+m);
        //单行表达式
        say((String n,String m)->n+m);
        //语句块
        say((n,m)-> {
            return n+m;
        });
        //静态方法引用
        say(Lambada::sayHello);
        //实例方法引用
        say(new Lambada()::sayHello2);
    }

    public String sayHello2(String name,String message){
        return name+message;
    }

    static String sayHello(String name,String message){
        return name+message;
    }

    public static void say(myInterface myInterface){
        System.out.println(myInterface.sayHello("鲁班","say Hi"));
    }

    //例子
    @FunctionalInterface
    public interface myInterface{
        String sayHello(String name,String message);
    }

}
