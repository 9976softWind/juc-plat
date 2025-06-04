package com.hf.juc.priority;

/**
 * @author tdw
 * @date 2025.6.4
 */
public class Testpriority {

    public static void main(String[] args) {
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority,"t1");
        t1.setPriority(1);
        t1.start();
        Thread t2 = new Thread(myPriority,"t2");
        t2.setPriority(10);
        t2.start();
        Thread t3 = new Thread(myPriority,"t3");
        t3.setPriority(7);
        t3.start();
        Thread t4 = new Thread(myPriority,"t4");
        t4.setPriority(8);
        t4.start();
        Thread t5 = new Thread(myPriority,"t5");
        t5.setPriority(9);
        t5.start();
    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->"+ Thread.currentThread().getPriority());
    }
}
