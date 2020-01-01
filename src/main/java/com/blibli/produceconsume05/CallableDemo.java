package com.blibli.produceconsume05;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 实现多线程的4种方法
 * 1 继承thread方法
 * 2.实现runnable接口
 * 3.实现callable接口
 * 4.线程池
 */
class MyThread implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println("**********come to call");
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        new Thread(futureTask,"A").start();

        Integer result = futureTask.get();
    }

}
