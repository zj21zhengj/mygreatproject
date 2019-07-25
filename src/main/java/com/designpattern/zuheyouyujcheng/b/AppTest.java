package com.designpattern.zuheyouyujcheng.b;

//需求 制作一个集合 要求该集合能记录增经加过多少个元素 不是统计某一时刻集合中有多少个元素

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


//父类的addAll本身会调用add，所以不需要重新addAll
//反正 父类的addAll本省就会回调add
class MySet extends HashSet {

    private int count = 0;

    @Override
    public boolean add(Object e) {
        count++;
        return super.add(e);
    }


    public int getCount(){
        return count;
    }

}

//看起来已经满足了，还是有问题的

//目前的代码 必须依赖1个事实 Hashset 的addAll 必须回调 add

//万一再将来的jdk版本中，HashSet的addALL实现代码中 突然不再调add方法了，我们自定义的Set被撼动？


public class AppTest {
    public static void main(String[] args) {
        MySet set = new MySet();
        Set set2 = new HashSet();
        set2.add("net");
        set2.add("n33");
        set2.add("n44");
        set.addAll(set2);
        System.out.println(set.getCount());
    }

}
