package com.wj.ding.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date 2021/3/31 22:09
 * @Author: wj
 */
public class ThreadDownloader extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadDownloader.class);

    private String url;
    private String name;

    public ThreadDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        LOGGER.info("downloading: {}", name);
        downloader.download(url, name);
    }

    public static void main(String[] args) {

        ThreadDownloader td1 = new ThreadDownloader("https://pic.netbian.com/uploads/allimg/190824/212516-15666531161ade.jpg", "D:\\TestFolder\\1.jpg");
        ThreadDownloader td2 = new ThreadDownloader("https://w.wallhaven.cc/full/72/wallhaven-722dg9.png", "D:\\TestFolder\\2.jpg");
        ThreadDownloader td3 = new ThreadDownloader("https://img01.jituwang.com/190402/256599-1Z40221492893.jpg", "D:\\TestFolder\\3.jpg");

        td1.start();
        td2.start();
        td3.start();

    }

}
