package com.liaoxuefeng.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExample {
    public static void main(String[] args) throws IOException {
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\test\\test.zip"))){
            ZipEntry entry = null;
            while ((entry = zip.getNextEntry()) != null ) {
                String name = entry.getName();
                if(!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read())!= -1) {
                        System.out.println((char) n);
                    }
                }
            }
        }
    }
}
