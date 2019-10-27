package com.liaoxuefeng.javalearnning;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 这个时候就可以非常清楚的发现，在整个程序编写中，即使
 * 完全不知道类的结构，即使不导入包类，也可以对类对象实例化操作
 *
 * 但是如果使用反射实例化对象，必须要求类中存在无参构造方法，因为默认使用
 * class类的newInstance()方法只能够找到无参
 *
 * 正是因为通过构造方法实例化对象规格不统一，所以在进行简单java操作必须有无参构造方法
 *
 * 记住有Declare是本类的方法或者属性
 */
class Student{
    private String name;
    private Integer age;
    public Student(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(){
        System.out.println("Student的构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void fun(){}
    void run(){}
}


public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.liaoxuefeng.javalearnning.Student");
        //相当于关键字new实例化对象 等价 Object s = new Student()
        Object obj = cls.newInstance();
        System.out.println(obj);
        //获取类中的所有构造方法
        Constructor<?>[] cons = cls.getConstructors();
        for(int x=0;x<cons.length;x++){
            System.out.println(cons[x]);
        }
        Constructor<?> cont = cls.getConstructor(String.class,Integer.class);
        Object objs = cont.newInstance("Smith",29);
        System.out.println(objs);

        /**
         * 取得类中的所有方法
         *  取得父类继承的方法
         *      取得全部方法   getMethod
         *      取得指定方法
         *  取得本类定义的方法
         *      取得全部方法  getDeclareMethod
         *      取得指定方法
         *
         */
        Method met[] = cls.getMethods();
        for(int x=0;x<met.length;x++){
            //这里得到的数字  modifter转为字符串
            System.out.print(Modifier.toString(met[x].getModifiers())+"  ,");
            System.out.print(met[x].getReturnType()+" ");
            System.out.print(met[x].getName());
            System.out.println();//换行
            Class<?>[] params = met[x].getParameterTypes();
            for(int y=0;y<params.length;y++){
                System.out.print(params[y].getSimpleName()+"arg-"+y+"--");
            }
        }
        System.out.println("----------------------------------------------------------------");
        Method setNameMethod = cls.getMethod("setName", String.class);
        Method getNameMethod = cls.getMethod("getName");
        setNameMethod.invoke(obj,"SMITH"); //对象.setName("SMITH")
        System.out.println(obj.getClass());
        System.out.println(getNameMethod.invoke(obj));
    }
}
