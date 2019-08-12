package com.synchorized;

public class SynchronizedRecurison10 {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecurison10 synchronizedRecurison10 = new SynchronizedRecurison10();
        synchronizedRecurison10.method1();
    }

    private synchronized void method1() {
        System.out.printf("这是method1,a="+a);
        if(a == 0) {
            a++;
            method1();
        }
    }
}
