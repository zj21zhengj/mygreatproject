package ioooc.wukong.threadPool;

import java.util.concurrent.*;

/**
 * 线程池大小为5 最大池为10  队列为100
 *
 * 请求最多会创建5个。然后任务被添加到队列中，直到达到100 当队列已满时，将创建最新的线程
 * maxPoolSize 最多到10个线程，如果再来任务 就拒绝
 *
 * 线程池最好是手动创建
 * 自动创建就是调用jdk的函数
 *  demo1
 *
 *
 */

public class FixedThreadPoolTest {
    public static void main(String[] args) {
        //这个队列是 LinkedBlockingQueue 是无边界的，有oom的风险
        /*ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Ftask());
        }*/
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        //3秒后执行的线程池
        executor.schedule(new Ftask(),3L, TimeUnit.SECONDS);
    }
}

class Ftask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
