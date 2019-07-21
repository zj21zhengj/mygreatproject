package com.designpattern.dependencyinversion.positive;

/**
 * 正例
 */

interface Animal{
    void eat();
}

class Person{
    public void feed(Animal animal){
        System.out.println("开始喂养");
        animal.eat();
    }
}

class Dog implements Animal{
    public void eat(){
        System.out.println("狗啃骨头");
    }
}

//#-----------------------------------------------------------------------------------
//以上是源码
class Cat implements Animal{
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
        p.feed(c);
    }
}
