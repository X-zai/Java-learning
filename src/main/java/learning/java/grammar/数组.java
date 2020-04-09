/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 数组
 * 
 * @author Rayliu40k
 * @version $Id: 数组.java, v 0.1 Aug 25, 2019 6:04:27 PM Rayliu40k Exp $
 */
public class 数组 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 定义数组
         */
        //int[] 数组类型，name 数组名称
        //语句意思：定义了一个int类型的数组，名称为name
        int[] name = new int[3];

        /**
         * 数组赋值
         */
        //语句意思：给数组name下标为0的元素（第1个元素）放一个值为10
        name[0] = 10;
        //语句意思：给数组name下标为1的元素（第2个元素）放一个值为20
        name[1] = 20;
        //语句意思：给数组name下标为2的元素（第3个元素）放一个值为20
        name[2] = 30;

        /**
         * 定义数组并赋值
         */
        //语句意思：定义了一个int类型的数组，名称为name，并且给数组name放入3个值，10，20，30
        int[] other = { 10, 20, 30 };

        /**
         * 打印数组元素
         */
        //语句意思：打印数组name下标为0的元素（第1个元素）
        System.out.println(name[0]);

        /**
         * 其他数组类型，所有变量类型都对应有数组类型
         */
        //小数类型数组
        double[] name1 = new double[2];
        name1[0] = 82.4;
        name1[1] = 34.55;

        //字符类型数组
        char[] name2 = new char[2];
        name2[0] = '小';
        name2[1] = '仔';

        //布尔类型数组
        boolean[] name3 = { true, false };

    }

}
