package ioooc.wukong.synchorized;

/**
 * 同时访问加锁和不加锁的方法
 */
public class SynchronizdYesAndNo6 implements Runnable{
    static SynchronizdYesAndNo6 instance = new SynchronizdYesAndNo6();

    @Override
    public void run() {
        if("Thread-0".equals(Thread.currentThread().getName())) {
            method1();
        } else {
            method2();
        }
    }

    private synchronized void method1() {
        System.out.println("我是加锁的方法，我是"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    private void method2() {
        System.out.println("我是没加锁的方法，我是"+Thread.currentThread().getName());
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
