package com.designpattern.simplefactory.c;

/**
 * 工厂方法设计模式
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

interface FoodFactory{
    public Food getFood();
}

class HumburgerFactory implements FoodFactory{

    @Override
    public Food getFood() {
        return new Humburger();
    }
}


class RiceNoodleFactory implements FoodFactory{

    @Override
    public Food getFood() {
        return new RiceNoodle();
    }
}


class Bussiness{
    public void taste(FoodFactory ff){
        Food f = ff.getFood();
        System.out.println("评委1 品尝");
        f.eat();

        Food f2 = ff.getFood();
        System.out.println("评委2 品尝");
        f2.eat();

        Food f3 = ff.getFood();
        System.out.println("评委3 品尝");
        f3.eat();
    }
}

//###########################################################################

class LP implements Food {

    @Override
    public void eat() {
        System.out.println("凉皮");
    }
}


class LPFactory implements FoodFactory{

    @Override
    public Food getFood() {
        return new LP();
    }
}


public class AppTest {
    public static void main(String[] args) {
        FoodFactory ff = new RiceNoodleFactory();
        Food food = ff.getFood();
        food.eat();

        FoodFactory ff2 = new LPFactory();
        Bussiness b = new Bussiness();
        b.taste(ff2);
    }
}


/**
 优点：
    1.仍然具有简单工厂的优点，服务器修改了，客户不知道
    2 当客户端需要扩展一个新的产品 不需要修改服务端

 杠点：
    1 服务端代码改了，客户端不知道，就像第一点humburger改为2了，客户端也变
   现在改为factory不是回到了起点

 解释：
    factory有责任，服务端作者让它趋向于稳定，（不是100%不变） 至少比类名稳定

 2.既然产品都是客户端扩展出来，不象服务端那样为别人设计 那为什么还要做工厂呢

   解释：
    因为作者在开发功能时，不仅仅会开发抽象产品，还会做好搭配的业务框架
    如bussine 里面传的就是 Factory

 3. 那为什么不从一开始 就让bussiness就直接接收Food参数？而不是现在的FoodFactory

 解释：工厂方法的名字是稳定的， 不像类 如杠点1
 */