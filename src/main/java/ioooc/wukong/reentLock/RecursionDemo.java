package ioooc.wukong.reentLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Recurisondemo
 */
public class RecursionDemo {

    public static void main(String[] args) {
        recursion();
    }

    private static ReentrantLock lock = new ReentrantLock();

    private static void recursion() {
        System.out.println("资源已经处理");
        lock.lock();
        try {
            if(lock.getHoldCount() < 5) {
                System.out.println(lock.getHoldCount());
                recursion();
                System.out.println(lock.getHoldCount());
            }
        }finally {
            lock.unlock();
        }
    }
}
