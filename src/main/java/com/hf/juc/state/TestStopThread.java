package com.hf.juc.state;

/**
 * @author tdw
 * @date 2025.6.3
 *
 * 线程停止：
 *  1.建议线程正常停止，利用次数，不建议死循环
 *  2.设置一个标志位
 *  3.不要使用stop或destroy等过时或JDK不推荐的方法
 */
public class TestStopThread  {

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        new Thread(testThread).start();
        for (int i = 0; i < 1000; i++) {
            if( i == 990){
                testThread.stop();
            }
            System.out.println("mainThread->" + i);
        }
    }

}
class TestThread implements Runnable{

    private boolean isRunning = true;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(isRunning){
                System.out.println("testThread->" + i);
            }
        }
    }

    public void stop(){
        this.isRunning = false;
    }

}
