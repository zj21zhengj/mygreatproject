package com.liaoxuefeng.github;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    public static void main(String[] args) {
        //获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo:threadInfos) {
            System.out.println("["+ threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }
        long sumBalance = 0l;
        System.out.println(sumBalance);
        Long balance = -800L;
        Long depositBalance = 0l;
        Long refundFreeze = 0l;
        Long settleFreeze = 8100l;
        Long refundAmount = 800l;
        if((balance + depositBalance + settleFreeze - refundFreeze) < refundAmount)
            System.out.println("y");
        else
            System.out.println("n");
    }
}
