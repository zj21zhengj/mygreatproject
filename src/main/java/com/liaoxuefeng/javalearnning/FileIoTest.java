package com.liaoxuefeng.javalearnning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileIoTest {
    public static void main(String[] args) throws IOException {
        new FileIoTest().readFile();
    }

    public void readFile() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("E:\\learnspace\\mygreatproject\\src\\main\\resources\\readme.txt");
            int n;
            while ((n = input.read())!= -1){
                System.out.println((char)n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(input != null ){
                input.close();
            }
        }
    }
}
