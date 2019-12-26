package com.blibli.multithreading01;

public class SellTicketDemo3 {
    public static void main(String[] args) {
        Ticket3 tc = new Ticket3();
        new Thread(()->{for(int i=0;i<40;i++){tc.sell();}},"AA").start();
        new Thread(()->{for(int i=0;i<40;i++){tc.sell();}},"AB").start();
        new Thread(()->{for(int i=0;i<40;i++){tc.sell();}},"AC").start();
    }
}


class Ticket3 {
    private int tickets = 30;
    Object lock1 = new Object();
    public void sell() {
        synchronized (lock1) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (tickets--) + "张票，还剩" + (tickets) + "张");
            }
        }
    }
}
