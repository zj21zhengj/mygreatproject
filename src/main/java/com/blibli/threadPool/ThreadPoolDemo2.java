package com.blibli.threadPool;

import java.util.concurrent.*;

/**
 * 线程池的优势
 *    线程复用，控制最大并发数，管理线程
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                //Runtime.getRuntime().availableProcessors() + 1
                5,
                2L,
                TimeUnit.SECONDS,
                //等待处理数
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                //拒绝策略
                //https://blog.csdn.net/u014131617/article/details/91127413 4种拒绝策略
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        try {
            //模拟有10个顾客过来办理业务，目前池子里有5个工作人员提供服务
            for(int i=1;i<=20;i++){
                //暂停几秒种线程
                //TimeUnit.SECONDS.sleep(1);
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
