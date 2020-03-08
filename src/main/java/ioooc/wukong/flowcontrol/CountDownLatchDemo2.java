package ioooc.wukong.flowcontrol;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);

        for(int i=0;i<5;i++) {
            final int j = i+1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("No." + j + "，准备完毕，等待发令枪");
                    try {
                        start.await();
                        System.out.println("No." + j + "，开始跑步");
                        Thread.sleep(new Random().nextInt(10000));
                        System.out.println("No." + j + "，跑到终点了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            service.submit(runnable);
        }

        Thread.sleep(5000);
        start.countDown();
        System.out.println("发令枪响");
        end.await();
        System.out.println("比赛结束");
        service.shutdown();
    }
}
