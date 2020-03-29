package ioooc.wukong.immoc;

import ioooc.wukong.immoc.computable.Computable;
import ioooc.wukong.immoc.computable.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用装饰器模式 解耦
 *
 *  syncirozed 性能低， 可以缩小代码块，但还是不够的，所以用couurtnHashMap
 */
public class ImoocCache3<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A,V> cache = new ConcurrentHashMap<>();

    private final Computable<A,V> c;

    public ImoocCache3(Computable<A,V> c) {
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
        ImoocCache3<String,Integer> com2 = new ImoocCache3(new ExpensiveFunction());
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
        }).start();
    }

}
