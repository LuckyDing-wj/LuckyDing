package com.wj.ding.multithread;

/**
 * @Date 2021/4/4 21:07
 * @Author: wj
 */
public class Father implements Runnable {

    @Override
    public void run() {
        System.out.println("Father give son money to buy cigarette.");
        Son son = new Son();
        Thread thread = new Thread(son);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Smoking...");

    }

    public static void main(String[] args) {
        Father father = new Father();
        new Thread(father).start();
    }

}
