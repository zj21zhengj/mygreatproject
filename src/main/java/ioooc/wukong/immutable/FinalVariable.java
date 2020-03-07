package ioooc.wukong.immutable;

public class FinalVariable {
    static String f = "Wukong2";
    public static void main(String[] args) {
        String a = "Wukong2";
        //如果final b是 方法返回的，则编译器也不知道了，结果是false
        final String b = "Wukong";
        String c = b+2;
        //final修饰的字符串看成常量  编译器自动指向常量池中已有的a所指的内容
        System.out.println(a == c);
        String d = "WuKong";
        String e = d+2;
        //否则在堆内存中产生
        System.out.println(a == e);
        //static变量也是在常量池中的
        System.out.println(a == f);

    }
}
