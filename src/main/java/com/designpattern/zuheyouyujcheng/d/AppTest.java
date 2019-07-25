package com.designpattern.zuheyouyujcheng.d;


//父类的addAll本身会调用add，所以不需要重新addAll
// 正对c包中的问题
// 1 我们不再写add addAll
// 2 我们重写add addAll方法  如add2 addAll2() 并且写文档

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

//改进办法 不再调父类的addAll
class MySet extends HashSet {

    private int count = 0;

    @Override
    public boolean add(Object e) {
        count++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection c){
        boolean bb = false;
        for(Object obj:c){
            if(add(c)){
                bb = true;
            }
        }
        return bb;
    }


    public int getCount(){
        return count;
    }

}

//还是有问题 //问题是 要求太多了，看文档并遵守   更致命的问题是 在新版本中hashSet恰恰多了个add2那就糟糕了

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