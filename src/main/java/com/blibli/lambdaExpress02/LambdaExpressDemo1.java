package com.blibli.lambdaExpress02;


interface Foo {
    void sayHello();
}

/**
 * lambda表达式
 * 1.拷贝小括号 写死右箭头 落地大括号
 */
public class LambdaExpressDemo1 {
    public static void main(String[] args) {
        Foo foo = () -> {
            System.out.println("Hello Words!");
        };

        foo.sayHello();
    }
}
