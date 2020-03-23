package foundation.generic;

import java.lang.reflect.Array;

/**
 * 泛型与数组
 */
public class Fruit<T> {
    private T[] array;

    public Fruit(Class<T> clz,int length) {
        //通过
        this.array = (T[]) Array.newInstance(clz,length);
    }

    public void put(int index,T item) {
        array[index] = item;
    }

    public T[] getArray() {
        return array;
    }
}
