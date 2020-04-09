/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 条件判断1
 * 
 * @author Rayliu40k
 * @version $Id: 条件判断1.java, v 0.1 Aug 25, 2019 10:03:26 PM Rayliu40k Exp $
 */
public class 条件判断1 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 定义条件判断(表达式)
         */
        int a = 5;
        int b = 3;
        //条件：a - b > 3
        //如果条件满足，执行分支1
        //如果条件不满足，执行分支2代码
        if (a - b > 3) {
            //分支1代码
        } else {
            //分支2代码
        }

        /**
         * 定义多条件判断
         */
        //如果条件满足（a - b > 0），执行分支1
        //如果条件满足（a - b == 0），执行分支2代码
        //如果条件满足（a - b < 0），执行分支3代码
        //以上3个条件都不满足，执行分支4代码
        if (a - b > 0) {
            //分支1代码
        } else if (a - b == 0) {
            //分支2代码
        } else if (a - b <= 0) {
            //分支3代码
        } else {
            //分支4代码
        }
    }

}
