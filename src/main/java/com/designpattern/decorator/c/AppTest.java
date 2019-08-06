package com.designpattern.decorator.c;

/**
 * 针对b包的问题，不要新建很多的类，而是搞属性设置为 true 或 false
 */
abstract class Bervage{

    private String description;

    private boolean milk,soy,mocha,bubble;

    public Bervage(String description){
        this.description = description;
    }

    public  double cost(){
        double total = 0;
        if(milk){
            total += 0.2;
        }
        if(soy){
            total += 0.3;
        }
        if(mocha){
            total+=0.4;
        }
        if(bubble){
            total+=0.2;
        }
        return total;
    }

    public String getDescription() {
        String str = description;
        if(milk){
            str = str+"牛奶";
        }
        if(soy){
            str = str+"大豆";
        }
        if(mocha){
            str = str+"摩卡";
        }
        if(bubble){
            str = str+"泡沫";
        }
        return str;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean isBubble() {
        return bubble;
    }

    public void setBubble(boolean bubble) {
        this.bubble = bubble;
    }
}


class Decaf extends Bervage{
    public Decaf(){
        super("无咖啡因咖啡");
    }

    @Override
    public double cost() {
        //本身价格+调料价格
        return 1+super.cost();
    }
}

class Espressor extends Bervage{
    public Espressor(){
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 1+super.cost();
    }
}


class DarkRoast extends Bervage{
    public DarkRoast(){
        super("焦炒咖啡");
    }

    @Override
    public double cost() {
        return 2+super.cost();
    }
}

class HouseBlend extends Bervage{
    public HouseBlend(){
        super("混合咖啡");
    }

    @Override
    public double cost() {
        return 3+super.cost();
    }
}


//######################################################################################

class Tea extends Bervage{

    public Tea() {
        super("茶");
    }

    @Override
    public double cost() {
        return 5;
    }
}

public class AppTest {
    public static void main(String[] args) {
        Bervage b = new DarkRoast();
        b.setMilk(true);
        Bervage t = new Tea();
        System.out.println(b.getDescription()+":"+t.cost());
    }

}

/**

优点：1. 类不会爆炸
      2.新增一种饮料如茶，不会违反开闭原则

缺点
    1.新增一种调料 如枸杞 要重新定义 bervage 和 getcost 等方法，就会违反开闭原则， 需要在源代码中修改




 */
