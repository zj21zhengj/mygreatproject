package ioooc.wukong.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启用1000个任务时，使用线程池，否则太消耗资源了
 * 由于 simpleDateFormat 要new 1000次，消耗资源，设为static
 * 此时发现有重复，原因是这个format类是线程不安全的，所以要加锁
 *
 * 缺点是 加锁要排队，在高并发情况下效率低
 */
public class ThreadLocalUsage03 {

    static SimpleDateFormat dateFormat1 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(()-> System.out.println(new ThreadLocalUsage03().getDate(finalI)));
        }
        executorService.shutdown();
    }

    private String getDate(int sends) {
        //从 1970.1.1 00:00:00 开始GM
        Date date = new Date(1000 * sends);
        String s;
        synchronized (ThreadLocalUsage03.class){
            s = dateFormat1.format(date);
        }
        return s;
    }
}
