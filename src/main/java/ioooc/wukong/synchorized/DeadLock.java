package ioooc.wukong.synchorized;

/**
 * 死锁的例子  锁中套锁 很容易死锁
 */
public class DeadLock {
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        t1.start();
        t2.start();

    }

}


class A implements Runnable{

    @Override
    public void run() {
        synchronized (DeadLock.o1) {
            System.out.println("获得锁1");
            synchronized (DeadLock.o2) {
                System.out.println("获得锁2");
                System.out.println("成功");
            }
        }
    }
}

class B implements Runnable{

    @Override
    public void run() {
        synchronized (DeadLock.o2) {
            System.out.println("获得锁2");
            synchronized (DeadLock.o1) {
                System.out.println("获得锁1");
                System.out.println("成功");
            }
        }
    }
}
