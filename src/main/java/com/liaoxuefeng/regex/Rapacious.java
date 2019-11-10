package com.liaoxuefeng.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达默认贪婪匹配 什么是贪婪呢
 * 比如
 * "123000"：3个0
 * "10100"：2个0
 * "1001"：0个0
 * 想和非0后分组 用\\d+ 就会匹配整个我们需要 它总是尽可能多地向后匹配
 * 这时需要非0匹配
 */
public class Rapacious {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d+)(0*)");
        Matcher m = p.matcher("123000");
        if(m.matches()){
            System.out.println("group1=" + m.group(1)); // "1230000"
            System.out.println("group2=" + m.group(2)); // ""
        }

        Pattern p1 = Pattern.compile("(\\d+?)(0*)");
        Matcher m1 = p1.matcher("123000");
        if(m1.matches()){
            System.out.println("group1=" + m1.group(1)); // "1230000"
            System.out.println("group2=" + m1.group(2)); // ""
        }
    }
}
