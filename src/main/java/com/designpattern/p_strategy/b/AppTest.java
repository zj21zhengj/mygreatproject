package com.designpattern.p_strategy.b;


/**
 * 游戏公司的老总开会，得出一个提高本公司游戏竞争力的方案；要求让游戏中的鸭子飞起来
 * 把其他竞争者远远甩在身后
 *
 * 程序员就想，是时候展现我们面向对象程序猿的威力了 我只需要在父类Duck中增加fly方法
 * 那么所有子类也都有这个方法了
 *
 *
 * 此时 问题看似解决了，但实际上出现了更麻烦的问题，所有Duck的子类鸭子统统都会飞了
 * 要知道父类中的方法，并不是所有子类都能通用的 比如 橡皮鸭 橡皮鸭是没有生命的 不能飞
 * 结果因为继承了Duck 搞得橡皮鸭能飞 程序猿就会背锅
 *
 *
 *
 */

abstract class Duck{

    public void quack(){
        System.out.println("嘎嘎");
    }

    public void swim(){
        System.out.println("游泳...");
    }

    public void fly(){
        System.out.println("我飞");
    }

    //因为鸭子外观不一样
    public abstract void display();
}

class MallarDuck extends Duck{

    @Override
    public void display() {
        System.out.println("外观是野鸭");
    }
}

class ReadHeadDuck extends Duck{

    @Override
    public void display() {
        System.out.println("外观是红头鸭");
    }
}

class RubberDuck extends Duck{

    //因为橡皮鸭只能模拟叫 所以重写了方法
    @Override
    public void quack(){
        System.out.println("吱吱叫");
    }

    @Override
    public void fly(){
        System.out.println("橡皮鸭不能飞");
    }

    @Override
    public void display() {
        System.out.println("外观是橡皮鸭");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Duck d = new MallarDuck();
        d.quack();
        d.swim();
        d.display();
        d.fly();
    }
}

/**
 * 看起来问题解决了 但是并没有变化不断的出现 一会儿出现了木鸭子 一会加个鸭子超人
 * 一会叫个鸭子伯爵
 * 程序猿在每次添加鸭子都会判断 新的鸭子角色会不会叫 会不会飞 针对不同鸭子 要有不通的
 * 处理方法
 * 这样也很麻烦 只不过从一个噩梦跳到另一个噩梦
 *
 *
 *
 */