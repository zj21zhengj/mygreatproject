package ioooc.wukong.reentLock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock(false);//参数true为公平锁，可以看输出


    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r1);
        th1.start();
        th2.start();
    }

}
