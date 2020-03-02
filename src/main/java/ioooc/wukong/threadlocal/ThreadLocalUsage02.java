package ioooc.wukong.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启用1000个任务时，使用线程池，否则太消耗资源了
 */
public class ThreadLocalUsage02 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(()-> System.out.println(new ThreadLocalUsage02().getDate(finalI)));
        }
        executorService.shutdown();
    }

    private String getDate(int sends) {
        //从 1970.1.1 00:00:00 开始GM
        Date date = new Date(1000 * sends);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String s = dateFormat.format(date);
        return s;
    }
}
