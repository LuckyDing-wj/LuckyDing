package com.wj.ding.multithread.cooperation;

/**
 * @Date 2021/4/5 20:48
 * @Author: wj
 */
public class CoTest02 {

    public static void main(String[] args) {
        Tv tv = new Tv();
        new Thread(new Player(tv)).start();
        new Thread(new Watcher(tv)).start();
    }

}

class Player implements Runnable {

    private Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                if (i % 2 == 0) {
                    tv.play("guitar");
                } else {
                    tv.play("piano");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Watcher implements Runnable {

    private Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {
                tv.watch();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tv {

    private String voice;
    private boolean flag = true;

    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        this.voice = voice;
        System.out.println("playing " + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

    public synchronized void watch() throws InterruptedException {
        if (flag) {
            this.wait();
        }
        System.out.println("watching " + this.voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}
