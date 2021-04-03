package com.wj.ding.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date 2021/3/31 22:47
 * @Author: wj
 */
public class RunDownloader implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunDownloader.class);

    private String url;
    private String name;

    public RunDownloader(String url, String name) {
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

        ThreadDownloader td1 = new ThreadDownloader("https://pic.netbian.com/uploads/allimg/190824/212516-15666531161ade.jpg", "D:\\TestFolder\\4.jpg");
        ThreadDownloader td2 = new ThreadDownloader("https://w.wallhaven.cc/full/72/wallhaven-722dg9.png", "D:\\TestFolder\\5.jpg");
        ThreadDownloader td3 = new ThreadDownloader("https://img01.jituwang.com/190402/256599-1Z40221492893.jpg", "D:\\TestFolder\\6.jpg");

        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();
    }


}
