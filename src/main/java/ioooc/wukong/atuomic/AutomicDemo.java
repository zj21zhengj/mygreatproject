package ioooc.wukong.atuomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示AtomicInteger的基本用法，对比非原子类的线程安全问题，使用了原子类后，
 * 不需要加锁，也可以保证线程安全
 */
public class AutomicDemo implements Runnable {

    //有可见性，没有原子性
    private static volatile Integer basicConut = 0;

    private static AtomicInteger atomicInteger = new AtomicInteger();


    public void incrementBasic() {
        basicConut++;
    }

    public void incrementAtomic() {
        atomicInteger.getAndIncrement();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementBasic();
            incrementAtomic();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AutomicDemo r = new AutomicDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("原子类的结果的值是"+atomicInteger.get());
        System.out.println("普通变量的值是" + basicConut);
    }
}
