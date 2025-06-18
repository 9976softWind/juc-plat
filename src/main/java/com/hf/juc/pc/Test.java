package com.hf.juc.pc;

/**
 * @author tdw
 * @date 2025.6.18
 */
public class Test {
    public static void main(String[] args) {
        Chicken chicken = new Chicken();
        Duck duck = new Duck();
        Factory chickenFactory = new Factory(chicken);
        Factory duckFactory = new Factory(duck);
//        new Thread(()->{
//            for (int i = 0; i < 20; i++) {
//                chickenFactory.procedure();
//            }
//        },"A").start();
//        new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                chickenFactory.consumer();
//            }
//        },"B").start();

                new Thread(()->{
            for (int i = 0; i < 20; i++) {
                duckFactory.procedure();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                duckFactory.consumer();
            }
        },"B").start();
    }
}
