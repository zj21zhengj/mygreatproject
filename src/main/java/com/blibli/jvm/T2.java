package com.blibli.jvm;


/**
 *
 * jmm 代码验证
 *
 * voliate的原理 https://www.dazhuanlan.com/2020/01/04/5e103ba1e8c8d/
 *
 * volatile实现可见性原理
 * 1.修改volatile变量时会强制将修改后的值刷新到主内存中。
 * 2.修改volatile变量后会导致其他线程工作内存中对应的变量值失效。也就是其他线程要使用volatile变量时都要先从主内存刷新一次。
 * 上述也是volatile变量与普通变量的区别。
 */
class MyNumber{
    int myNumber = 10;

    public void addTo1026(){
        this.myNumber = 1026;
    }
}


/**
 * JMM 线程可见性 (通知机制)
 */
public class T2 {
    public static void main(String[] args) {
        MyNumber my = new MyNumber();
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //改变是在线程的变量副本来完成的
            my.addTo1026();
            //此时已写回了主内存的共享变量，证据是下面的读是从主内在到工作内存的吧
            //这里有疑问此时读的是主内存吗 https://bbs.csdn.net/topics/392413466
            //感觉还是工作内存啊，不然下面while 为什么就是工作内存呢  上面类的注释 voliate的实现原理好像证明了我的疑惑
            //https://www.bilibili.com/video/av70166821/?p=36&t=13 11：18 说是写回去了啊
            System.out.println(Thread.currentThread().getName()+" update numbeer,result is "+my.myNumber);

        },"AAAA").start();

        /**需要有一种通知机制到main线程，number已经修改为1026
        线程间的通信必须通过中介 主内存来实现
        此时主内存已经改变，但是main线程的拷贝还是旧的
         **/
        while (my.myNumber == 10) {

        }
        System.out.println("主线程结束了");
    }
}
