package com.liaoxuefeng.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAbout {
    public static void main(String[] args) {
        // 获取当前时间:
        Date date = new Date();
        System.out.println(date.getYear() + 1900); // 必须加上1900
        System.out.println(date.getMonth() + 1); // 0~11，必须加上1
        System.out.println(date.getDate()); // 1~31，不能加1
        // 转换为String:
        System.out.println(date.toString());
        //SimpleDateFormat sdf = new SimpleDateFormat("Y-M-d");
        //System.out.println(sdf.format(date));
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(sdf.format(date));
    }
}
