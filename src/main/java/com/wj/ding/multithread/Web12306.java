package com.wj.ding.multithread;

/**
 * @Date 2021/4/3 20:40
 * @Author: wj
 */
public class Web12306 implements Runnable {

    private int ticketNums = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---> " + ticketNums--);
        }
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();

        new Thread(web, "a").start();
        new Thread(web, "b").start();
        new Thread(web, "c").start();
    }
}
