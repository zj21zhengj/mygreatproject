package com.datelife;

import java.io.File;

public class FileNameChange {
    public static void main(String[] args) {
        String path = "H:\\学习2\\高并发";
        File file = new File(path);
        File[] fileList = file.listFiles();
        for(File f:fileList) {
            if(f.isFile()) {
                String filename= f.getName().replaceAll("0001.哔哩哔哩-【上篇】玩转java并发工具-精通JUC并发工具十八般武艺-","");
                System.out.println(filename);
                f.renameTo(new File(filename));
                //System.out.println(f.getName());
            }
        }
    }
}
