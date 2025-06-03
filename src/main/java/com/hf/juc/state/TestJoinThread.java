package com.hf.juc.state;

/**
 * @author tdw
 * @date 2025.6.3
 */
public class TestJoinThread {
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);

        for (int i = 0; i < 100; i++) {
            if(i == 50){
                thread.start();
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class JoinThread implements Runnable{

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName() + j);
        }
    }
}

