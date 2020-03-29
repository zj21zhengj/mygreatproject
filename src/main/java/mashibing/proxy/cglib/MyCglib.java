package mashibing.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类似拦截器
 */
public class MyCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("方法执行之前");
        Object o = proxy.invokeSuper(obj,args);
        System.out.println("方法执行之后");
        return o;
    }
}
