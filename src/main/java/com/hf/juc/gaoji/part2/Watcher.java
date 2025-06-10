package com.hf.juc.gaoji.part2;

public class Watcher extends Thread{
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
           tv.watch();
        }
    }
}
