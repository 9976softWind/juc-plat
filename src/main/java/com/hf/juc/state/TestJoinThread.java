package com.hf.juc.state;

/**
 * @author tdw
 * @date 2025.6.3
 */
public class TestJoinThread {
    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();

        for (int i = 0; i < 200; i++) {
            if(i == 100){
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

class JoinThread implements Runnable{

    @Override
    public void run() {
        for (int j = 0; j < 500; j++) {
            System.out.println(Thread.currentThread().getName() + j);
        }
    }
}

