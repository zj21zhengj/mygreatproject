package com.designpattern.adapter;


/**
 *
 * 一个类的接口转换为客户希望的另一个接口  适配器模式让那些接口不兼容的类一起工作
 */

class Calc{
    public int add(int a,int b){
        return a+b;
    }
}


//##################################################
//变化来个客户希望计算3个数的和

/**
 * 组合由于继承   因为避免作者也写了三参数和的方法
 */
class CalApater{

    private Calc calc;

    public CalApater(Calc calc) {
        this.calc = calc;
    }

    public int add(int a,int b,int c){
        return calc.add(a,calc.add(b,c));
    }
}


public class AppTest {
    public static void main(String[] args) {
        Calc calc = new Calc();
        CalApater calApater = new CalApater(calc);
        int r = calApater.add(1,2,5);
        System.out.println(r);
    }
}
