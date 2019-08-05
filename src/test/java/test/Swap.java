package test;

/**
 * 交换 主要是测debug
 */
public class Swap {
    public static void main(String[] args) {
        int a = 6;
        int b = 5;
        swap(a,b);
        System.out.println("a="+a+",b="+b);
    }

    private static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
}
