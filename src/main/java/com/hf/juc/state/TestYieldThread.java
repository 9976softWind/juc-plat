package com.hf.juc.state;

/**
 * @author tdw
 * @date 2025.6.3
 *  礼让线程，当前执行线程暂停，但不阻塞
 *  让线程重新从运行状态转为就绪状态
 *  让cpu重新调度，礼让不一定成功，看cpu的调度算法结果
 */
public class TestYieldThread  {

    public static void main(String[] args) {
        MyYield testThread = new MyYield();
        new Thread(testThread,"a").start();
        new Thread(testThread,"b").start();

    }

}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "结束执行");
    }

}
