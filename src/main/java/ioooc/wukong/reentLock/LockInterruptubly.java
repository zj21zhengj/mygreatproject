package ioooc.wukong.reentLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 当lockInteruptubly 是指中断锁
 */
public class LockInterruptubly implements Runnable {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptubly lockInterruptubly = new LockInterruptubly();
        Thread thread0 = new Thread(lockInterruptubly);
        Thread thread1 = new Thread(lockInterruptubly);
        thread0.start();
        thread1.start();
        thread0.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        try {

            lock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "获取到了锁");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "获得锁期间被中断了");
        }
    }
}
