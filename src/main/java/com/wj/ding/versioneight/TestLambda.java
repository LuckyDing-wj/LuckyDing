package com.wj.ding.versioneight;


import javax.naming.directory.BasicAttribute;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @date 2022/3/6 14:14
 * @author: wj
 */
public class TestLambda {

    public static void main(String[] args) throws ParseException, IOException {
        testFiles1();
    }

    private static void testFiles1() throws IOException {
        Path rootPath = Paths.get("D:\\Download\\App");
        Path aliPan = rootPath.resolveSibling("AliPan");
        System.out.println(aliPan);
        System.out.println(aliPan.getParent());
        System.out.println(aliPan.iterator());
        System.out.println(aliPan.getFileSystem());
        System.out.println(rootPath.relativize(aliPan));
        System.out.println(Files.size(rootPath));

        List<String> asList = Arrays.asList(new String[]{"aaaa", "nbbb", "cccc"});
//        Files.write(rootPath.resolve("test.txt"), asList);

        Path testPath = rootPath.resolve("test.txt");
        BasicFileAttributes attribute = Files.readAttributes(testPath, BasicFileAttributes.class);
        System.out.println(attribute);

        Path downloadPath = Paths.get("D:\\Download");
        try (Stream<Path> pathStream = Files.walk(downloadPath, 1)){
            pathStream.filter(Files::isRegularFile).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------------------------------------");
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(downloadPath, "*.{zip,pdf,pem}")){
            paths.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
