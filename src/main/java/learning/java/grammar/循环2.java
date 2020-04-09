/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 循环2
 * 
 * @author Rayliu40k
 * @version $Id: 循环2.java, v 0.1 Aug 25, 2019 8:37:36 PM Rayliu40k Exp $
 */
public class 循环2 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 定义while循环：适合于不知道循环次数的场景
         */
        //表达式 a > b，控制循环是否执行，满足条件(表达式为真)，执行循环；不满足条件(表达式为假)，结束循环
        //语句意思：定义了一个循环语句，当 a > b 满足条件，循环做大括号里面要做的事情
        int a = 1;
        int b = 2;
        while (a > b) {
            //要做的事情
        }

        /**
         * 跳出本次循环
         */
        //语句意思：定义了一个循环语句，当i1 == 5条件判断满足，跳出本次循环(程序不执行//要做的事情)，继续下一次循环
        int i1 = 0;
        //继续下一次循环
        while (i1 < 10) {
            if (i1 == 5) {
                continue;
            }
            i1++;
            //要做的事情
        }

        int i2 = 0;
        //语句意思：定义了一个循环语句，当i2 == 5条件判断满足，结束整个循环，继续执行下面的代码
        while (i2 > 10) {
            if (i2 == 5) {
                break;
            }
            i2++;
            //要做的事情
        }
        System.out.println("结束循环，继续执行下面的代码");

        /**
         * 例子
         * 循环打印3次，“你好，小仔”
         */
        int i = 0;
        //当 i < 3 满足条件，循环做大括号里面要做的事情
        while (i < 3) {
            System.out.println("你好，小仔");
            //i = i + 1 的简写，把变量i自动+1，然后再一次执行i < 3
            i++;
        }

    }

}
