package com.designpattern.p_strategy.a;


/**  策略模式
 * 有一家游戏公司，制作一款鸭子游戏，在这个游戏中，角色都是鸭子，不同的鸭子之间，有共性
 * 所以为了提高代码的重用性，
 * 开发人员就制作了一个鸭子的父类 Duck 把这些鸭子的共性提到父类中
 */

abstract class Duck{

    public void quack(){
        System.out.println("嘎嘎");
    }

    public void swim(){
        System.out.println("游泳...");
    }

    //因为鸭子外观不一样
    public abstract void display();
}

class MallarDuck extends Duck{

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }
}

class ReadHeadDuck extends Duck{

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }
}


public class AppTest {
    public static void main(String[] args) {
        Duck d = new MallarDuck();
        d.quack();
        d.swim();
        d.display();
    }
}

/*
 就目前而言没什么问题 请看一下个包
 */