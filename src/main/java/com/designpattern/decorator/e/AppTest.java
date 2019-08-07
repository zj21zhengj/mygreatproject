package com.designpattern.decorator.e;

import java.io.*;

/**
 * jdk的流 是装饰器的一种应用
 *
 * InputStream是装饰器模式 是饮料
 *
 * FileterInputStream 是调料 继承饮料 又关联饮料
 */
public class AppTest {
    public static void main(String[] args) throws Exception {

        InputStream in = new FileInputStream("F:\\ReadMe.txt");
        //缓冲区 类似家里的垃圾桶，避免每次都要出去扔垃圾
        BufferedInputStream ris = new BufferedInputStream(in);
        InputStreamReader is = new InputStreamReader(ris,"utf-8");

        ris.close();
    }
}
