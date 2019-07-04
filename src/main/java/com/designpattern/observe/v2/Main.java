package com.designpattern.observe.v2;

/**
 * 加入观察者 Dad
 *
 * 弊 耦合度高
 */
class Child{

    private Dad d = new Dad();

    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        d.feed();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}
