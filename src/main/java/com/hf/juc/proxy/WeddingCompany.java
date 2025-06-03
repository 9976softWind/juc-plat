package com.hf.juc.proxy;

/**
 * @author tdw
 * @date 2025.6.3
 */
public class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void marry() {
        System.out.println("before");
        this.target.marry();
        System.out.println("after");
    }

}
