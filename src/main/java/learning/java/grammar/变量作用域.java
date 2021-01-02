/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 
 * @author Rayliu40k
 * @version $Id: 变量作用域.java, v 0.1 Oct 11, 2019 3:37:54 PM Rayliu40k Exp $
 */
public class 变量作用域 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 方法级变量、块级变量
     */
    public static void demo1() {
        //方法级变量j
        int j = 3;
        //if块级变量k
        if (j == 3) {
            int k = 5;
            //可以访问方法级变量j
            System.out.println("j=" + j);
            //可以访问if块级变量k
            System.out.println("k=" + k);
        }
        //可以访问方法级变量j
        System.out.println("j=" + j);
        //不能访问if块级变量k
        //System.out.println("k=" + k);
    }

    /**
     * 方法级变量、块级变量
     */
    public static void demo2() {
        //方法级变量j
        int j = 3;
        //for块级变量i
        for (int i = 0; i < 3; i++) {
            //可以访问方法级变量j
            System.out.println("j=" + j);
            //可以访问for块级变量i
            System.out.println("i=" + i);
        }
        //可以访问方法级变量j
        System.out.println("j=" + j);
        //这里不能访问变量i
        //System.out.println("i=" + i);
    }

    /**
     * 方法级变量、块级变量
     */
    public static void demo3() {
        //方法级变量j
        int j = 3;
        //while块级变量k
        while (j > 0) {
            int k = 5;
            //可以访问方法级变量j
            System.out.println("j=" + j);
            //可以访问while块级变量k
            System.out.println("k=" + k);
            j--;
        }
        //可以访问方法级变量j
        System.out.println("j=" + j);
        //不能访问while块级变量k
        //System.out.println("k=" + k);
    }

}
