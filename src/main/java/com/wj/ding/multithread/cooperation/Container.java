package com.wj.ding.multithread.cooperation;

/**
 * @Date 2021/4/5 20:31
 * @Author: wj
 */
public class Container {

    private SteamedBun[] buns = new SteamedBun[10];
    private int count;

    public synchronized void push(SteamedBun steamedBun) {
        if (count == buns.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = steamedBun;
        count++;
        this.notifyAll();
    }

    public synchronized SteamedBun pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        count--;
        return buns[count];
    }
}
