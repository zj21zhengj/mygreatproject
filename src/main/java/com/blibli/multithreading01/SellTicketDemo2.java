package com.blibli.multithreading01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ReentrantLock 和 synchronized 都是可重入锁
 */
public class SellTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 ta = new Ticket2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ta.sell();
                }
            }
        },"A0").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ta.sell();
                }
            }
        },"A1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ta.sell();
                }
            }
        },"A2").start();

    }
}


class Ticket2 {
    private int nums = 30;

    Lock lock = new ReentrantLock();

    public void sell() {
        lock.lock();
        try {
            if (nums > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (nums--) + "张票，还剩" + (nums) + "张");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}