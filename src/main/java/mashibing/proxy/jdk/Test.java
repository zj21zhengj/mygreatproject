package mashibing.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * 静态代理  写一个实现类  编译成字节码 加载到内存中 运行
 *
 * 动态代理  运行期间 jdk帮我们实现一个类，创建class字节码并加载的过程
 */
public class Test {
    public static void main(String[] args) {
        //查看jdk生产的类
        System.getProperties().put("sum.misc.ProxyGenerator.saveGeneratedFiless","true");
        System.out.println("$Proxy0.class全名: "+ Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class));
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());
        System.out.println(proxy.add(1,3));
        System.out.println(proxy.getClass());
    }
}
