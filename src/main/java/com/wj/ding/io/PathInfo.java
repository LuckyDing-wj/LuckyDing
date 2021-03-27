package com.wj.ding.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Date 2021/3/27 16:47
 * @Author: wj
 */
public class PathInfo {

    private static final Logger LOGGER = LoggerFactory.getLogger(PathInfo.class);

    static void show(String id, Object p) {
        LOGGER.info("{}: {}", id, p);
    }

    static void info(Path path) {
        show("toString", path);
        show("Exists", Files.exists(path));
        show("RegularFile", Files.isRegularFile(path));
        show("Directory", Files.isDirectory(path));
        show("Absolute", path.isAbsolute());
        show("FileName", path.getFileName());
        show("Parent", path.getParent());
        show("Root", path.getRoot());
        LOGGER.info("******************");
    }

    public static void main(String[] args) {
        LOGGER.info(System.getProperty("os.name"));
        info(Paths.get("D:", "TestFolder", "NoFile.txt"));

        Path path = Paths.get("PathInfo.java");
        info(path);

        Path absolutePath = path.toAbsolutePath();
        info(absolutePath);

        try {
            Path realPath = path.toRealPath();
            info(realPath);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        URI uri = path.toUri();
        LOGGER.info("URI: {}", uri);


    }

}
