package com.hf.juc.state;

/**
 * @author tdw
 * @date 2025.6.3
 */
public class TestMonitorState {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.State state = thread.getState();
        System.out.println(state);
        thread.start();
        state = thread.getState();
        System.out.println(state);
        while (state != Thread.State.TERMINATED){
            state = thread.getState();
            Thread.sleep(100);
            System.out.println(thread.getState());
        }

    }
}
