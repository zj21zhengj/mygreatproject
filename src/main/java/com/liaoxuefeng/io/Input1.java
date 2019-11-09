package com.liaoxuefeng.io;

import java.io.File;
import java.io.IOException;

public class Input1 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Administrator\\Desktop\\test\\a.txt");
        System.out.println(f);
        System.out.println(f.exists()+"");
        File f1 = new File("C:\\Windows");
        File f2 = new File("C:\\Windows\\notepad.exe");
        File f3 = new File("C:\\Windows\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
        File file = new File("C:\\Users\\Administrator\\Desktop\\test\\c.txt");
        if (file.createNewFile()) {
            // 文件创建成功:
            // TODO:
            /*if (file.delete()) {
                // 删除文件成功:
            }*/
        }

        File ff = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        ff.deleteOnExit(); // JVM退出时自动删除
        System.out.println(ff.isFile());
        System.out.println(ff.getAbsolutePath());
    }
}
