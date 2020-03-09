package ioooc.wukong.fulture.immoc.computable;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *  解决5的漏洞 由于同时到达get方法
 */
public class ImoocCache6<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public ImoocCache6(Computable<A,V> c) {
        this.c = c;
    }


    @Override
    public  V computer(A arg) throws Exception {
        System.out.println("进入缓存机制");
        Future<V> f = cache.get(arg);
        if(f == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.computer(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(callable);
            //putIfAbsent获取的是更新前的值，第一次一定是null,第二个线程看到已经有值了，不会更新
            //couurntHashMap支持并发不会同时执行这句
            f = cache.putIfAbsent(arg,ft);
            if(f == null) {
                f = ft;
                System.out.println("从FutureTask调用了计算函数");
                ft.run();
            }
        }
        return f.get();
    }

    public static void main(String[] args) throws Exception {
        ImoocCache6<String,Integer> com2 = new ImoocCache6(new ExpensiveFunction());
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
                result = com2.computer("55");
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

    }

}
