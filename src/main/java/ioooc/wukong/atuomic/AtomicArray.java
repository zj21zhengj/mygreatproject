package ioooc.wukong.atuomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicArray {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);

        Increments incrementr = new Increments(atomicIntegerArray);
        Decrements decrements = new Decrements(atomicIntegerArray);
        Thread[] incrementsThread = new Thread[100];
        Thread[] decrementsThread = new Thread[100];
        for(int i=0;i<100;i++) {
            incrementsThread[i] = new Thread(incrementr);
            decrementsThread[i] = new Thread(decrements);
            incrementsThread[i].start();
            decrementsThread[i].start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicIntegerArray);
    }
}


class Increments implements Runnable{

    private AtomicIntegerArray array;

    public Increments(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for(int i=0;i<array.length();i++){
            //此处i代表了数组的下标
            array.incrementAndGet(i);
        }
    }
}


class Decrements implements Runnable{

    private AtomicIntegerArray array;

    public Decrements(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for(int i=0;i<array.length();i++){
            array.decrementAndGet(1);
        }
    }
}
