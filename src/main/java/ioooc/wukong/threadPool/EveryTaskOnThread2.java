package ioooc.wukong.threadPool;

/**
 * 当class写在public里时必须声明为static
 */
public class EveryTaskOnThread2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("任务开始2");
        }
    }
}
