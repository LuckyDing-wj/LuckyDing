package com.wj.ding.multithread;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date 2021/3/31 21:34
 * @Author: wj
 */
public class StartThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartThread.class);
    private static final int NUM = 20;

    @Override
    public void run() {
        for (int i = 0; i < NUM; i++) {
            LOGGER.info("listen...");
        }
    }

    public static void main(String[] args) {
        StartThread startThread = new StartThread();
        startThread.start();

        for (int i = 0; i < NUM; i++) {
            LOGGER.info("coding...");
        }

    }
}
