package ioooc.wukong.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启用1000个任务时，使用线程池，否则太消耗资源了
 *
 * 更好的解决方案是使用ThreadLocal
 * 给每个线程都分配属于自己的dateFomat对象，这样既保证了线程安全，又搞笑利用了内存，同时也不用排队了
 *
 */
public class ThreadLocalUsage04 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(()-> System.out.println(new ThreadLocalUsage04().getDate(finalI)));
        }
        executorService.shutdown();
    }

    private String getDate(int sends) {
        //从 1970.1.1 00:00:00 开始GM
        Date date = new Date(1000 * sends);
        //SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String s = ThreadSafeFormat.dateFormatThreadLocal2.get().format(date);
        return s;
    }
}

class ThreadSafeFormat {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        }
    };

    //lambda写法
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal2 = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("YYYY-MM-dd hh:mm:ss"));
}
