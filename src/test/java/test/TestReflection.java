package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 思考下程序运行中如何读取配置文件，new 1个类
 * java反射可以程序运行时动态的加载类
 */
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = "test.T"; //这是读取后的；(完整的报名)
        Class c = Class.forName(str); //这就加载进内存了
        Object o =c.newInstance();
        Method[] methods = c.getMethods();
        for(Method m:methods) {
            if(m.getName().equals("mm")){
                m.invoke(o);
            }
            if(m.getName().equals("m1")) {
                m.invoke(o,1,2);
                for(Class paramType:m.getParameterTypes()) {
                    System.out.println(paramType.getName());
                }
            }
            if(m.getName().equals("getS")){
                Class returnType = m.getReturnType();
                System.out.println(returnType.getName());
            }
        }
    }

}

class T{
    //查看是否加载进内存
    static {
        System.out.println("T loaded!");
    }
    int i;
    String m;
    public void m1(int i,int j) {
        this.i = i+j;
        System.out.println(this.i);
    }

    public void mm() {
        System.out.println("m invoked");
    }

    public String getS(){
        return "a";
    }

}
