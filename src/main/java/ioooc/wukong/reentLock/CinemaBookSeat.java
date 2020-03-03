package ioooc.wukong.reentLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示电影院预订位子
 */
public class CinemaBookSeat {

    private static ReentrantLock lock = new ReentrantLock();

    private static void bookSeat() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + "开始预订位置");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "结束预订位置");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bookSeat();
                }
            }).start();
        }
    }
}
