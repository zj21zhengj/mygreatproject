package ioooc.wukong.fulture;

import java.util.Random;
import java.util.concurrent.*;

public class OneFuture {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        //ctrl alt + v 快捷键
        Future<Integer> future = service.submit(new FultureTask());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    static class FultureTask implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt();
        }
    }
}
