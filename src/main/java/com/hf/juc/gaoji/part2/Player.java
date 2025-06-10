package com.hf.juc.gaoji.part2;

public class Player extends Thread{
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0){
                tv.play("快乐大本营");
            }else{
                tv.play("广告");
            }
        }
    }
}
