/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.grammar.collection.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set是Collection的一种，是一个不允许出现重复元素，并且无序的集合，主要有HashSet和TreeSet两大实现类。
 * 
 * @author Rayliu40k
 * @version $Id: Set集合.java, v 0.1 Mar 20, 2020 4:00:03 PM Rayliu40k Exp $
 */
public class Set集合 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        set();
        //sortSet();
    }

    /**
     * 普通的Set，去除重复
     */
    public static void set() {
        //普通的HashSet
        Set<Double> temperatures = new HashSet<>();
        //第一个36.5
        temperatures.add(36.5);
        temperatures.add(37.8);
        //第一个37.3
        temperatures.add(37.3);
        temperatures.add(38.4);
        temperatures.add(37.5);
        //第二个36.5
        temperatures.add(36.5);
        //第二个37.3
        temperatures.add(37.3);
        for (Double temp : temperatures) {
            System.out.println(temp);
        }
    }

    /**
     * 排序的Set，去除重复并排序
     */
    public static void sortSet() {
        //使用TreeSet
        Set<Double> temperatures = new TreeSet<>();
        //第一个36.5
        temperatures.add(36.5);
        temperatures.add(37.8);
        //第一个37.3
        temperatures.add(37.3);
        temperatures.add(38.4);
        temperatures.add(37.5);
        //第二个36.5
        temperatures.add(36.5);
        //第二个37.3
        temperatures.add(37.3);
        for (Double temp : temperatures) {
            System.out.println(temp);
        }
    }

}
