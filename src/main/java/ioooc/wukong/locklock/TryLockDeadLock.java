package ioooc.wukong.locklock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock 会谦让 不会死锁
 * 线程2获取锁1失败后，会执行finally把获取到了的锁2释放掉
 * 以便线程1获取两把锁，程序执行完会执行finaaly
 * 注意没有finnally 就算代码走完也不会释放锁的
 */
public class TryLockDeadLock implements Runnable {

    int flag = 1;

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        TryLockDeadLock r1 = new TryLockDeadLock();
        TryLockDeadLock r2 = new TryLockDeadLock();
        r1.flag = 1;
        r2.flag = 2;
        new Thread(r1).start();
        new Thread(r2).start();
    }

    @Override
    public void run() {
        //获取锁失败会重试
        for (int i = 1; i < 100; i++) {
            if (flag == 1) {
                try {
                    if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("线程1获取到了锁1");
                            Thread.sleep(new Random().nextInt(1000));

                            if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("线程1获取到了锁2");
                                    System.out.println("线程1成功获取到了2把锁");
                                    //Thread.sleep(new Random().nextInt(1000));
                                    break;
                                } finally {
                                    lock2.unlock();
                                    System.out.println("break后也会执行。。。");
                                    Thread.sleep(new Random().nextInt(1000));
                                }
                            } else {
                                System.out.println("线程1获取锁2失败,已重试");
                            }
                        } finally {
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程1获取锁1失败,已重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (flag == 2) {
                try {
                    if (lock2.tryLock(3000, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("线程2获取到了锁2");
                            Thread.sleep(new Random().nextInt(1000));

                            if (lock1.tryLock(3000, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("线程2获取到了锁1");
                                    System.out.println("线程2成功获取到了2把锁");
                                    //Thread.sleep(new Random().nextInt(1000));
                                    break;
                                } finally {
                                    lock1.unlock();
                                    Thread.sleep(new Random().nextInt(1000));
                                }
                            } else {
                                System.out.println("线程2获取锁1失败,已重试");
                            }
                        } finally {
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程2获取锁2失败,已重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
