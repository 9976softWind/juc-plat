package com.hf.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tdw
 * @date 2025.6.18
 * GUC模式实现：Lock，Condition
 */
public class Duck implements ProcedureConsumerAble{

    // 最大库存量
    private static final int MAX_CAPACITY = 10;
    // 当前库存量
    private int inventory  = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     *  lock.newCondition()获取多个Condition，调用不同的condition的await(),signal()，可实现精准唤醒（->业务流，须有先后顺序）
     *  private Condition condition1 = lock.newCondition();
     *  private Condition condition2 = lock.newCondition();
     */
    @Override
    public void procedure() {
        lock.lock();
        try {
            while (inventory >= MAX_CAPACITY){
                condition.await();
            }
            inventory++;
            System.out.println(Thread.currentThread().getName() + "生产了一只，现在共有" + inventory + "只鸭");
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void consumer() {
        lock.lock();
        try {
            while (inventory <= 0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "消费了第" + inventory + "只鸭");
            inventory--;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
