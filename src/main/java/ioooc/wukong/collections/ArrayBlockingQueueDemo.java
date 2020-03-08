package ioooc.wukong.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 有10个面试者 只有三个后座位置 有1个面试官 每个面试3秒
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        Inteviewer r = new Inteviewer(queue);
        Consumer c = new Consumer(queue);
        new Thread(r).start();
        new Thread(c).start();

    }
}

/**
 * 生产者
 */
class Inteviewer implements Runnable {

    private BlockingQueue<String> queue;

    public Inteviewer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("10个候选人都来啦");
        for (int i = 0; i < 10; i++) {
            String candidate = "candidate" + (i + 1);
            try {
                queue.put(candidate);
                System.out.println("安排好了" + candidate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            queue.put("stop");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String msg;
        try {
            while (!(msg = queue.take()).equals("stop")) {
                System.out.println(msg + "到了");
                Thread.sleep(3000);
            }
            System.out.println("所有候选人结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}