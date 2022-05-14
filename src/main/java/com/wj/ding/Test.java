package com.wj.ding;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021/7/4 21:05
 * @author: wj
 */
public class Test {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        String aa = "aa";
        map.put("a", aa);
        map.put("b", aa);
        System.out.println(map.values().size());
    }

}
