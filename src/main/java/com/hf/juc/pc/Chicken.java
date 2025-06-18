package com.hf.juc.pc;

/**
 * @author tdw
 * @date 2025.6.18
 * 传统模式实现：synchronized，wait,notifyAll(注意虚假唤醒，请在同步代码块里使用while)
 */
public class Chicken implements ProcedureConsumerAble {

    // 最大库存量
    private static final int MAX_CAPACITY = 10;
    // 当前库存量
    private int inventory  = 0;

    // 生产
    @Override
    public synchronized void procedure(){
        while (inventory >= MAX_CAPACITY){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        inventory++;
        System.out.println(Thread.currentThread().getName() + "生产了一只，现在共有" + inventory + "只鸡");
        this.notifyAll();
    }
    // 消费
    @Override
    public synchronized void consumer(){
        while (inventory <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消费了第" + inventory + "只鸡");
        inventory--;
        this.notifyAll();
    }

}
