package com.liaoxuefeng.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * regetx练习  提前时分秒
 * \:代码转义 （）代表分组
 */
public class RegexTest3 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{2})\\:(\\d{2})\\:(\\d{2})");
        String s  = "23:01:59";
        Matcher m = p.matcher(s);
        if(m.matches()){
            String s1 = m.group(1);
            String s2 = m.group(2);
            String s3 = m.group(3);
            System.out.println(s1+" "+s2+" "+s3);
        }else{
            System.out.println("失败");
        }
    }
}
