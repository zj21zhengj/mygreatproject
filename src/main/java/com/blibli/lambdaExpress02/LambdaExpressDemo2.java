package com.blibli.lambdaExpress02;

@FunctionalInterface
interface Foo2{
    int add(int x,int y);

    default int add2(int x,int y){
        return x*2+y;
    }
}

/**
 * 1.拷贝小括号 写死右箭头 落地大括号
 *
 *2 @FunctionalInterface 当你写的接口不符合函数式接口定义的时候，编译器就会报错 (是否包含一个抽象方法)
 *
 * defaut 方法可以有多个
 * static  方法可以有多个
 */

public class LambdaExpressDemo2 {
    public static void main(String[] args) {
        Foo2 foo2 = (int x,int y) -> x+y;
        System.out.println(foo2.add(5,10));

        System.out.println(foo2.add2(3,10));
    }
}
