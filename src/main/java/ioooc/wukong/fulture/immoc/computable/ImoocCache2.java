package ioooc.wukong.fulture.immoc.computable;

import java.util.HashMap;
import java.util.Map;

/**
 * 用装饰器模式 解耦
 *
 *  装饰器 是又继承 又是有组合
 */
public class ImoocCache2<A,V> implements Computable<A,V> {

    //加上final表示指向的引用不能改变了
    private final Map<A,V> cache = new HashMap<A,V>();

    private final Computable<A,V> c;

    public ImoocCache2(Computable<A,V> c) {
        this.c = c;
    }


    @Override
    public V computer(A arg) throws Exception {
        System.out.println("进入缓存机制");
        V res = cache.get(arg);
        if(res == null) {
            res = c.computer(arg);
            cache.put(arg,res);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache2<String,Integer> com2 = new ImoocCache2(new ExpensiveFunction());
        Integer result = com2.computer("55");
        System.out.println("第一次计算结果："+result);
        Integer result2 = com2.computer("55");
        System.out.println("第二次计算结果："+result2);
    }

}
