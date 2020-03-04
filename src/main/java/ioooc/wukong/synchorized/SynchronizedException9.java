package ioooc.wukong.synchorized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 方法抛出异常后 展示抛出异常前和抛出异常后
 *
 *  synchronizd会释放，lock不会
 */
public class SynchronizedException9 implements Runnable {
    static SynchronizedException9 instance = new SynchronizedException9();
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        if("Thread-0".equals(Thread.currentThread().getName())) {
            method1();
        } else {
            method2();
        }
    }

    private  void method1() {
        lock.lock();
        System.out.println("我是加锁的方法1，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            //throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
        //System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    private  void method2() {
        lock.lock();
        System.out.println("我是加锁的方法2，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }

}
