package interview;

import java.util.concurrent.CompletableFuture;

/**
 * jdk5 之前因为没有非阻塞的方法 所以引入了google的guava的包
 * jdk8 抄了guava到官方包了
 * <p>
 * 阿里面试题
 * 三个方法 一个方法异常，整个方法失败
 * <p>
 * 可以归结为分布式事务失败回滚的手工实现
 */
public class T02_AllQuestionAboutCf {
    public static void main(String[] args) {

        MyTask task1 = new MyTask("task1", 4, true);
        MyTask task2 = new MyTask("task2", 3, true);
        MyTask task3 = new MyTask("task3", 1, false);

        long a1 = System.currentTimeMillis();
        CompletableFuture f1 = CompletableFuture.supplyAsync(() -> task1.call())
                .thenAccept((result) -> callable(result));
        CompletableFuture f2 = CompletableFuture.supplyAsync(() -> task2.call())
                .thenAccept((result) -> callable(result));
        CompletableFuture f3 = CompletableFuture.supplyAsync(() -> task3.call())
                .thenAccept((result) -> callable(result));

        long a2 = System.currentTimeMillis();
        System.out.println(a2 - a1);
    }

    private static void callable(Boolean result) {
        if (false == result) {
            System.exit(0);
        }
    }


    private static class MyTask {

        private String name;
        private int timeInSeconds;
        private boolean ret;

        public MyTask(String name, int timeInSeconds, boolean ret) {
            this.name = name;
            this.timeInSeconds = timeInSeconds;
            this.ret = ret;
        }

        public Boolean call() {
            try {
                Thread.sleep(timeInSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "callback");
            return ret;
        }
    }
}
