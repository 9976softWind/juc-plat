package com.hf.juc.gaoji.part1;

public class Consumer extends Thread{

     SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("消费了第"+container.pop().id+"只鸡");
        }
    }

}
