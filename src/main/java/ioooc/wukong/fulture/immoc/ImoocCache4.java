package ioooc.wukong.fulture.immoc;

import ioooc.wukong.fulture.immoc.computable.Computable;
import ioooc.wukong.fulture.immoc.computable.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  使用 couurtnHashMap 后还是有问题的
 *  如果两个相同的值 a在计算的时候，因为还没结果b也会计算的，没有有效使用缓存
 */
public class ImoocCache4<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A,V> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public ImoocCache4(Computable<A,V> c) {
        this.c = c;
    }


    @Override
    public  V computer(A arg) throws Exception {
        System.out.println("进入缓存机制");
        V res = cache.get(arg);
        if(res == null) {
            res = c.computer(arg);
            cache.put(arg,res);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache4<String,Integer> com2 = new ImoocCache4(new ExpensiveFunction());
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            Integer result = null;
            try {
                result = com2.computer("55");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第一次计算结果："+result);
        });
        Thread t2 = new Thread(()->{
            Integer result = null;
            try {
                result = com2.computer("55");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第二次计算结果："+result);
        });
        Thread t3 = new Thread(()->{
            Integer result = null;
            try {
                result = com2.computer("55");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("第三次计算结果："+result);
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        long end = System.currentTimeMillis();
        System.out.println("时长"+(end-start));

    }

}
