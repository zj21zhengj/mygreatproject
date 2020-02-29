package ioooc.wukong.fulture;

import java.util.concurrent.*;

/**
 ** 方法一 是用 线程池的submit获取返回值
 *  * 方法二 是FutureTask
 *  FutureTask 同时是 Runnable 和 callable的 子类
 *  所以可以看成是 Runnable
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        Task task = new Task();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        //类似Runnable的用法
        /*Thread t = new Thread(integerFutureTask);
        t.start();*/

        ExecutorService service = Executors.newSingleThreadExecutor();
        //https://blog.csdn.net/mryang125/article/details/81879096
        //execute 和 submit的方法的区别如上图
        service.submit(integerFutureTask);
        try {
            System.out.println("结果是:" + integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算中");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
