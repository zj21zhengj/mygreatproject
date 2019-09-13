package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        String my = "2019-09-09";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String d3 = df.format(d1);
        String d4 = d3+" 00:00:00";
        System.out.println(d3);
        Date d2 = df.parse(my);
        Date d5 = df.parse(d4);
        compareDate(d2,d5);
    }

    /**
     * @param date1
     * @param date2
     * @Author: wangxer
     * @Description: 方式一 用Date的before，after方法
     * @Date: Created in 11:35 on 2017/9/30.
     */
    public static void compareDate(Date date1, Date date2) {
        if (date1.before(date2)) {
            System.out.println(date1 + "在" + date2 + "前面");
        } else if (date1.after(date2)) {
            System.out.println(date1 + "在" + date2 + "后面");
        } else {
            System.out.println("是同一天的同一时间");
        }
    }
}
