package ioooc.wukong.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个线程执行 simpleDate
 */
public class ThreadLocalUsage00 {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(new ThreadLocalUsage00().getDate(10))).start();
        new Thread(() -> System.out.println(new ThreadLocalUsage00().getDate(1000))).start();
    }

    private String getDate(int sends) {
        //从 1970.1.1 00:00:00 开始GM
        Date date = new Date(1000 * sends);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String s = dateFormat.format(date);
        return s;
    }
}
