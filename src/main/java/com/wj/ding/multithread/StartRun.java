package com.wj.ding.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date 2021/3/31 22:39
 * @Author: wj
 */
public class StartRun implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartRun.class);
    private static final int NUM = 20;

    @Override
    public void run() {
        for (int i = 0; i < NUM; i++) {
            LOGGER.info("listen...");
        }
    }

    public static void main(String[] args) {
        new Thread(new StartRun()).start();

        for (int i = 0; i < NUM; i++) {
            LOGGER.info("coding...");
        }
    }

}
