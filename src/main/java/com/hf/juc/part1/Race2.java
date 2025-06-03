package com.hf.juc.part1;

import java.util.concurrent.*;

/**
 * @author tdw
 * @date 2025.5.26
 */
public class Race2 implements Callable<String > {

    @Override
    public String call() {
        for (int i = 0; i <= 100; i++) {
            if(i%10== 0 && "a".equals(Thread.currentThread().getName()) ){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "->" + i);
        }
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new Race2());
        String s = submit.get();
        System.out.println(s);
        executorService.shutdown();
    }

}
