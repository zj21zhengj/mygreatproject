package ioooc.wukong.fulture.immoc;

import ioooc.wukong.fulture.immoc.computable.Computable;
import ioooc.wukong.fulture.immoc.computable.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *  解决4的问题
 */
public class ImoocCache5<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public ImoocCache5(Computable<A,V> c) {
        this.c = c;
    }


    @Override
    public  V computer(A arg) throws Exception {
        System.out.println("进入缓存机制");
        //Thread.sleep(100); 哈哈加了这句才有效 是我自己发现的 骄傲脸
        Future<V> f = cache.get(arg);
        if(f == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.computer(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(callable);
            f = ft;
            //最关键的一部，利用了couurtnHash的可见性，但是前提是 Future<V> f = cache.get(arg); 重复的线程还没走到这句
            cache.put(arg,ft);
            System.out.println("从FutureTask调用了计算函数");
            ft.run();
        }
        return f.get();
    }

    public static void main(String[] args) throws Exception {
        ImoocCache5<String,Integer> com2 = new ImoocCache5(new ExpensiveFunction());
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
