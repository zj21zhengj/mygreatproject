package com.liaoxuefeng.io;

import java.io.*;

public class Output1 {
    public static void main(String[] args) throws IOException {
        writeFile2();
    }

    public static void writeFile() throws IOException {
        OutputStream output = new FileOutputStream("src/readme1.txt");
        output.write(72); // H
        output.write(101); // e
        output.write(108); // l
        output.write(108); // l
        output.write(111); // o
        output.close();
    }

    public static void writeFile2() throws IOException {
        try (OutputStream output = new FileOutputStream("src/readme.txt")) {
            output.write("Hello!!!".getBytes("UTF-8")); // Hello
        } // 编译器在此自动为我们写入finally并调用close()
    }
}
