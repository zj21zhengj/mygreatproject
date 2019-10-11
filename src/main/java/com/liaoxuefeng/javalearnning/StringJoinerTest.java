package com.liaoxuefeng.javalearnning;

import java.util.StringJoiner;

/**
 * 好处是不用像 StringBuilder那样处理最后一个,
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ");
        for(String name:names) {
            sj.add(name);
        }
        StringJoiner sj2 = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj2.add(name);
        }
        System.out.println(sj.toString());
        System.out.println(sj2.toString());
    }
}
