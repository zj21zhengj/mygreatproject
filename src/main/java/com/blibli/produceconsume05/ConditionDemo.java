package com.blibli.produceconsume05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 需求是 三个线程 A打印5次 B打印10次 C打印15次 按顺序打印
 *
 * 重复10次
 *
 * notifyall 没法精确唤醒
 *
 */
class ShareData {
    //标志为
    private int number = 1; //A 1 B 2 C3
    private Lock lock2 = new ReentrantLock();
    //同一把锁配三个要是
    private Condition c1  = lock2.newCondition();
    private Condition c2  = lock2.newCondition();
    private Condition c3  = lock2.newCondition();

    public void print5() {
        lock2.lock();
        try{
            //1 判断
            while (number != 1) {
                //wait
                c1.await();
            }
            //2 干活
            for(int i=1;i<=5;i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    public void print10(){
        lock2.lock();
        try{
            //1 判断
            while (number != 2) {
                //wait
                c2.await();
            }
            //2 干活
            for(int i=1;i<=10;i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }
    }

    public void print15() {
        lock2.lock();
        try{
            //1 判断
            while (number != 3) {
                //wait
                c3.await();
            }
            //2 干活
            for(int i=1;i<=15;i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
        }

    }
}


public class ConditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{for(int i=1;i<=10;i++) shareData.print5(); },"A").start();

        new Thread(()->{for(int i=1;i<=10;i++)  shareData.print10(); },"B").start();

        new Thread(()->{for(int i=1;i<=10;i++) shareData.print15(); },"C").start();
    }
}
