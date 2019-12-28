package com.blibli.produceconsume05;

class Aircondition {

    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"  "+num);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"  "+num);
        this.notifyAll();
    }
}


/**
 * 现在两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1 一个线程对该变量减1
 * 实现交替 来10轮 变量初始值为0
 * <p>
 * 1 高聚低合前提下，线程操作资源类
 * 2 判断 干活 通知
 * 3 防止虚假唤醒  (用while判断）
 * 虚假唤醒指的是 当if判断时 当前线程停在if条件里，会唤醒里面的线程，绕过判断，只有用while拉出去重新判断
 * 好比一旦下飞机就要重新过安检 用多个线程更容易出现
 */

public class ProduceConsumerDemo {
    public static void main(String[] args) {
        Aircondition arit = new Aircondition();
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
