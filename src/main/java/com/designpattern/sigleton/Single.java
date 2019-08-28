package com.designpattern.sigleton;

public class Single {
    private Single(){System.out.println("11111111111111");};

    private final static Single instance = new Single();

    public static Single getInstance(){
        return instance;
    }
}
