package foundation.generic;

import java.util.Arrays;

/**
 * 验证数组
 */
public class Test02 {
    public static void main(String[] args) {
        Fruit<String> fruit = new Fruit<>(String.class,3);
        fruit.put(0,"苹果");
        fruit.put(1,"香蕉");
        fruit.put(2,"桃子");
        System.out.println(Arrays.toString(fruit.getArray()));
    }
}
