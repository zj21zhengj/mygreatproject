package ioooc.wukong.threadPool;

/**
 * 实现多线程的4种方法
 */
public class EveryTaskOnThread {
    public static void main(String[] args) {
        Thread t = new Task();
        t.start();
    }
}

class Task extends Thread{
    @Override
    public void run(){
        System.out.println("任务开始");
   }
}