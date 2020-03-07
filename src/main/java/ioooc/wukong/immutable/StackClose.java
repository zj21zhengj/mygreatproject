package ioooc.wukong.immutable;

/**
 * 方法内的变量 多个线程之间是不共享的 属于栈内保护的 ，栈空间是不会被其他线程访问到的
 * 如果在inThread 加synchronized是不必要的，编译器也会帮我们优化掉
 */
public class StackClose implements Runnable{

    private int count = 0;

    private void inThread() {
        int inside = 0;
        for (int i=0;i<10000;i++){
            inside++;
        }
        System.out.println(Thread.currentThread().getName()+"数量是:"+inside);
    }

    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            count++;
        }
        inThread();
    }

    public static void main(String[] args) throws InterruptedException {
        StackClose r1 = new StackClose();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r1.count);
    }
}
