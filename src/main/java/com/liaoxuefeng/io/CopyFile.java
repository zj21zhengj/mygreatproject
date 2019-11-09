package com.liaoxuefeng.io;

import java.io.*;

/**
 * 练习 可以通过args 给类文件传递参数  仔细分析应该是读入的时候Io操作耗时，因为写入会自带缓冲区的
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        long a= System.currentTimeMillis();//获取当前系统时间(毫秒)
        OutputStream out = null;/*
        String source =args[0];
        String copy = args[1];*/
        try(InputStream input = new FileInputStream("src/a1.txt")){
            out = new FileOutputStream("src/b1.txt");
            int n;
            while ((n = input.read()) !=-1) {
                out.write(n);
            }
        }
        System.out.print("程序执行时间为：");
        System.out.println(System.currentTimeMillis()-a+"毫秒");
    }
}
