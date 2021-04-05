package com.wj.ding.multithread.cooperation;

/**
 * @Date 2021/4/5 20:30
 * @Author: wj
 */
public class Production implements Runnable {

    private Container container;

    public Production(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new SteamedBun(i));
            System.out.println("push steamedBun id: " + i);
        }
    }
}
