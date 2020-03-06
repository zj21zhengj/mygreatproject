package ioooc.wukong.atuomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 把普通变量升级为原子变量
 * 适合偶尔需要原子的 时候 因为都是原子变量对资源消耗很大
 */
public class AutomicIntegerFieldUpdaterDemo implements Runnable{

    static Candidate tom;
    static Candidate peter;

    //可见运用了反射
    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");

    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            tom.score++;
            //原子加操作
            scoreUpdater.getAndIncrement(peter);
        }
    }

    public static class Candidate{
        volatile int score;

    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();
        AutomicIntegerFieldUpdaterDemo r = new AutomicIntegerFieldUpdaterDemo();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("普通变量的结果:"+tom.score);
        System.out.println("原子升级后的结果:"+peter.score);
    }


}
