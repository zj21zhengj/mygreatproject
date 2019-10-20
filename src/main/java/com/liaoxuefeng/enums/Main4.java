package com.liaoxuefeng.enums;

public class Main4 {
    public static void main(String[] args) {
        Weekday4 day = Weekday4.SUN;
        switch(day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday4 {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}
