package ioooc.wukong.flowcontrol;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 演示Condition的基本用法
 *
 * 自己出题  线程1 输出 A B C
 *          线程2 输出 1 2 3  交替输出
 *
 *          conditon = lock.newConditon
 *          conditon.await()
 *          condtton.singal()
 */
public class ConditionDemo1 {



    public static void main(String[] args) {
         Lock lock = new ReentrantLock();

        char[] a1 = "123456789".toCharArray();
        char[] a2 = "ABCDEFGHI".toCharArray();

        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() ->{
            lock.lock();
            try {
                for(char s:a1) {
                    System.out.println(s);
                    c2.signal();
                    c1.await();
                }
                //不加这句jvm退不出
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(() ->{
            lock.lock();
            try {
                for(char s:a2) {
                    System.out.println(s);
                    c1.signal();
                    c2.await();
                }
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t2").start();
    }

}
