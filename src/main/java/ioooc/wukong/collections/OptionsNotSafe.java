package ioooc.wukong.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 是线程安全的吗？
 * 当然是 但是线程不安全是因为一系列操作
 * Integer socre = scores.get("小明");
 *             Integer newSocre = socre+1;
 *             scores.put("小明",newSocre);
 *
 * 结果最终不是20000 是因为ConcurrentHashMap 只能保证get 和 put是安全的
 * 但是 socre+1 是无法保证的，不是ConcurrentHashMap 的锅
 *
 * 当然可以用 synchroized保证线程安全，但是不符合这个类的思想
 *
 * 应该用组合的操作
 * replace 如果替换成功
 *
 */
public class OptionsNotSafe implements Runnable {

    private static ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        scores.put("小明", 0);
        OptionsNotSafe op = new OptionsNotSafe();
        Thread t1 = new Thread(op);
        Thread t2 = new Thread(op);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最后的成绩:" + scores.get("小明"));
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            while (true) {
                Integer socre = scores.get("小明");
                //newSocre只会少的 当t1加了1后,t2闯进来还是以为是0 内存不可见，
                Integer newSocre = socre + 1;
                boolean b = scores.replace("小明",socre,newSocre);
                if(b) {
                    break;
                }
            }
        }
    }
}
