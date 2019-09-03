package com.designpattern.q_proxy.c;

import java.util.Arrays;

interface ICalc {
    int add(int a,int b);
    int sub(int a,int b);
    int mul(int a,int b);
    int div(int a,int b);
}

class CalcImpl implements ICalc{

    private void begin(String methodName,Object... params){
        System.out.println(methodName+"方法开始 参数是"+ Arrays.toString(params));
    }

    private void end(String methodName,Object r){
        System.out.println(methodName+"方法结束 结果是"+r);
    }

    @Override
    public int add(int a, int b) {
        begin("add",a,b);
        int r = a+b;
        end("add",r);
        return r;
    }

    @Override
    public int sub(int a, int b) {
        begin("sub",a,b);
        int r = a-b;
        end("sub",r);
        return r;
    }

    @Override
    public int mul(int a, int b) {
        begin("mul",a,b);
        int r = a*b;
        end("mul",r);
        return r;
    }

    @Override
    public int div(int a, int b) {
        begin("div",a,b);
        int r = a/b;
        end("div",r);
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

/**目前的优点
 *1.提高代码重用性
 * 2.如果需求再次变化 只需要改一个地方
 *
 * 没有解决
 *  1 代码急聚膨胀 核心业务代码和非核心业务代码 耦合一起
 *  2.需求加入 球余  开方 立方  还必须在每个方法 都手动调用一下begin 和 end
 *
 *
 * 尤其碰到这样的日子 早上要日志 晚上不要日志
 *
 */
