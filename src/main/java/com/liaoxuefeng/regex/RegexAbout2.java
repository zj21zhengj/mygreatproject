package com.liaoxuefeng.regex;

public class RegexAbout2 {
    public static void main(String[] args) {
        String re1 = "abc";
        System.out.println("abc".matches(re1));
        System.out.println("Abc".matches(re1));
        System.out.println("abcd".matches(re1));

        String re2 = "a\\&c"; // 对应的正则是a\&c
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));

        //精确匹配实际上用处不大，因为我们直接用String.equals()就可以做到。大多数情况下，我们想要的匹配规则更多的是模糊匹配。
        System.out.println("***********************************************");
        String re3 = "java\\d"; //对应的是正则 java\d
        System.out.println("java9".matches(re3));
        System.out.println("java".matches(re3));
        System.out.println("java10".matches(re3));
        String re4 = "java\\D"; //对应的是 java\D
        System.out.println("java#".matches(re4));
        System.out.println("java9".matches(re4));
    }
}
