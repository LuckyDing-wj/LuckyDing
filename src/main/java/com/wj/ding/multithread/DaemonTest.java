package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 21:52
 * @Author: wj
 */
public class DaemonTest {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread god1 = new Thread(god, "God");
        Thread you1 = new Thread(you, "You");

        god1.setDaemon(true);
        god1.start();
        you1.start();
    }
}

class God implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 365 * 10; i++) {
            System.out.println("god bless us..." + i);
        }
    }

}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 365; i++) {
            System.out.println("happy day: " + i);
        }
    }

}