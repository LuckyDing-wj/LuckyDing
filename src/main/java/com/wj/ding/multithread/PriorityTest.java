package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 21:32
 * @Author: wj
 */
public class PriorityTest implements Runnable {

    public static void main(String[] args) {

        PriorityTest test = new PriorityTest();

        Thread a = new Thread(test, "a");
        Thread b = new Thread(test, "b");
        Thread c = new Thread(test, "c");
        Thread d = new Thread(test, "d");
        Thread e = new Thread(test, "e");
        Thread f = new Thread(test, "f");

        d.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);
        a.setPriority(Thread.NORM_PRIORITY);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
