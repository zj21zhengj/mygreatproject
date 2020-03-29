package ioooc.wukong.immoc.computable;

/**
 * 有一个计算函数computer,用来代表耗时计算，每个计算器都要实现这个接口，
 * 这样就可以实现缓存功能
 */
public interface Computable<A,V> {

    V computer(A arg) throws Exception;
}
