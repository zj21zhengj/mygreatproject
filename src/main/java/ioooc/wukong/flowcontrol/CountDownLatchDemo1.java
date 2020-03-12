package ioooc.wukong.flowcontrol;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 一个线程等待多个线程都执行完毕，再继续自己的工作
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            int j = i + 1;
            Runnable runable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random()*1000));
                        System.out.println("No" + j + "完成了检查");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //完成后减1
                        latch.countDown();
                    }
                }
            };
            executor.submit(runable);
        }
        System.out.println("等待5人检查完...");
        try {
            latch.await();
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人都工作完进入下一个环节");

    }

}
