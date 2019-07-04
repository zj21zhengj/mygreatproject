package com.designpattern.observe.v3;

/**
 * 加入多个观察者
 *
 * 太不灵活了，修改太不方便了，而且无法灵活处理特殊情况
 *
 */
class Child{

    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        dad.feed();
        mum.hug();
        dog.wang();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging...");
    }
}

class  Dog{
    public void wang(){
        System.out.println("dong wang...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}
