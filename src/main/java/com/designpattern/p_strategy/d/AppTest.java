package com.designpattern.p_strategy.d;


/**
 * 针对于c包中的问题
 * 是时候 把飞行方法和叫方法 从鸭子中分离出来了
 *
 *
 */


interface FlyBehavior{
    void fly();
}


class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("用翅膀飞!!!!");
    }
}

class FlyWithRocket implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("背上绑个穿天猴");
    }
}

class FlyWithKick implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("被人踢飞");
    }
}

class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("飞不起来！！");
    }
}

interface QuackBehavior{
    void quack();
}

class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}


class Squack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("slince");
    }
}


abstract class Duck{

    protected FlyBehavior fb;
    protected QuackBehavior qb;

    public void swim(){
        System.out.println("游泳...");
    }

    public void performFly(){
        fb.fly();
    }

    public void perFormQuack(){
        qb.quack();
    }

    //因为鸭子外观不一样
    public abstract void display();

    public FlyBehavior getFb() {
        return fb;
    }

    public void setFb(FlyBehavior fb) {
        this.fb = fb;
    }

    public QuackBehavior getQb() {
        return qb;
    }

    public void setQb(QuackBehavior qb) {
        this.qb = qb;
    }
}

class MallarDuck extends Duck{

    public MallarDuck(){
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }


}

class ReadHeadDuck extends Duck{

    public ReadHeadDuck(){
        this.fb = new FlyWithWings();
        this.qb = new Quack();
    }

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }
}

class RubberDuck extends Duck{
    public RubberDuck(){
        this.fb = new FlyNoWay();
        this.qb = new Squack();
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

class DecoyDuck extends Duck{
    public DecoyDuck(){
        this.fb = new FlyNoWay();
        this.qb = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

public class AppTest {
    public static void main(String[] args) {
        RubberDuck d = new RubberDuck();
        d.performFly();
        d.perFormQuack();
        d.swim();
        d.display();
        //加入set和 get后能 运行时替换
        d.setFb(new FlyWithKick());
        d.performFly();
    }
}

/**
 * 此时针对于48种鸭子 12种方法每个方法只实现一次
 *
 *  这就是传说中的策略模式
 *
 *  就好比 坦克大战吃了道具后 子弹轨道变了
 *
 *
 *
 *
 *
 *
 *
 */