package com.unclear;

public class Mypow {
    private int myPow(int x,int y) {
        if(x == 1) {
            return 1;
        }
        else if( x == 0) {
            return 0;
        }
        if(y == 0) {
            return 1;
        }
        if(y == 1) {
            return x;
        }
        int res = x*myPow(x,y-1);
        return res;
    }

    public static void main(String[] args) {
        int c = new Mypow().myPow(2,8);
        System.out.println(c);
    }
}
