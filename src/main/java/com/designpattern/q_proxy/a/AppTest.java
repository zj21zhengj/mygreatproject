package com.designpattern.q_proxy.a;


/**
 * 讲
 */
interface ICalc {
    int add(int a,int b);
    int sub(int a,int b);
    int mul(int a,int b);
    int div(int a,int b);
}

class CalcImpl implements ICalc{

    @Override
    public int add(int a, int b) {
        int r = a+b;
        return r;
    }

    @Override
    public int sub(int a, int b) {
        int r = a-b;
        return r;
    }

    @Override
    public int mul(int a, int b) {
        int r = a*b;
        return r;
    }

    @Override
    public int div(int a, int b) {
        int r = a/b;
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

 *
 */