package ioooc.wukong.atuomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * 演示longAccmulator的用法
 * 适用的场景 不要求执行顺序
 */
public class LongAccmulatorDemo {
    public static void main(String[] args) {
        //LongAccumulator accumulator = new LongAccumulator((x,y) -> x+y,0);
        LongAccumulator accumulator = new LongAccumulator((x,y) -> Math.max(x,y),0);
        ExecutorService service = Executors.newFixedThreadPool(8);
        //intStram 包括1不包括10
        IntStream.range(1,10).forEach(i -> service.submit(() -> accumulator.accumulate(i)));
        service.shutdown();
        while (!service.isTerminated()){

        }
        System.out.println(accumulator.getThenReset());

    }

}
