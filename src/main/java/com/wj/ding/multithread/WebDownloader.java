package com.wj.ding.multithread;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Date 2021/3/31 21:58
 * @Author: wj
 */
public class WebDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDownloader.class);

    public void download(String url, String name) {

        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            LOGGER.info("file download failed, url: {} file name: {}", url, name, e);
        }

    }

}
