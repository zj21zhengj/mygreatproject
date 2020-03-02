package ioooc.wukong.locklock;

/**
 * 想起了马士兵的思考题模拟一个死锁
 *  不睡的话执行太快 死不了
 */
public class DeadLockDemo {

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread t1 is running");
                    synchronized (o1) {
                        Thread.sleep(1000);
                        System.out.println("t1 拿到了锁1");
                        synchronized (o2) {
                            System.out.println("t1 拿到了锁2");
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread t2 is running");
                    synchronized (o2) {
                        System.out.println("t2 拿到了锁2");
                        Thread.sleep(1000);
                        synchronized (o1) {
                            System.out.println("t2 拿到了锁1");
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
