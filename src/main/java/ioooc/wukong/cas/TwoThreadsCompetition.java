package ioooc.wukong.cas;

/**
 * 模拟CAS操作 等价代码
 *
 * 应用场景 乐观锁  比如数据库里修改的时候可以用版本号的方式，而不是锁住整张表
 *
 * 并发容器 couurrntHashMap
 *
 * 原子类 Unsafe类是CAS的核心，Unsafe中的compareAndSwpInt 先拿到变量的内存地址 再实现原子性的比较和替换  c++写的
 *
 * CAS的缺点
 * ABA问题 就是说比较的值可能是修改过的只是结果和修改前一样而已。解决方法 类似数据库那样弄个版本号
 *自旋时间过长 do while
 */
public class TwoThreadsCompetition implements Runnable {
    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue,int newValue) {
        int oldValue = value;
        if(oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }

    @Override
    public void run() {
        compareAndSwap(0,1);
    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadsCompetition r = new TwoThreadsCompetition();
        r.value = 0;
        Thread t1 = new Thread(r,"thread1");
        Thread t2 = new Thread(r,"thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }


}
