package com.liaoxuefeng.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 模板引擎其实就是用类似的正则表达进行替换
 */
public class RegexAbout4 {
    public static void main(String[] args) {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        //，而是反复调用find()方法，在整个串中搜索能匹配上\\wo\\w规则的子串，并打印出来
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }

        String sa = "the quick brown fox jumps over the lazy dog.";
        String r = sa.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }
}
