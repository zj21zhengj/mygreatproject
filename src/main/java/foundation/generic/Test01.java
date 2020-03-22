package foundation.generic;

import java.lang.reflect.Field;

/**
 * 泛型的原理
 *   类型擦除  即在编译时检查，编译后全部除去
 *   当转为Object 为无限制类型擦除
 *   当泛型有上限时  此时为有限制的类型擦除
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Erasure<Integer> erasure = new Erasure<>();
        //利用反射 获取Erasure字节码文件的class对象
        Class<? extends Erasure> clz = erasure.getClass();
        Field[] declaredFields = clz.getDeclaredFields();
        Class clz2 = Class.forName("foundation.generic.Erasure");
        Class clzz3 = Erasure.class;
        System.out.println(clz == clz2);
        System.out.println(clz2 == clzz3);
        for(Field declared:declaredFields) {
            //打印成员变量
            System.out.println(declared.getName()+":"+declared.getType().getSimpleName());
        }

    }
}
