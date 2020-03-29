package mashibing.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CalculatorProxy {

    public static Calculator getProxy(final Calculator calculator) {
        //获取类加载器
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        //获取要实现的接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();

        InvocationHandler b = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法开始执行");
                Object result = method.invoke(calculator,args);
                System.out.println("方法执行完毕");
                return result;
            }
        };
        Object o = Proxy.newProxyInstance(classLoader,interfaces,b);
        return (Calculator) o;
    }
}
