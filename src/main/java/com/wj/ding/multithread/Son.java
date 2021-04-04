package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 21:04
 * @Author: wj
 */
public class Son implements Runnable {

    @Override
    public void run() {
        System.out.println("son out of home");
        System.out.println("Find a place, playing game...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bought cigarette and back home. give father the cigarette.");
    }

}
