package com.designpattern.sigleton;

public class Mgr06 {

    //volatite作用 1线程间可见 2防止指令重排  这里是防止指令重排 马士兵公开课美团面试有讲
    //到，这里是因为会指向半初始化的原因
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //双重检查  是有必要的，但是太复杂了 也叫dcl  double check lock
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
