package com.mashibing.cocurrent.aqs.s02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.5之前的synchronized jvm底层需要和 os 打交道，切换太耗时间了
 * 1.6之后进行了优化 不在是重锁
 * 所以创造了很多其他的锁，  ReentrantLock 更灵活
 */
public class Main {

    public static int m = 0;

    public static Lock lock = new ReentrantLock(); //实现类似的功能，但是底层是aqs

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try{
                    lock.lock();
                    for (int j = 0; j < 100; j++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        m++;
                    }
                }finally {
                    lock.unlock();
                }
            });
        }

        for (Thread t : threads) t.start();

        for (Thread t : threads) t.join(); //等所有线程运行结束，再来打印m的值

        System.out.println(m);
    }
}
