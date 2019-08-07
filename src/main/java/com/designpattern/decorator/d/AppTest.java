package com.designpattern.decorator.d;

import com.sun.jndi.ldap.Ber;

/**
 * 针对c包的问题，引出装饰器模式
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
        //本身价格+调料价格
        return 1;
    }
}

class Espressor extends Bervage{
    public Espressor(){
        super("浓缩咖啡");
    }

    @Override
    public double cost() {
        return 1.5;
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


/**
 * 判断两个类之间能不能 继承
 *  is a 关系 并且符合 里氏替换原则
 *  以上只是原则， 在特定情况下可以违反 比如装饰器模式
 *
 */
abstract class Condiment extends Bervage{
    //让调料关联饮料
    protected Bervage bervage;

    public Condiment(Bervage bervage) {
        super("调料");
        this.bervage = bervage;
    }

}

class Milk extends Condiment{

    public Milk(Bervage bervage) {
        super(bervage);
    }

    @Override
    public double cost() {
        return 0.2 + bervage.cost();
    }

    @Override
    public String getDescription(){
        return bervage.getDescription()+"牛奶";
    }
}

class Soy extends Condiment{

    public Soy(Bervage bervage) {
        super(bervage);
    }

    @Override
    public double cost() {
        return 0.3 + bervage.cost();
    }

    @Override
    public String getDescription(){
        return bervage.getDescription()+"大豆";
    }
}

class Mocha extends Condiment{

    public Mocha(Bervage bervage) {
        super(bervage);
    }

    @Override
    public double cost() {
        return 0.5 + bervage.cost();
    }

    @Override
    public String getDescription(){
        return bervage.getDescription()+"摩卡";
    }
}


class Bubble extends Condiment{

    public Bubble(Bervage bervage) {
        super(bervage);
    }

    @Override
    public double cost() {
        return 0.9 + bervage.cost();
    }

    @Override
    public String getDescription(){
        return bervage.getDescription()+"泡沫";
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

class Gouqi extends Condiment{

    public Gouqi(Bervage bervage) {
        super(bervage);
    }

    @Override
    public double cost() {
        return bervage.cost()+1.9;
    }

    @Override
    public String getDescription(){
        return bervage.getDescription()+"枸杞";
    }
}

public class AppTest {
    public static void main(String[] args) {
        Bervage b = new Tea();
        Bervage milk = new Milk(b);
        Bervage soy = new Soy(milk);
        Bervage gouqi = new Gouqi(soy);
        System.out.println(gouqi.getDescription()+":"+gouqi.cost());
    }

}

/**
 * 装饰器模式 调用图解
 *   -----------------
 *   -                -
 *   -         --     -
 *   -         - -    -
 *   -          -      -
 *   ------------------
 *
 *  一层调一层
 *
 * 关键点  调料 一边继承 一边关联
 *
 *   优点 1.加新饮料如茶不会违背 开闭原则
 *        2.加新调料也不会违背开闭 原则
 *
 *    缺点： 类还是有点多，但是我们已经尽力了
 */
