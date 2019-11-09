package com.liaoxuefeng.io;

import java.io.*;

/**
 * 经过对比发现我最先的想法 读一个字节写一个字节很豪时间。还是评论写的好
 */
public class CopyFile2 {
    public static void main(String[] args) throws IOException {
        long a= System.currentTimeMillis();//获取当前系统时间(毫秒)
        OutputStream out = null;
        InputStream input = null;
        /*String source =args[0];
        String copy = args[1];*/
        try{
            input = new FileInputStream("src/a1.txt");
            byte[] data = new byte[1024*1024];
            int n;
            while ( (n = input.read(data)) != -1) {
                System.out.println("读入"+n+"字节");
            }
            out = new FileOutputStream("src/b2.txt");
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                input.close();
                out.close();
            }
        }
        System.out.print("程序执行时间为：");
        System.out.println(System.currentTimeMillis()-a+"毫秒");
    }
}
