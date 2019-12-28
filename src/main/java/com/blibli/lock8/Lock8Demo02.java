package com.blibli.lock8;


import java.util.concurrent.TimeUnit;


/**
 * G:\Learning\mygreatproject\src\main\java\com\synchorized\SynchronizedClassClass5.java
 *
 * 探索类锁的其他写法
 */
class PhonePro {

    public void sendEmail() throws InterruptedException {
        synchronized (PhonePro.class) {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("******发送Email");
        }
    }

    public  synchronized void sendSMS(){
        synchronized (PhonePro.class) {
            System.out.println("*******发送短信");
        }
    }

    public void sayHello(){
        System.out.println(" hello ");
    }
}


/**
 */
public class Lock8Demo02{
    public static void main(String[] args) throws InterruptedException {

            PhonePro phone1 = new PhonePro();
            PhonePro phone2 = new PhonePro();

            new Thread(()->{
                try {
                    phone1.sendEmail();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"A").start();

            //保证A线程先执行
            Thread.sleep(100);

            new Thread(()->{
                phone2.sendSMS();
        },"B").start();

    }
}
