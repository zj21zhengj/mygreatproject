package ioooc.wukong.threadPool;

/**
 * 反复线程创建和销毁 开销很大，占内存，并且会给jvm垃圾回收带来压力
 *
 * 线程池的好处
 *      加快响应速度
 *      合理利用cpu和内存
 *      统一管理
 * tomcat等服务器就是用线程池实现的
 */
public class ForLoop {
    public static void main(String[] args) {
        for(int i=0;i<=10;i++) {
            Thread t3 = new Thread(new Task());
            t3.start();
        }
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("任务开始3");
        }
    }
}
