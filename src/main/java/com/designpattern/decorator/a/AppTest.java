package com.designpattern.decorator.a;

/** 装饰器模式
 *
 *  业务场景 星巴克卖咖啡 一开始只卖4种
 *    Decaf  Espressor DarkRoast  HouseBlend
 *
 *  因为所有咖啡都有共性，所有开发人员，把他们的共性上提到一个父类种，Bervarage
 *
 *
 *
 */

abstract class Bervage{

    private String description;

    public Bervage(String description){
        this.description = description;
    }

    public abstract double cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Decaf extends Bervage{
    public Decaf(){
        super("无咖啡因咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

class Espressor extends Bervage{
    public Espressor(){
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}


class DarkRoast extends Bervage{
    public DarkRoast(){
        super("焦炒咖啡");
    }

    @Override
    public double cost() {
        return 2;
    }
}

class HouseBlend extends Bervage{
    public HouseBlend(){
        super("混合咖啡");
    }

    @Override
    public double cost() {
        return 3;
    }
}

//#========================================================================



public class AppTest {
    public static void main(String[] args) {
        Bervage b = new DarkRoast();
        System.out.println(b.getDescription()+":"+b.cost());
    }
}

/**
 * 代码看着没问题 但是变化来了
 *
 *
 * 星巴克老板想要 加入 调料 如牛奶 摩卡，有泡沫等等
 *
 */
