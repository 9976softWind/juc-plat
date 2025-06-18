package com.hf.juc.gaoji.part1;



public class SynContainer {
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void push(Chicken chicken){
        if(count == chickens.length ){
            //生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        //通知消费者进行消费
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        if(count==0){
            //消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];

        // 吃完了通知生产
        this.notifyAll();
        return chicken;
    }
}
