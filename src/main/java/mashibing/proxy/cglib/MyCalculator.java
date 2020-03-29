package mashibing.proxy.cglib;

/**
 * jdk必须实现接口
 * 但是 cglib则不需要
 */
public class MyCalculator {

    public int add(int i, int j) {
        return i + j;
    }

    public int sub(int i, int j) {
        return i - j;
    }

    public int div(int i, int j) {
        return i / j;
    }

    public int mul(int i, int j) {
        return i * j;
    }
}
