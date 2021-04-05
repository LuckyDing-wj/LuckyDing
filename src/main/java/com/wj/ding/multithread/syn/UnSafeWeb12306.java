package com.wj.ding.multithread.syn;

import com.wj.ding.multithread.Web12306;

/**
 * @Date 2021/4/3 20:40
 * @Author: wj
 */
public class UnSafeWeb12306 implements Runnable {

    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }

    private synchronized void test() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---> " + ticketNums--);
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();

        new Thread(web, "a").start();
        new Thread(web, "b").start();
        new Thread(web, "c").start();
    }
}
