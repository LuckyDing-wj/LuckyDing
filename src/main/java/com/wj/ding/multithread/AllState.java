package com.wj.ding.multithread;

import java.lang.Thread.State;

/**
 * @Date 2021/4/4 21:14
 * @Author: wj
 */
public class AllState {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("--");
            }
        });

        extracted(t);
        t.start();
        extracted(t);

        while (true) {
            int count = Thread.activeCount();
            System.out.println(count);
            if (count == 1) {
                break;
            }
            Thread.sleep(200);
            extracted(t);
        }
    }

    private static void extracted(Thread t) {
        System.out.println(t.getState());
    }


}
