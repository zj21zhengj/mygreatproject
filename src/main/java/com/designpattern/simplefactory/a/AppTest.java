package com.designpattern.simplefactory.a;

/**
 * 反例
 */

//抽象产品
interface Food{
    void eat();
}

//具体产品
class Humburger implements Food{

    @Override
    public void eat() {
        System.out.println("吃汉堡包！");
    }
}

//###############################################################################################
//上面是客户端代码

public class AppTest {
    public static void main(String[] args) {
        Food f = new Humburger();
        f.eat();
    }
}

/**
 * 这种设计相当脆弱 为什么 因为只要作者修改了具体产品的类名
 * 那么 客户端代码也要一起改变， ，如Humburger 该为 Humbergue2
 * 这种服务器代码和客户端代码是耦合的
 *
 * 我们希望的是 服务器代码改了， 客户端代码不用改
 *  这违反了比米特法则， 把细节全部暴露了
 */
