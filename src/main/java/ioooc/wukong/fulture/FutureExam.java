package ioooc.wukong.fulture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 用刚学完的future 复习 马士兵视频多线程的判断宿舍
 *
 */
public class FutureExam {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> alList = getPrime(1,200000);
        System.out.println("num1:"+alList.size());
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        long start2 = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(4);
        MyTask t1 = new MyTask(1,80000);
        MyTask t2 = new MyTask(80001,140000);
        MyTask t3 = new MyTask(140001,180000);
        MyTask t4 = new MyTask(180001,200000);
        Future<List<Integer>> l1 = service.submit(t1);
        Future<List<Integer>> l2 = service.submit(t2);
        Future<List<Integer>> l3 = service.submit(t3);
        Future<List<Integer>> l4 = service.submit(t4);
        try {
            int a = l1.get().size();
            int b = l2.get().size();
            int c = l3.get().size();
            int d = l4.get().size();
            int e = a+b+c+d;
            System.out.println("num2:"+e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private static List<Integer> getPrime(int start, int end) {
        List<Integer> re = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) re.add(i);
        }
        return re;
    }

    static class MyTask implements Callable<List<Integer>> {

        private int start;
        private int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> lists = getPrime(start,end);
            return lists;
        }
    }
}

