package com.liaoxuefeng.regex;

/**
 * java字符串用\\表示\
 */
public class RegexAbout {
    public static void main(String[] args) {
        String regx = "20\\d\\d";
        System.out.println("2019".matches(regx)); //true
        System.out.println("2210".matches(regx));
    }
}
