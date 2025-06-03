package com.hf.juc.part1;

/**
 * @author tdw
 * @date 2025.5.26
 */
public class Race implements Runnable {

    private static String name;


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%10== 0 && "a".equals(Thread.currentThread().getName()) ){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean b = gameOver(i);
            if(b) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
    }

    private boolean gameOver(int steps){
        if(name != null){
            return true;
        }else{
            if(steps == 100){
                name = Thread.currentThread().getName();
                System.out.println("winner is " + name);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Thread a = new Thread(new Race(),"a");
        Thread b = new Thread(new Race(),"b");
        a.start();
        b.start();

    }

}
