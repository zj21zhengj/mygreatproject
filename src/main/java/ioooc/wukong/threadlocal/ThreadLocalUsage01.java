package ioooc.wukong.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 启用10个线程
 *
 */
public class ThreadLocalUsage01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(() -> System.out.println(new ThreadLocalUsage01().getDate(finalI))).start();
        }
    }

    private String getDate(int sends) {
        //从 1970.1.1 00:00:00 开始GM
        Date date = new Date(1000 * sends);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String s = dateFormat.format(date);
        return s;
    }
}
