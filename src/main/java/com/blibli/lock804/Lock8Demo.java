package com.blibli.lock804;


import java.util.concurrent.TimeUnit;


/**
 * 这里比喻非常形象
 * synchronized 比喻成手机的内部功能
 * 普通方法可以比喻成  从电器等
 */
class Phone {

    public static synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("******发送Email");
    }

    public synchronized void sendSMS(){
        System.out.println("*******发送短信");
    }

    public void sayHello(){
        System.out.println(" hello ");
    }
}


/**
 * 1.标准访问 请问先打印email还是短信 （不是同步方法，并且不确保email先执行，则是cpu 否则是email)
 * 2.加同步 暂挺4秒在邮件方法中，看先打印邮件还是先打印短信  email
 * 普通 synchronized 修饰方法 和 synchronized （this) {} 锁的是当前对象 或者说实例
 * 3.新增普通sayHello方法 请问先打印邮件还是 hello    hello
 * 4.两部手机请问是 先打印邮件还是短信   sms 因为是锁的是两个不同的对象
 * 5.两个静态同步方法 同一部手机 请问是先打印邮件还是短信     email static锁的是Class对象
 * 6.两个静态同步方法  两部部手机 请问是先打印邮件还是短信  email 同上
 * 7. 1个静态同步方法 1个普通同步方法 同一部手机 请问先打印邮件还是短信  sms 因为是两把锁 锁地方不一样
 * 8. 1个静态同步方法 1个普通同步方法 2部手机 请问先打印邮件还是短信    sms 同上
 * this当前对象锁 class全局锁  小米工厂锁了不影响我使用小米手机
 *
 * 锁的是当前对象this  被锁定后 其他线程都不能进入当前对象的其他的synchronized方法
 * 加个普通方法后发现和同步锁无关
 * 换成两个对象后 不是同一把锁了 情况发生改变
 * 对于普通方法 锁是当前实例对象 锁的是当前对象的this
 * 对于同步方法块 锁是synchonized括号里配置的对象
 * 对于静态同步方法 锁是当前Class对象
 */
public class Lock8Demo {
    public static void main(String[] args) throws InterruptedException {

            Phone phone1 = new Phone();
            Phone phone2 = new Phone();

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
                //phone1.sendSMS();
                // phone1.sayHello();
                phone2.sendSMS();
        },"B").start();

    }
}
