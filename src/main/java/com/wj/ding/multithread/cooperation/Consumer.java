package com.wj.ding.multithread.cooperation;

/**
 * @Date 2021/4/5 20:36
 * @Author: wj
 */
public class Consumer implements Runnable {

    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            container.pop();
            System.out.println("pop steamedBun id: " + i);
        }
    }
}
