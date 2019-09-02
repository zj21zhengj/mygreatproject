package com.designpattern.p_strategy.c;


/**
 * 针对于b包中的问题 程序猿需要判断每个鸭子子类 谁会不会叫 谁会不会飞 不会叫的
 * 就重写quack方法 不会飞的就重写fly方法
 * 这个工作量是很大的
 *
 * 我们希望那些不会飞鸭子 压根就没有fly方法 不会叫的鸭子 压根就没有quack方法
 *
 * 把这个经常在子类中的变化的方法 从父类中分成两个接口 QuackAble flyAble
 *
 *
 */


interface Flyable{
    void fly();
}

interface Quackable{
    void quack();
}


abstract class Duck{

    public void swim(){
        System.out.println("游泳...");
    }
    //因为鸭子外观不一样
    public abstract void display();


}

class MallarDuck extends Duck implements Flyable,Quackable{

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }

    @Override
    public void fly() {
        System.out.println("我飞");
    }

    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}

class ReadHeadDuck extends Duck{

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }
}

class RubberDuck extends Duck implements Quackable{

    //因为橡皮鸭只能模拟叫 所以重写了方法
    @Override
    public void quack(){
        System.out.println("吱吱叫");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

public class AppTest {
    public static void main(String[] args) {
        MallarDuck d = new MallarDuck();
        d.quack();
        d.swim();
        d.display();
        d.fly();
    }
}

/**
 * 思考这样问题解决了？ 没有！
 *
 * 以前是 每加入一个新的鸭子角色 程序猿就要判断这个新的鸭子角色 是否会飞 是否会叫 不会飞就重写飞方法，不会叫的就重写叫方法
 * 现在是 每加入一个新的鸭子角色 程序猿就要判断这个新的鸭子角色 是否会飞 是否会叫 不会飞就不实现FlyAble方法 不会叫就不实现Quable方法
 *
 * 如此 程序猿的工作量并没有减少 仍然要不断的判断鸭子角色
 *
 * 另外一个缺点是 fly和quable方法 没法重用性可言
 * 比如48种鸭子。8种不会飞 那么飞方法就要在40个鸭子子类中重写
 *
 * 此时 应有扛 老师 从jdk1,8开始 接口中方法就默认实现了 default void
 * 此时48种鸭子 有8种不会飞 那么飞方法只需要在FlyAble中重写一次
 *
 * 解释 对于48种鸭子 有12种不同的方法呢？任然麻烦
 *
 *
 *
 *
 *
 *
 */