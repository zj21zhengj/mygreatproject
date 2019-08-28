package com.liaoxuefeng.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppleDemo {
    private static List<Apple> appleStore = new ArrayList<>();

    static {
        appleStore.add(new Apple(1,"red",500,"湖南"));
        appleStore.add(new Apple(2,"red",400,"湖南"));
        appleStore.add(new Apple(3,"green",300,"湖南"));
        appleStore.add(new Apple(4,"green",200,"天津"));
        appleStore.add(new Apple(5,"green",100,"天津"));
    }

    public List getAppleByColor(){
        List list = new ArrayList();
        for(Apple apple:appleStore){
            if(apple.getColor().equals("red")){
                list.add(apple);
            }
        }
        return list;
    }

    //流式写法
    public List getAppleByColorForStream(){
        return appleStore.stream().filter(a->"red".equalsIgnoreCase(a.getColor()))
                .collect(Collectors.toList());
    }

    //流式写法
    public List getAppleByTrue(){
        return appleStore.stream().filter(a->true)
                .collect(Collectors.toList());
    }

    //统计 所有颜色的苹果的平均重量
    public void groupByColor() {
        Map<String, Double> collect = appleStore.stream()
                .collect(Collectors.groupingBy(a -> a.getColor(),
                        Collectors.averagingInt(a -> a.getWeight())));
        collect.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    /**
     * 验证不可重复使用
     * 中间操作是 惰性的 能有1次或者多次
     * 终值操作 只能有一次
     *
     * 返回新的stream 中间操作
     * 不返回的是     终值操作
     */
    @Test
    public void test(){
        Stream<Apple> stream = appleStore.stream();
        Stream<Apple> appleStream = stream.filter(a->true);
        //Stream<Apple> appleStream1 = stream.filter(a->true);
        Stream<Apple> appleStream1 = appleStream.filter(a->{
            System.out.println(a.getColor());
            return true;
        });
        //采集是终值操作
        appleStream1.collect(Collectors.toList());

    }

    //观察执行顺序
    //表明是 每一个扔进去执行
    @Test
    public void test2(){
        //解释
        Consumer<Apple> peek = a-> System.out.println(a.getColor());
        Predicate<Apple> filter = a->a.getColor().equalsIgnoreCase("red");
        Consumer<Apple> peek2 = a-> System.out.println(a.getOrigin());
        List list = new ArrayList();
        for(Apple apple2:appleStore){
            peek.accept(apple2);

            peek2.accept(apple2);
            list.add(apple2);
        }

        appleStore.stream()
                .peek(a-> System.out.println(a.getColor()))
                .peek(a-> System.out.println(a.getWeight()))
                .collect(Collectors.toList());
    }

    //stream采用多线程
    @Test
    public void test3(){
        appleStore.parallelStream().forEach(a->{
            System.out.println(Thread.currentThread().getName());
        });
    }

    public static void main(String[] args) {
        System.out.println(appleStore.size());
        List a = new AppleDemo().getAppleByColor();
        System.out.println(a.size());
        List b = new AppleDemo().getAppleByColorForStream();
        System.out.println(b.size());
        List cc = new AppleDemo().getAppleByTrue();
        System.out.println(cc.size());
        new AppleDemo().groupByColor();
    }
}
