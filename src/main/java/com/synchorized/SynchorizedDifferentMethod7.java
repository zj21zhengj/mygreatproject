package com.synchorized;

/**
 * 同时访问一个类的不同的普通同步方法
 *
 *  方法上加锁本质上锁的是this
 */
public class SynchorizedDifferentMethod7 implements Runnable {
    static SynchorizedDifferentMethod7 instance = new SynchorizedDifferentMethod7();

    @Override
    public void run() {
        if("Thread-0".equals(Thread.currentThread().getName())) {
            method1();
        } else {
            method2();
        }
    }

    private synchronized void method1() {
        System.out.println("我是加锁的方法1，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    private synchronized void method2() {
        System.out.println("我是加锁的方法2，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

}
