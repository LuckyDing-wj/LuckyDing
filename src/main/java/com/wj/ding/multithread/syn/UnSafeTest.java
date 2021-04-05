package com.wj.ding.multithread.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Date 2021/4/4 22:19
 * @Author: wj
 */
public class UnSafeTest {

    public static void main(String[] args) throws InterruptedException {
        test03();
    }


    private static void test01() {
        Account account = new Account(100, "wedding");
        Drawing her = new Drawing(account, 70, "Her");
        Drawing you = new Drawing(account, 80, "You");
        you.start();
        her.start();
    }

    private static void test02() throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(10000);
        System.out.println(list.size());
    }

    private static void test03() throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }


}
