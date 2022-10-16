package com.wj.ding.multithread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @date 2022/9/14 11:41
 * @author: wj
 */
public class TestAtomicLong {

    private static final AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(atomicLong.incrementAndGet());
        }
    }

}
