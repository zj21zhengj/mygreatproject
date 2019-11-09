package com.liaoxuefeng.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Input2 {
    public static void main(String[] args) throws IOException {
        readFile();
        System.out.println("***************");
        readFile2();
    }

    //注意java项目里用 / 不区分正反面,  \\windows  /linux
    public static void readFile() throws IOException {
        try(InputStream input = new FileInputStream("src/readme.txt")){
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        }
    }
    //缓冲
    public static void readFile2() throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}
