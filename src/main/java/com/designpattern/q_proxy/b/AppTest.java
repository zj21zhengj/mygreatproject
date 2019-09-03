package com.designpattern.q_proxy.b;

interface ICalc {
    int add(int a,int b);
    int sub(int a,int b);
    int mul(int a,int b);
    int div(int a,int b);
}

class CalcImpl implements ICalc{

    @Override
    public int add(int a, int b) {
        System.out.println("add方法开始，参数是"+a+","+b);
        int r = a+b;
        System.out.println("add结束，结果是"+r);
        return r;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub方法开始，参数是"+a+","+b);
        int r = a-b;
        System.out.println("sub方法结束，结果是"+r);
        return r;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul方法开始，参数是"+a+","+b);
        int r = a*b;
        System.out.println("mul方法结束，结果是"+r);
        return r;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div方法开始，参数是"+a+","+b);
        int r = a/b;
        System.out.println("div方法结束，结果是"+r);
        return r;
    }
}

public class AppTest {
    public static void main(String[] args) {
        ICalc c = new CalcImpl();
        c.add(1,2);
        c.sub(1,2);
        c.mul(1,2);
        c.div(1,2);
    }
}

/**变化来了 为每个方法添加日志功能 在方法开始时和结束时分别打印日志信息
 *目前需求已经解决 但是 有问题
 * 1.代码在重复
 * 2.如果需求再次变化 使用英文输出日志 就要改好多地方
 * 3.代码急聚膨胀 核心业务代码和非核心业务代码 耦合一起
 * 4.需求加入 球余  开方 立方
 *
 * 这种做法太2了
 *
 */
