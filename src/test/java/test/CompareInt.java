package test;

/**
 * Integer常量池是 -128 - 127，如果先等于 Integer = 10,在new一个
 * 就会指向常量池 == 就有效，否则无效
 */
public class CompareInt {
    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        Integer c = 10;
        Integer d = 10;
        Integer e = 130;
        Integer f = 130;
        int e1 = 130;
        int f1 = 130;
        int i1 = 11;
        Integer i2 = new Integer(11);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(e1 == f1);
        System.out.println(i1 == i2);
    }
}
