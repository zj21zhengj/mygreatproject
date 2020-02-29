package ioooc.wukong.fulture;

import java.util.Random;
import java.util.concurrent.*;

public class OneFutureLambda {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        //lambad写法
        Callable<Integer> call = () ->{
            Thread.sleep(300);
            return new Random().nextInt();
        };
        Future<Integer> future = service.submit(call);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

}
