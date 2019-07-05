package com.liaoxuefeng.javalearnning;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.scale());
    }
}
