package com.designpattern.observe.v4;


import java.util.ArrayList;
import java.util.List;

class Child{

    private boolean cry = false;

    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }
    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        cry = true;
        for(Observer o:observers){
            o.actionOnWakeUp();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}


interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dong wang...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}