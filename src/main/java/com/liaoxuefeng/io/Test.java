package com.liaoxuefeng.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自己默写次
 */
public class Test {
    public static void main(String[] args) throws IOException {
        try(InputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test\\e.txt")) {
            String res = readAsString(input);
            System.out.println(res);
        }
    }

    private static String readAsString(InputStream input) throws IOException {
        StringBuilder s = new StringBuilder();
        int n;
        while ( (n = input.read()) != -1) {
            s.append((char) n);
        }
        String res = s.toString();
        return res;
    }
}
