package com.hf.juc.gaoji.part2;

public class TV {

    String voice;
    boolean flag;

    // 表演
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        this.voice = voice;
        //通知观众观看
        this.notifyAll();
        this.flag = !this.flag;
    }
    // 观看
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了：" + voice);
        // 通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }

}
