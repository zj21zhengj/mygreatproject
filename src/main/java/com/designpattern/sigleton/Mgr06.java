package com.designpattern.sigleton;

public class Mgr06 {

    //volatite作用 1线程间可见 2防止指令重排
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //双重检查  是有必要的，但是太复杂了
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
