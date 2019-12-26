package com.blibli.multithreading01;

/**
 * 有 A B C 三个售票员卖30张票的 原始方法
 *
 *
 * 高耦合低内聚的前提下   线程   操作   资源类
 *
 * start 并不是马上启动线程 而是就绪。
 * 线程启动是靠操作系统和cpu调度的
 */
public class SellTicketDemo1 {
    public static void main(String[] args) {
        MyThread runner = new MyThread();
        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);
        Thread t3 = new Thread(runner);
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
        //Thread.State
    }
}

//回顾synchronized 用法
class Ticket {
    private int tickets = 30;

    public synchronized void sell() {
        if(tickets > 0) {
            System.out.println(Thread.currentThread().getName() +"卖出了第"+ (tickets--) + "张票，还剩" + (tickets) + "张");
        }
    }
}

class MyThread implements Runnable {
    Ticket ticket = new Ticket();
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            ticket.sell();
        }
    }
}
