package ioooc.wukong.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  这个例子证明了读写策略
 *
 *  读锁是可以插队的，只要队列中的头节点不是写锁就有机率插队
 *
 *  这个例子中输出尝试 就是在队列中排队
 *  改为公平锁就会发现尝试的 就是下一个获取的，而非公平锁则有插队现象
 */
public class NonfairBargeDemo {

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);

    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void read() {
        System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        //证明队列头2是写锁时 读不能插队
        new Thread(() -> write(), "thread1").start();
        new Thread(() -> read(), "thread2").start();
        new Thread(() -> read(), "thread3").start();
        new Thread(() -> write(), "thread4").start();
        new Thread(() -> read(), "thread4").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread[] threads = new Thread[1000];
                for (int i = 0; i < 1000; i++) {
                    threads[i] = new Thread(() -> read(), "子线程创建的thread" + i);
                }
                for (int i = 0; i < 1000; i++) {
                    threads[i].start();
                }
            }
        }).start();
    }
}
