package test;


import java.io.*;

class SimpleIn {
    public static void main(String[] args) throws Exception{

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(keyboard.readLine());
    }

}