package com.liaoxuefeng.javalearnning;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOLearn2 {
    public static void main(String[] args) throws IOException {
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        }
    }
}
