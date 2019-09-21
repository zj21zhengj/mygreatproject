package com.liaoxuefeng.javalearnning;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOLearn {
    public static void main(String[] args) throws IOException {
        //readFile();
        readFileByte();
    }

    public static void readFile() throws IOException {
        try(InputStream input = new FileInputStream("src/readme.txt")) {
            int n;
            while ((n = input.read()) != -1){
                System.out.println(n);
            }
        }
    }

    public static void readFileByte() throws IOException {
        try(InputStream input = new FileInputStream("src/readme.txt")) {
            byte[] buffer = new byte[100];
            int n;
            while ((n = input.read(buffer)) != -1){ //读取到缓冲区域
                System.out.println("read "+n+" byte");
            }
        }
    }
}
