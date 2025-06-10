package com.hf.juc.gaoji.part2;

public class Test {

    public static void main(String[] args)   {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
