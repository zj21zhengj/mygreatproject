package ioooc.wukong.fulture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MultiFuture {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Future> futureLists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = service.submit(new FultureTask());
            futureLists.add(future);
        }
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = futureLists.get(i);
            try {
                //为什么同时输出4个呢
                //因为get方法是阻塞的，当等待3秒时由于是4个线程同时处理，后面的也完成了
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    static class FultureTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
