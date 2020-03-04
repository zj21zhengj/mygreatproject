package ioooc.wukong.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 只能降级不能升级，升级会死锁
 */
public class Upgrading {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);

    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void readUpgrading() {
        System.out.println(Thread.currentThread().getName()+"尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到了读锁，正在读取");
            try {
                Thread.sleep(40);
                System.out.println("不能升级会造成堵塞");
                writeLock.lock();
                System.out.println("成功升级获取了写锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"-释放了读锁");
            readLock.unlock();
        }
    }

    private static void writeDowngrading() {
        System.out.println(Thread.currentThread().getName()+"尝试获取读锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到了写锁，正在写");
            Thread.sleep(40);
            readLock.lock();
            System.out.println("成功降级级获取了读锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"-释放了写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->writeDowngrading(),"thread1");
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(()->readUpgrading(),"thread2");
        thread2.start();
    }
}
