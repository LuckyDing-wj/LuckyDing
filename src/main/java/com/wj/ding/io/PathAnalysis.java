package com.wj.ding.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Date 2021/3/27 17:20
 * @Author: wj
 */
public class PathAnalysis {

    private static final Logger LOGGER = LoggerFactory.getLogger(PathAnalysis.class);

    static void info(String id, Object result) {
        LOGGER.info("{}: {}", id, result.toString());
    }

    public static void main(String[] args) throws IOException {
        LOGGER.info(System.getProperty("os.name"));
        Path path = Paths.get("D:", "TestFolder", "File.txt");
        info("Exists", Files.exists(path));
        info("Directory", Files.isDirectory(path));
        info("Executable", Files.isExecutable(path));
        info("Readable", Files.isReadable(path));
        info("RegularFile", Files.isRegularFile(path));
        info("Writable", Files.isWritable(path));
        info("notExists", Files.notExists(path));
        info("Hidden", Files.isHidden(path));
        info("size", Files.size(path));
        info("FileStore", Files.getFileStore(path));
        info("LastModified: ", Files.getLastModifiedTime(path));
        info("Owner", Files.getOwner(path));
        info("ContentType", Files.probeContentType(path));
        info("SymbolicLink", Files.isSymbolicLink(path));
        if (Files.isSymbolicLink(path)) {
            info("SymbolicLink", Files.readSymbolicLink(path));
        }
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            info("PosixFilePermissions", Files.getPosixFilePermissions(path));
        }

        LOGGER.info("***************************************");

        Path relativize = path.relativize(path.getRoot());
        LOGGER.info(relativize.toString());

    }

}
