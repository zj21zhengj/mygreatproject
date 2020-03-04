package ioooc.wukong.synchorized;

/**
 * 可重入性验证 不是同一方法
 */
public class SynchronizedOtherMerhod11 {

    public synchronized void method1(){
        System.out.println("我是method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMerhod11 s = new SynchronizedOtherMerhod11();
        s.method1();
    }
}
