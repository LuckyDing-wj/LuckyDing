package com.wj.ding.multithread.cooperation;

/**
 * @Date 2021/4/5 20:38
 * @Author: wj
 */
public class CoTest {

    public static void main(String[] args) {
        Container container = new Container();
        new Thread(new Production(container)).start();
        new Thread(new Consumer(container)).start();
    }

}
