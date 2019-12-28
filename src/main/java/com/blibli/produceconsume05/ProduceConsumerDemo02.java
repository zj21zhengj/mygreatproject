package com.blibli.produceconsume05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * lock的等待和唤醒
 * 也会用相应的新的方法来实现
 */
class Aircondition02 {

    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition notFull  = lock.newCondition();

    public void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                notFull.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "  " + num);
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {

        lock.lock();
        try {
            while (num == 0) {
                notFull.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "  " + num);
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
    }
}


public class ProduceConsumerDemo02 {
    public static void main(String[] args) {
        Aircondition02 arit = new Aircondition02();
        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    arit.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    arit.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    arit.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();


        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    arit.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
