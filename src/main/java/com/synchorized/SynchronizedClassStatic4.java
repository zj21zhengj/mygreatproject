package com.synchorized;

/**
 * 类锁的第一种形式 static方法
 *
 * 注意要造两个不同的类，不然和 3一样了
 *
 * ps 发现synchronized加 static前后都可以
 */
public class SynchronizedClassStatic4 implements Runnable {
    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    @Override
    public void run() {
        method();
    }

    private static synchronized void method() {
        System.out.println("我是类锁的第一种形式：satic方法形式。我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
