package ioooc.wukong.atuomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * Adder累加器是 java8后引入的
 * 高并发下LongAdder 比 AtomicLong效率高，不过本质是空间换时间
 * 利用率多段锁的概念
 * 为什么AtomicLong性能慢呢
 * 由于JMM ，AtomicLong每一次加法都有 flush和refresh 把自己线程里的内存变量刷新到主内存中
 * 而LongAdder是各算各的
 * <p>
 * 演示LongAdder 比 AtomicLong性能好
 *
 * LongAdder适用于统计求和 没有cas方法
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();
        ExecutorService service = Executors.newFixedThreadPool(20);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.submit(new Task(counter));
        }
        service.shutdown();
        //检查是否任务执行完毕
        while (!service.isTerminated()) {

        }
        Long end = System.currentTimeMillis();
        System.out.println(counter.sum());
        System.out.println("耗时"+(end-start));
    }

    private static class Task implements Runnable {
        private LongAdder counter;

        public Task(LongAdder counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }
}
