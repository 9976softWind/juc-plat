package com.hf.juc.proxy;

/**
 * @author tdw
 * @date 2025.6.3
 * 静态代理模式总结：
 *  真实对象和代理对象实现同一个接口（此处的Marry）
 *  代理对象要代理真实角色
 *
 *  好处
 *      代理对象可以做很多真实对象做不了的事情
 *      真实对象专注做自己的事情
 *
 */
public class StaticProxyTest {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("proxy")).start();
        new WeddingCompany(new You()).marry();

    }
}
