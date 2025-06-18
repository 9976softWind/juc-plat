package com.hf.juc.gaoji.part1;

public class Productor extends Thread {

     SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了第"+i+"只鸡");
        }
    }
}
