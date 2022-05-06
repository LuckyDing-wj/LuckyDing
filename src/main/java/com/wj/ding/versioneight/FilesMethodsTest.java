package com.wj.ding.versioneight;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @date 2022/4/30 15:16
 * @author: wj
 */
public class FilesMethodsTest {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\Download\\Compressed");

        long startTime = System.currentTimeMillis();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path, "*.{zip,7z}")){
            for (Path filePath : paths) {

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void printTime(long startTime){
        long spentTime = System.currentTimeMillis() - startTime;
        System.out.println("coast " + spentTime/1000 + "s");
    }

}
