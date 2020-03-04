package ioooc.wukong.synchorized;

/**
 * 锁是不一样 一个是.class，一个是this
 * 所以不是同步的
 */
public class SynchorizedStaticAndNormal8 implements Runnable {
    static SynchorizedStaticAndNormal8 instance = new SynchorizedStaticAndNormal8();

    @Override
    public void run() {
        if("Thread-0".equals(Thread.currentThread().getName())) {
            method1();
        } else {
            method2();
        }
    }

    private synchronized static void method1() {
        System.out.println("我是静态加锁的方法1，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    private synchronized void method2() {
        System.out.println("我是非静态加锁的方法2，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }



}
