package com.designpattern.simplefactory.d;


/**
 *
 * 工厂方法模式的缺点是 一旦产品等级增加 代码类 会爆炸式增长
 *
 */

//抽象产品
interface Food{
    void eat();
}

//具体产品
class Humburger implements Food {

    @Override
    public void eat() {
        System.out.println("吃汉堡包！");
    }
}

class RiceNoodle implements Food {

    @Override
    public void eat() {
        System.out.println("过桥米线");
    }
}

//抽象产品
interface Drink{
    void drink();
}

//具体产品
class Cola implements Drink {

    @Override
    public void drink() {
        System.out.println("喝可乐！");
    }
}

class Milk implements Drink {

    @Override
    public void drink() {
        System.out.println("喝牛奶！");
    }
}

interface Factory{
    public Food getFood();
    public Drink getDrink();
}

class KFCFactory implements Factory{

    @Override
    public Food getFood() {
        return new Humburger();
    }

    @Override
    public Drink getDrink() {
        return new Cola();
    }
}


class RiceNoodleFactory implements Factory{

    @Override
    public Food getFood() {
        return new RiceNoodle();
    }

    @Override
    public Drink getDrink() {
        return new Milk();
    }
}


class Bussiness{
    public void taste(Factory ff){
        Food f = ff.getFood();
        Drink d = ff.getDrink();
        System.out.println("评委1 品尝");
        f.eat();
        d.drink();


        Food f2 = ff.getFood();
        Drink d2 = ff.getDrink();
        System.out.println("评委2 品尝");
        f2.eat();
        d2.drink();

        Food f3 = ff.getFood();
        Drink d3 = ff.getDrink();
        System.out.println("评委3 品尝");
        f3.eat();
        d3.drink();
    }
}


//###########################################################################################

public class AppTest2 {
}


/**
抽象工厂
    优点
        1.仍然具有简单工厂和工厂方法的优点
        2.更重要的是 抽象工厂把工厂类的数量减少了 无论有多个产品等级 工厂就一套

        杠点
            为什么kfc 一定是汉堡加可乐呢 不能牛奶吗

        解释
            抽象工厂中，可以生产多个产品，这多个产品之间，必须有内在联系

       缺点
            当产品等级发生变化 都要引起所以以前工厂代码的修改
                这就违反了 开闭原则


    结论
        当产品等级比较固定 可以考虑抽象工厂 （1个产品等级就用 工厂方法模式）
        如果产品等级经常变化， 则不建议使用抽象可以 （答案是spring的动态工厂）
*/


