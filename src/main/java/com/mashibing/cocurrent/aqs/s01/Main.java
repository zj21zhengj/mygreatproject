package com.mashibing.cocurrent.aqs.s01;


/**
 * 结果不是10000 的原因
 * 每个线程没加完时，其他线程进入， 比如加到99 ，线程2也进去加，结果返回时，结果2的结果覆盖了1
 * 所以最后不是200可能是199或者198等等  。。
 * 要想得到正确结果得加锁
 * 锁是加在类上的，一个线程得到锁后，代码运行完，开锁，其他线程才能拿到这个锁
 *
 */
public class Main {

    public static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

  /*      for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                    synchronized (Main.class) {
                        for (int j = 0; j < 100; j++) {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            m++;
                        }
                    }
            });
        }*/

        for (Thread t : threads) t.start();

        for (Thread t : threads) t.join(); //等所有线程运行结束，再来打印m的值

        System.out.println(m);
    }
}
