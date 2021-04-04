package com.wj.ding.multithread;

/**
 * @Date 2021/4/3 20:50
 * @Author: wj
 */
public class Racer implements Runnable {

    private String winner;

    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            if ("Rabbit".equals(Thread.currentThread().getName()) && steps % 10 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--> " + steps);
            if (gameOver(steps)) {
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is: " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "Rabbit").start();
        new Thread(racer, "tortoise").start();
    }
}
