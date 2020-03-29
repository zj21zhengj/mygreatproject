package ioooc.wukong.immoc;

import ioooc.wukong.immoc.computable.Computable;
import ioooc.wukong.immoc.computable.MayFail;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 处于安全考虑需要加一个缓存有效期 到期自动删除 否则缓存一直不失效 会带来不一致问题
 *
 * 如果大量的缓存同一时间失效，会造成服务器的压力，就是缓存雪崩
 */
public class ImoocCache8<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public ImoocCache8(Computable<A,V> c) {
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
                //避免缓存污染
                cache.remove(arg);
                throw e;
            }catch (ExecutionException e) {
                System.out.println("计算错误需要重试");
                cache.remove(arg);
            }

        }
    }

    public final static ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    public V compute(A arg,long expir) throws ExecutionException, InterruptedException {
        if(expir > 0) {
            //未来执行的线程池子
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            },expir,TimeUnit.MILLISECONDS);
        }
        return computer(arg);
    }

    private synchronized void expire(A key) {
        Future<V> future = cache.get(key);
        if(future != null) {
            //如果失效时刚好没计算完
            if(!future.isDone()) {
                System.out.println("Future任务被取消");
                future.cancel(true);
            }
            System.out.println("缓存过期，被取消");
            cache.remove(key);
        }
    }

    //随机时间失效
    public V computeRandomExpire(A arg) throws ExecutionException, InterruptedException {
        long randomE = (long)(Math.random()*10000);
        return compute(arg,randomE);
    }

    public static void main(String[] args) throws Exception {
        ImoocCache8<String,Integer> com2 = new ImoocCache8(new MayFail());
        long start = System.currentTimeMillis();
        new Thread(()->{
            Integer result = null;
            try {
                result = com2.compute("55",5000);
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
        }).start();
        Thread.sleep(6000);
        Integer result = com2.computer("55");
        System.out.println("第四次计算结构"+result);
    }

}
