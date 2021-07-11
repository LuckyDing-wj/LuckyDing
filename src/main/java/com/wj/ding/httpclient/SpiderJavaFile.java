package com.wj.ding.httpclient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 抓取java后浪的书籍，输出百度盘链接
 *
 * @date 2021/7/11 18:10
 * @author: wj
 */
public class SpiderJavaFile {

    private static final Logger logger = LoggerFactory.getLogger(SpiderJavaFile.class);

    private static final String urlPrefix = "http://www.javahlw.com";

    /**
     * <div class="d-download">
     *     <p class="d-password">提取码：<span>6la0</span></p>
     *     <a href="https://pan.baidu.com/s/1gL526WyVErUqeA4lbKVbdw" class="layui-btn layui-btn-danger" target="_blank">网盘下载</a>
     *     <p style="color: red;margin: 20px 0px 20px 0px;font-size: 16px;">注意：<strong>本站预计2021年6月左右关闭，热门资源将在公众号中分享，关注下方公众号留个脚印吧~~~~</strong></p>
     *     <img src="/image/wechat.png">
     * </div>
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        for (int i = 7; i <= 31; i++) {
            extracted(map, i);
        }
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String bookUrl = entry.getValue();
            Document document = Jsoup.connect(bookUrl).get();
            Elements passwordElements = document.getElementsByClass("d-password");
            Element spanElement = passwordElements.get(0).child(0);
            String password = spanElement.html();
            Elements panUrlElements = document.getElementsByClass("layui-btn layui-btn-danger");
            String panUrl = panUrlElements.get(0).attr("href");
            logger.info("书籍名称：{} 链接：{} 提取码: {}", entry.getKey(), panUrl, password);
            joiner.add(panUrl + " " + password);
        }

        Path path = Paths.get("e:\\JavaBooks.txt");
        try (FileWriter writer = new FileWriter(path.toFile());) {
            writer.write(joiner.toString());
            writer.flush();
        }

    }

    private static void extracted(Map<String, String> map, int page) throws IOException {
        Document document = Jsoup.connect("http://www.javahlw.com/pdf/" + page + ".html").get();
        Elements elementsByClass = document.getElementsByClass("rs-item-pic");
        for (Element element : elementsByClass) {
            Element aElement = element.child(0);
            String bookHref = urlPrefix + aElement.attr("href");
            String bookName = aElement.child(0).attr("alt");
            map.put(bookName, bookHref);
        }
    }


}
