/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 变量
 * 
 * @author Rayliu40k
 * @version $Id: 变量.java, v 0.1 Aug 25, 2019 5:37:42 PM Rayliu40k Exp $
 */
public class 变量 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 定义变量
         */
        //int 变量类型，name 变量名称
        //语句意思：定义了一个int类型的变量，名称为name
        int name;

        /**
         * 变量赋值
         */
        //= 赋值符号，8 变量的值
        //语句意思：给一个int类型的变量一个值为8
        name = 8;

        /**
         * 定义变量并赋值
         */
        //语句意思：定义了一个int类型的变量，名称为other，并且给它一个值为7
        int other = 7;

        /**
         * 打印变量
         */
        //语句意思：打印变量name到控制台
        System.out.println(name);

        /**
         * 基本变量类型
         */
        //短整形，放整数，范围：-32768 ~ 32767
        short name1 = 32767;
        //整形，放整数，范围：-2147483648 ~ 2147483647
        int name2 = 2147483647;
        //长整形，放整数，范围：-9223372036854775808 ~ 9223372036854775807
        long name3 = 9223372036854775807l;
        //小数类型，单精度，放小数
        float name4 = 1.3f;
        //小数类型，双精度，放小数
        double name5 = 1.5;
        //字符类型，放字符，只能放一个字符
        char name6 = 'a';
        char name7 = '我';
        //布尔类型，值只可以为true或者false
        boolean name8 = true;
        boolean name9 = false;

    }

}
