package com.blibli.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的优势
 *    线程复用，控制最大并发数，管理线程
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {

        //一池5个工作线程，类似一个银行有5个受理窗口
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池1个工作线程，类似一个银行有1个受理窗口
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一池n个工作线程，类似一个银行有n个受理窗口
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            //模拟有10个顾客过来办理业务，目前池子里有5个工作人员提供服务
            for(int i=1;i<=10;i++){
                //暂停几秒种线程
               // TimeUnit.SECONDS.sleep(1);
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
