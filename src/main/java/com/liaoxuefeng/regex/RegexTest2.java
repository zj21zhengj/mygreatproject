package com.liaoxuefeng.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 看到group想到那时做的日期，可以用group啊
 */
public class RegexTest2 {
    public static void main(String[] args) {
        String s1 = " 2019-10-30 - 2019-11-31 ";
        String ss = s1.replaceAll(" ","");
        System.out.println(ss);
        String d1 = ss.substring(0,10);
        String d2 = ss.substring(11,21);
        System.out.println(d1);
        System.out.println(d2);

        Pattern p = Pattern.compile("(\\d{4}\\-\\d{2}\\-\\d{2})\\-(\\d{4}\\-\\d{2}\\-\\d{2})");
        Matcher m = p.matcher(ss);
        if(m.matches()){
            String ds1 = m.group(1);
            String ds2 = m.group(2);
            System.out.println(ds1);
            System.out.println(ds2);
        } else {
            System.out.println("failed");
        }
    }
}
