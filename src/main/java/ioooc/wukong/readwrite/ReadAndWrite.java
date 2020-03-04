package ioooc.wukong.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读时能同时读，写时不能同时写
 * 相当于读时是可重入锁，
 *
 * 读锁和写锁是同一把
 * 比如 1 2线程在读取 。3线程想写入只能等待 当4还想读时 如果没有读写策略是可以插队的
 */
public class ReadAndWrite {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);

    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void read() {
        System.out.println(Thread.currentThread().getName()+"尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"-得到了读锁，正在读取");
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            System.out.println(Thread.currentThread().getName()+"-释放了读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        System.out.println(Thread.currentThread().getName()+"尝试获取写锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"-得到了写锁，正在写");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"-释放了写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        //证明队列头2是写锁时 读不能插队
        new Thread(()->write(),"t0").start();
        new Thread(()->read(),"t1").start();
        new Thread(()->read(),"t2").start();
        new Thread(()->write(),"t3").start();
        new Thread(()->read(),"t4").start();
        new Thread(()->read(),"t5").start();
    }
}
