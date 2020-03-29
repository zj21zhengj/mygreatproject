package mashibing.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        //创建cglib获取代理对象的操作对象
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(MyCalculator.class);
        //设置enchaner的回调对象
        enhancer.setCallback(new MyCglib());
        //创建代理对象
        MyCalculator myCalculator = (MyCalculator) enhancer.create();
        System.out.println(myCalculator.add(1,3));
        System.out.println(myCalculator.getClass());
    }
}
