/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.grammar.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Collection和Map查询性能对比
 * 
 * @author Rayliu40k
 * @version $Id: Collection2Map.java, v 0.1 May 9, 2020 2:38:40 PM Rayliu40k Exp $
 */
public class Collection2MapPerf {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        findByCollection();
        System.out.println("-------------");
        findByMap();
    }

    public static void findByCollection() {
        System.out.println("Collection");
        //放数字
        List<Integer> data = new ArrayList<Integer>();
        long start1 = System.currentTimeMillis();
        System.out.println("放数字...");
        for (int i = 0; i < 30000000; i++) {
            data.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("放数字总耗时：" + (end1 - start1) + "ms");
        //找数字
        System.out.println("找数字...");
        long start2 = System.currentTimeMillis();
        for (int src : data) {
            int target = 20000000;
            if (src == target) {
                System.out.println("找到了" + target);
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println("找数字总耗时：" + (end2 - start2) + "ms");
    }

    public static void findByMap() {
        System.out.println("Map");
        //放数字
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();
        long start1 = System.currentTimeMillis();
        System.out.println("放数字...");
        for (int i = 0; i < 30000000; i++) {
            data.put(i, i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("放数字总耗时：" + (end1 - start1) + "ms");
        //找数字
        System.out.println("找数字...");
        long start2 = System.currentTimeMillis();
        int target = 20000000;
        Integer result = data.get(target);
        if (result != null) {
            System.out.println("找到了" + target);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("找数字总耗时：" + (end2 - start2) + "ms");
    }
}
