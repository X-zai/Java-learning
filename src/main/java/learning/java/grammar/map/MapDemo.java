/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.grammar.map;

import java.util.Collection;
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
        //        put();
        //        get();
        //        remove();
        object();
        //        loop1();
        //        loop2();
        //        findKey();
        //        findValue();
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
        personAges.put("语文平均分", 67);
        personAges.put("数学平均分", 81);
        personAges.put("英语平均分", 85);

        //拿语文平均分
        Integer tomAge = personAges.get("语文平均分");
        System.out.println(tomAge);

        //拿数学平均分
        Integer richardAge = personAges.get("数学平均分");
        System.out.println(richardAge);
    }

    /**
     * 删除元素
     */
    public static void remove() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("语文平均分", 67);
        personAges.put("数学平均分", 81);
        personAges.put("英语平均分", 85);

        //删除Tom的年龄
        personAges.remove("语文平均分");

        //拿Tom的年龄
        Integer tomAge = personAges.get("语文平均分");
        System.out.println(tomAge);
    }

    /**
     * 获取各种对象
     */
    public static void object() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("语文平均分", 67);
        personAges.put("数学平均分", 81);
        personAges.put("英语平均分", 85);

        //获取entrySet
        Set<Entry<String, Integer>> entrys = personAges.entrySet();
        System.out.println(entrys);
        //获取keySet
        Set<String> keys = personAges.keySet();
        System.out.println(keys);
        //获取values
        Collection<Integer> values = personAges.values();
        System.out.println(values);
    }

    /**
     * 循环元素，方法1
     */
    public static void loop1() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("语文平均分", 67);
        personAges.put("数学平均分", 81);
        personAges.put("英语平均分", 85);

        //获取Entry列表
        Set<Entry<String, Integer>> entrys = personAges.entrySet();
        for (Entry<String, Integer> entry : entrys) {
            //获取key
            System.out.println(entry.getKey());
            //获取value
            System.out.println(entry.getValue());
        }
    }

    /**
     * 循环元素，方法2
     */
    public static void loop2() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("语文平均分", 67);
        personAges.put("数学平均分", 81);
        personAges.put("英语平均分", 85);

        //获取Key列表
        Set<String> keys = personAges.keySet();
        for (String key : keys) {
            //打印key
            System.out.println(key);
            //获取value
            System.out.println(personAges.get(key));
        }
    }

    /**
     * 是否包含Key
     */
    public static void findKey() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("tom", 67);
        personAges.put("lisa", 81);
        personAges.put("kenny", 85);

        //是否包含Key
        if (personAges.containsKey("tom")) {
            System.out.println("找到tom");
        }

    }

    /**
     * 是否包含Value
     */
    public static void findValue() {
        //放元素
        Map<String, Integer> personAges = new HashMap<String, Integer>();
        personAges.put("tom", 67);
        personAges.put("lisa", 81);
        personAges.put("kenny", 85);

        //是否包含Value
        if (personAges.containsValue(81)) {
            System.out.println("找到81");
        }

    }

}
