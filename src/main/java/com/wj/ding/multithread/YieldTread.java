package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 20:14
 * @Author: wj
 */
public class YieldTread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start...");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " end...");
    }

    public static void main(String[] args) {
        YieldTread yieldTread = new YieldTread();
        new Thread(yieldTread, "a").start();
        new Thread(yieldTread, "b").start();
    }
}
