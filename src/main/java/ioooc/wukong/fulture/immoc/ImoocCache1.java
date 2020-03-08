package ioooc.wukong.fulture.immoc;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 第一版本最简单的缓存   HashMap
 */
public class ImoocCache1 {

    //加上final表示指向的引用不能改变了
    private final static HashMap<String,Integer> cache = new HashMap<>();

    public Integer computer(String userId) {
        Integer res = cache.get(userId);
        //先检查缓存中是否有要查的值
        if(res == null) {
            res = doComputer(userId);
            cache.put(userId,res);
        }
        return res;
    }

    private Integer doComputer(String userId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Integer(userId);
    }

    public static void main(String[] args) {
        ImoocCache1 com = new ImoocCache1();
        System.out.println("开始计算");
        System.out.println("第一次计算结果"+com.computer("13"));
        System.out.println("第二次计算结果"+com.computer("13"));
    }
}
