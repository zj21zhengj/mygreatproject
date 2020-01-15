package com.blibli.jvm;

import java.util.ArrayList;
import java.util.List;

public class JvmDemo {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getClassLoader());
        System.out.println("**********************");
        JvmDemo jvmDemo = new JvmDemo();
        System.out.println(jvmDemo.getClass().getClassLoader());
        System.out.println(jvmDemo.getClass().getClassLoader().getParent());
        System.out.println(jvmDemo.getClass().getClassLoader().getParent().getParent());

        System.out.println("#######################################################################");
        System.out.println(Runtime.getRuntime().availableProcessors());

        long maxMemory = Runtime.getRuntime().maxMemory(); //返回Java虚拟机内存中的最大值
        long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机内存中的总量

        //vm配置  -Xmx1024m -Xms1024m -XX:+PrintGC
        System.out.println("-Xmx:MAX_MEMORY = "+maxMemory+"(字节)、"+(maxMemory/(double)1024/1024)+"MB、"+(maxMemory/(double)1024/1024/1024)+"G");
        System.out.println("-Xms:TOTAL_MEMORY = "+totalMemory+"(字节)、"+(totalMemory/(double)1024/1024)+"MB、"+(totalMemory/(double)1024/1024/1024)+"G");

        byte[] ms = new byte[40*1024*1024];
    }
}
