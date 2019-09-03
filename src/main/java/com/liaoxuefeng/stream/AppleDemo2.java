package com.liaoxuefeng.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppleDemo2 {
    private static List<Apple> appleStore = new ArrayList<>();

    static {
        appleStore.add(new Apple(1,"red",500,"湖南"));
        appleStore.add(new Apple(2,"red",400,"湖南"));
        appleStore.add(new Apple(3,"green",300,"湖南"));
        appleStore.add(new Apple(4,"green",200,"天津"));
        appleStore.add(new Apple(5,"green",100,"天津"));
    }

    public static void main(String[] args) {
        System.out.println(appleStore.size());
        List<Apple> al = appleStore.stream().filter(a->a.getColor().equals("red")).collect(Collectors.toList());
        System.out.println(al.size());
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Apple> apples = Arrays.asList(new Apple(1,"red",500,"湖南"),
                        new Apple(2,"red",400,"湖南"));
        //sorted用法 https://www.cnblogs.com/woyaobianfei/p/9187127.html
        List<Apple> strem2 = appleStore.stream().sorted(Comparator.comparing(Apple::getWeight).reversed()).collect(Collectors.toList());
        System.out.println("**********************");
        System.out.println(strem2);
    }
}
