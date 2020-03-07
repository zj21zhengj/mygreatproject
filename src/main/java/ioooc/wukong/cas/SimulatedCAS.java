package ioooc.wukong.cas;

/**
 * 什么是CAS
 * 并发中的
 * 我认为V的值是A,如果是的话我就把它改成B,如果不是A(说明被别人修改过了)
 * 那我就不修改了 避免多人同时修改导致出错
 */
public class SimulatedCAS {
    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue,int newValue) {
       int oldValue = value;
       if(oldValue == expectedValue) {
           value = newValue;
       }
       return oldValue;
    }
}
