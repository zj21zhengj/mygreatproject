package com.designpattern.dependencyinversion;

/**
 * 线程题目 一个线程打印 1-52 ，1个线程打印 a-z,让后输出 12A23B...5152Z
 * 这是线程通信问题，一问道线程通信就要想到 notify 和 wait
 * 线程通信必须要有一个共享对象 以共享对象为锁
 *  如果只有1个runnable，runnable作为共享对象，超出1个，其他作为共享对象 （https://www.cnblogs.com/lcngu/p/5150024.html）
 *    java每个对象都有个锁
 *
 *  发生关联关系，就是1个类的对象作为另外1个类的字段
 *
 *  这样会有一定概率字母先输出
 *
 */

class Foo{
    public int x;
    public Foo(){
        this.x = 1;
    }
}

class T implements Runnable{

    private Foo foo;

    public T(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        synchronized (foo) {
            for (int i = 1; i <= 53; i++) {
                while(foo.x != 1) {
                    try {
                        foo.notifyAll();
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(i<=52)
                System.out.println(i);
                if(i %2 == 0) {
                    foo.x = 2;
                }
            }
        }
    }
}

class S implements Runnable {

    private Foo foo;

    public S(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        synchronized (foo) {
            for (int i = 'A'; i <='Z'; i++) {
                while (foo.x != 2) { //while防止虚假唤醒
                    try {
                        foo.notifyAll();
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println((char) i);
                foo.x = 1;
            }
        }
    }
}



public class Test {
    public static void main(String[] args) {
        Foo foo = new Foo();
        T t = new T(foo);
        S s = new S(foo);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
    }
}
