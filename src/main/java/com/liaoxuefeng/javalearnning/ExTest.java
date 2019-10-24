package com.liaoxuefeng.javalearnning;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ExTest {
    public static void main(String[] args) throws Exception {
        byte[] bs = null;
        try{
             bs = toGBK("中文");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex);
        }finally {
            System.out.println(22);
        }
        System.out.println(11);
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) throws Exception {
        // 用指定编码转换String为byte[]:
        int b = 1/0;
        return s.getBytes("GBK");
    }
}
