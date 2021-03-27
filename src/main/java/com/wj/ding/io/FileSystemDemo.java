package com.wj.ding.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @date 2021/3/27 16:43
 * @author: wj
 */
public class FileSystemDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemDemo.class);

    static void show(String id, Object o) {
        LOGGER.info("{}: {}", id, o.toString());
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        FileSystem fsys = FileSystems.getDefault();
        for (FileStore fs : fsys.getFileStores()) {
            show("File Store", fs);
        }
        for (Path rd : fsys.getRootDirectories()) {
            show("Root Directory", rd);
        }
        show("Separator", fsys.getSeparator());
        show("UserPrincipalLookupService", fsys.getUserPrincipalLookupService());
        show("isOpen", fsys.isOpen());
        show("isReadOnly", fsys.isReadOnly());
        show("FileSystemProvider", fsys.provider());
        show("File Attribute Views", fsys.supportedFileAttributeViews());
    }

}
