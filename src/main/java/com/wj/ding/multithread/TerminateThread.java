package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 19:54
 * @Author: wj
 */
public class TerminateThread implements Runnable {

    private boolean flag = true;

    private String name;

    public TerminateThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(this.name + "-->" + i++);
        }
    }

    public void terminate() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TerminateThread jack = new TerminateThread("Jack");
        new Thread(jack).start();

        for (int i = 0; i < 20; i++) {
            if (i == 10) {
                jack.terminate();
                System.out.println("jack out");
            }
            System.out.println("main -->" + i);
        }
    }

}
