package com.wj.ding.multithread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/4/4 22:19
 * @Author: wj
 */
public class UnSafeTest {

    public static void main(String[] args) {
        test02();
    }

    private static void test01() {
        Account account = new Account(100, "wedding");
        Drawing her = new Drawing(account, 70, "Her");
        Drawing you = new Drawing(account, 80, "You");
        her.start();
        you.start();
    }

    private static void test02() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }

}
