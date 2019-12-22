package com.liaoxuefeng.enums;

public class Main {
    public static void main(String[] args) {
        WeekDay day = WeekDay.SUM;
        if (day == WeekDay.SAT || day == WeekDay.SUM) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}


enum WeekDay{
    SUM,MON, TUE, WED, THU, FRI, SAT;
}
