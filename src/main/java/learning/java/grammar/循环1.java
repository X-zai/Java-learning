/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 循环1
 * 
 * @author Rayliu40k
 * @version $Id: 循环1.java, v 0.1 Aug 25, 2019 8:37:36 PM Rayliu40k Exp $
 */
public class 循环1 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 定义for循环：适合于已经知道循环次数的场景
         */
        //int i = 0，定义控制循环次数的变量，并且给它一个值为0
        //i < 10，是否继续执行循环的条件，满足条件，继续执行循环；不满足条件，结束循环
        //每次把i + 1
        //语句意思：定义了一个循环语句，循环做10次大括号里面要做的事情
        for (int i = 0; i < 10; i++) {
            //要做的事情
        }

        /**
         * 跳出本次循环
         */
        //语句意思：定义了一个循环语句，当i == 5条件判断满足，跳出本次循环(程序不执行//要做的事情)，继续下一次循环
        //继续下一次循环
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            //要做的事情
        }

        /**
         * 结束循环
         */
        //语句意思：定义了一个循环语句，当i == 5条件判断满足，结束整个循环，继续执行下面的代码
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            //要做的事情
        }
        System.out.println("结束循环，继续执行下面的代码");

        /**
         * 例子1
         * 循环打印3次，“你好，小仔”
         */
        System.out.println("-------华丽的分割线-------");
        for (int i = 0; i < 3; i++) {
            //执行循环要做的事情
            System.out.println("你好，小仔");
        }

        /**
         * 例子2
         * 循环打印数组里面的数字
         */
        System.out.println("-------华丽的分割线-------");
        //定义数组并给数组赋值
        int[] name = new int[3];
        name[0] = 100;
        name[1] = 101;
        name[2] = 102;
        //循环打印数组里面的数字
        //记住：数组的长度不用去数，数组名称.length就表示数组的长度
        for (int i = 0; i < name.length; i++) {
            //执行循环要做的事情
            //因为每一次循环i的值都在变化，0、1、2、3、4...，所以name[i]每次都不一样
            //第1次循环：i = 0，name[i]就是name[0]
            //第2次循环：i = 1，name[i]就是name[1]
            //第3次循环：i = 2，name[i]就是name[2]
            System.out.println(name[i]);
        }
    }

}
