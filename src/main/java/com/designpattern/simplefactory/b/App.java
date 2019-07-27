package com.designpattern.simplefactory.b;

//针对于a包的问题，服务器代码修改，客户端代码也要修改
//使用简单工厂设计模式

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

class FoodFactory{
    public static Food getFood(int n){
        Food food = null;
        switch (n){
            case 1:
                food = new Humburger();
                break;
            case 2:
                food = new RiceNoodle();
        }
        return food;
    }
}

//###########################################################################

class LP implements Food{

    @Override
    public void eat() {
        System.out.println("吃凉皮");
    }
}

//客户端代码
public class App {
    public static void main(String[] args) {
        Food food = FoodFactory.getFood(1);
        food.eat();
    }

}

/**
简单工厂
    优点
        1.把具体产品的类型，从客户端代码中，解耦出来了
        2.服务器端，如果修改了具体产品的类名，客户端也知道
        这便符合了 “面向接口编程”的思想
                设计模式里的接口 不单单指的inteface 向下暴露的类和方法 都可以称为factory

    缺点
        客户端不得不死记硬背数字与具体产品的映射
        2.如果具体产品非常多有100个 则简单工厂就会变得十分臃肿 比如有100个具体产品在需要100个case
        3.最重要的是 变化来了，需要写个凉皮。无法加到服务端代码中 不符合开闭原则


 要想方设法加入到工厂中
 **/
