package com.wj.ding.multithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @Date 2021/3/31 22:47
 * @Author: wj
 */
public class CallDownloader implements Callable<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallDownloader.class);

    private String url;
    private String name;

    public CallDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader downloader = new WebDownloader();
        LOGGER.info("downloading: {}", name);
        try {
            downloader.download(url, name);
        } catch (Exception e) {
            e.printStackTrace();
            // no use
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallDownloader cd1 = new CallDownloader("https://pic.netbian.com/uploads/allimg/190824/212516-15666531161ade.jpg", "D:\\TestFolder\\4.jpg");
        CallDownloader cd2 = new CallDownloader("https://w.wallhaven.cc/full/72/wallhaven-722dg9.png", "D:\\TestFolder\\5.jpg");
        CallDownloader cd3 = new CallDownloader("https://img01.jituwang.com/190402/256599-1Z40221492893.jpg", "D:\\TestFolder\\6.jpg");

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        Future<Boolean> result1 = threadPool.submit(cd1);
        Future<Boolean> result2 = threadPool.submit(cd2);
        Future<Boolean> result3 = threadPool.submit(cd3);

        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());
        threadPool.shutdownNow();
    }


}
