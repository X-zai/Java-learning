/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.grammar.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map使用例子
 * 
 * @author Rayliu40k
 * @version $Id: MyMap.java, v 0.1 May 9, 2020 2:35:56 PM Rayliu40k Exp $
 */
public class MapDemo {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        put();
        get();
        remove();
        loop();
    }

    /**
     * 放元素
     */
    public static void put() {
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("Tom", 11);
        personAges.put("Kenny", 17);
        personAges.put("Richard", 33);
    }

    /**
     * 拿元素
     */
    public static void get() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("Tom", 11);
        personAges.put("Kenny", 17);
        personAges.put("Richard", 33);

        //拿Tom的年龄
        Integer tomAge = personAges.get("Tom");
        System.out.println(tomAge);

        //拿Tom的年龄
        Integer richardAge = personAges.get("Richard");
        System.out.println(richardAge);
    }

    /**
     * 删除元素
     */
    public static void remove() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("Tom", 11);
        personAges.put("Kenny", 17);
        personAges.put("Richard", 33);

        //删除Tom的年龄
        personAges.remove("Tom");

        //拿Tom的年龄
        Integer tomAge = personAges.get("Tom");
        System.out.println(tomAge);
    }

    /**
     * 循环元素
     */
    public static void loop() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("Tom", 11);
        personAges.put("Kenny", 17);
        personAges.put("Richard", 33);

        //获取Entry列表
        Set<Entry<String, Integer>> entrys = personAges.entrySet();
        for (Entry<String, Integer> entry : entrys) {
            //获取key
            System.out.println(entry.getKey());
            //获取value
            System.out.println(entry.getValue());
        }
    }

}
