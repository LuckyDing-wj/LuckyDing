package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 18:43
 * @Author: wj
 */
public class LambdaThread {

    static class Test implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("listen music...");
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new Test()).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("coding...");
            }
        }).start();

    }
}
