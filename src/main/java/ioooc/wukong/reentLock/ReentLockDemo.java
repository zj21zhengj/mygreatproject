package ioooc.wukong.reentLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示ReentrantLock 打印字符串 保证完整性
 */
public class ReentLockDemo {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        OutPrint out = new OutPrint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.printStr("悟空");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.printStr("大师兄");
                }
            }
        }).start();

    }

    static class OutPrint {
        private Lock lock = new ReentrantLock();

        private void printStr(String name) {
            int lenth = name.length();
            lock.lock();
            try {
                for (int i = 0; i < lenth; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println("");
            } finally {
                lock.unlock();
            }
        }
    }


}
