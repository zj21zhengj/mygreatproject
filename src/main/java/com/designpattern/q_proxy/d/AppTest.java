package com.designpattern.q_proxy.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 针对于c包中的问题 我们先不解决 先学习jdk中的一个api动态代理
 *
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

class MyHandle implements InvocationHandler{
    private Object target;

    public MyHandle(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //proxy 接收 proxy  meithod接收sub add 反射机制反射出来的
        System.out.println(method.getName()+"方法开始,参数是 "+ Arrays.toString(args));
        //反射机制 接收真实的对象
        Object r = method.invoke(target,args);
        System.out.println(method.getName()+"方法结束结果是 "+r);
        return 0;
    }
}

public class AppTest {
    public static void main(String[] args) {

        //目标对象 真实对象
        ICalc c = new CalcImpl();
        //c.add(1,2);

        //创建代理对象
        //第1个参数是ClassLoader
        //我们都知道 要实例化一个对象 是需要调用类的构造器的，
        //在程序运行期间第一次调用构造器时 就会引起类的加载
        //加载类的时间，就是jvm拿着ClassLoader去加载类的字节码
        //只有字节码被加载到了内存中，才能进一步去实例化出类的对象
        //简单来说 就是只要设计实例化类的对象 就一定要加载类的字节码，而加载字节码就必须用类加载器
        //下面我们使用的动态代理的api来创建一个类的对象 这是一种不常用的实例化对象的方式
        //尽管不常用，但毕竟涉实例化类的对象
        //那就一定也需要加载类的字节码 也就一定需要类加载器 所以我们手动把类加载器传入
        ClassLoader cl = AppTest.class.getClassLoader();

        //第2个参数 class[]
        //我们已经知道 下面的代码 是用实例化一个对象的 实例化对象 就一定是实例化某一个类的对象
        //问题是 到底是哪个类呢
        //类在哪里？字节码又在哪里 ？这个类不在硬盘上 而是在内存中
        //是由动态代理在内存中动态生成的
        //动态在运行时产生字节码  动态生成的
        //要知道 这个内存中直接生成的字节码，会去实现下面方法2的第2个参数 所指定的接口
        //所以 利用动态代理生成的对象 就能转出Icalc接口类型 那么这个代理对象就有add sub mul div方法

        //第3个参数 InvocationHandler
        //我们已经知道 下面的对象proxy所属的类 实现了Icalc接口
        //我们就可以通过代理对象 调用 add sub mul div方法
        //注意每次对代理对象的任意方法的调用,都不会进入真正的实现方法 而是统统进入第3个参数的invoke方法
        ICalc proxy = (ICalc) Proxy.newProxyInstance(cl,new Class[]{ICalc.class},new MyHandle(c));

        proxy.add(2,3);
        proxy.sub(2,3);
        proxy.mul(2,3);
        proxy.div(2,3);

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

