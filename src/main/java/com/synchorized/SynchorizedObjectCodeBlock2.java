package com.synchorized;

public class SynchorizedObjectCodeBlock2 implements Runnable {
    Object lock1 = new Object();

    static SynchorizedObjectCodeBlock2 instance = new SynchorizedObjectCodeBlock2();

    @Override
    public void run() {
        synchronized (lock1) { //也可以用this
            System.out.println("我是Thread我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("end");
    }
}
