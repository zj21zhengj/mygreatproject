package ioooc.wukong.fulture.immoc;

import ioooc.wukong.fulture.immoc.computable.Computable;
import ioooc.wukong.fulture.immoc.computable.ExpensiveFunction;
import ioooc.wukong.fulture.immoc.computable.MayFail;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 异常情况处理
 * 用 while (true) 保证重试
 */
public class ImoocCache7<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public ImoocCache7(Computable<A,V> c) {
        this.c = c;
    }


    @Override
    public  V computer(A arg) throws InterruptedException, ExecutionException {
        System.out.println("进入缓存机制");
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> callable = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.computer(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(callable);
                //一直错误是因为缓存污染问题 第一次是错误f的值就一直是错误的
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    System.out.println("从FutureTask调用了计算函数");
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (InterruptedException e) {
                System.out.println("被中端");
                cache.remove(arg);
                throw e;
            }catch (ExecutionException e) {
                System.out.println("计算错误需要重试");
                cache.remove(arg);
            }

        }
    }

    public static void main(String[] args) throws Exception {
        ImoocCache7<String,Integer> com2 = new ImoocCache7(new MayFail());
        long start = System.currentTimeMillis();
        new Thread(()->{
            Integer result = null;
            try {
                result = com2.computer("55");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第一次计算结果："+result);
        }).start();
        new Thread(()->{
            Integer result = null;
            try {
                result = com2.computer("66");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第二次计算结果："+result);
        }).start();
        new Thread(()->{
            Integer result = null;
            try {
                result = com2.computer("55");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第三次计算结果："+result);
        }).start();/*
        //取消
        Future<Integer> future = com2.cache.get("66");
        future.cancel(true);*/
    }

}
