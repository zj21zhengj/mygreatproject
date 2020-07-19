package interview;

import com.itranswarp.learnjava.RedirectServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * jdk5 之前因为没有非阻塞的方法 所以引入了google的guava的包
 * jdk8 抄了guava到官方包了
 * <p>
 * 阿里面试题
 * 三个方法 一个方法异常，整个方法失败
 * <p>
 * 可以归结为分布式事务失败回滚的手工实现
 */
public class T03_AllQuestionAboutCf {
    static enum Result {
        SUCCESS, FAIL, CANCELED;
    }

    static List<MyTask> tasks = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        MyTask task1 = new MyTask("task1", 4, Result.SUCCESS);
        MyTask task2 = new MyTask("task2", 3, Result.SUCCESS);
        MyTask task3 = new MyTask("task3", 1, Result.FAIL);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        for(MyTask task:tasks) {
            CompletableFuture f = CompletableFuture.supplyAsync(() -> task.runTask())
                    .thenAccept((result -> callable(result,task)));
        }

        System.in.read();
    }

    private static void callable(Result result,MyTask myTask) {
        if (Result.FAIL == result) {
            for(MyTask _task:tasks) {
                if(_task != myTask) {
                    _task.cancel();
                }
            }
         }
    }


    private static class MyTask {

        private String name;
        private int timeInSeconds;
        private Result ret;

        boolean cancelling = false;
        volatile boolean canceled = false;

        public MyTask(String name, int timeInSeconds, Result ret) {
            this.name = name;
            this.timeInSeconds = timeInSeconds * 1000;
            this.ret = ret;
        }

        public Result runTask() {
            int interval = 100;
            int total = 0;
            try {
                for (; ; ) {
                    Thread.sleep(interval);
                    total += interval;
                    if (total >= timeInSeconds) break;
                    if (canceled) return Result.CANCELED;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "end!");
            return ret;
        }

        public void cancel() {
            cancelling = true;
            synchronized (this) {
                System.out.println(name + "canceling");
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + "canceled");
            }
            canceled = true;
        }
    }
}
