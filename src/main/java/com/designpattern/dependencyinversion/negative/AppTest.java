package com.designpattern.dependencyinversion.negative;

/**
 * 依赖倒置原则 反例
 */

class Person{
    public void feed(Dog dog){
        System.out.println("开始喂养");
        dog.eat();
    }
}

class Dog{
    public void eat(){
        System.out.println("狗啃骨头");
    }
}

//#-----------------------------------------------------------------------------------
//以上是源码
//注意 需求变化增加一只猫
//这种情况 person 和 dog的关系是 依赖是 ，是人依赖狗
//如果修改源码就是违反了开闭原则

class Cat{
    public void eat(){
        System.out.println("猫吃鱼");
    }
}


public class AppTest {
    public static void main(String[] args) {
        Person p = new Person();
        Dog d = new Dog();
        p.feed(d);
        Cat c = new Cat();
       // p.feed(c);
    }
}
