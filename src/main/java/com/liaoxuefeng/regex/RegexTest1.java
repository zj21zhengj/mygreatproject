package com.liaoxuefeng.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegexTest1 {
    public static void main(String[] args) throws Exception {
        String re = "\\d{3,4}-\\d{7,8}";
        String[] a1 = {"010-12345678", "020-9999999", "0755-7654321"};
        List<String> s1 = new ArrayList<>(Arrays.asList(a1));
        String[] a2 = {"010 12345678", "A20-9999999", "0755-7654.321"};
        List<String> s2 = new ArrayList<>(Arrays.asList(a2));
        for (String s : s1) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : s2) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}

