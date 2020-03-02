package ioooc.wukong.locklock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock不会像Synchronized一样，异常的时候自动释放锁
 * 所以最佳实践是 finnaly中释放锁 以便保证发生异常的时候锁一定被释放
 */

public class MustUnLock {

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            //获取本地锁保护的资源
            System.out.println(Thread.currentThread().getName()+"开始执行任务");
        }finally {
            lock.unlock();
        }
    }
}
