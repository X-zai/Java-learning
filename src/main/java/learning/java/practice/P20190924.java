/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.practice;

/**
 * 
 * 题目：打印扫把
 * 
 *    1234567
 * 1     #  
 * 2     ###
 * 3     #
 * 4     #  
 * 5     #
 * 6     #
 * 7    ###
 * 8   #####
 * 9  #######
 *    
 * @author Rayliu40k
 * @version $Id: P20190924.java, v 0.1 Sep 3, 2019 3:43:19 PM Rayliu40k Exp $
 */
public class P20190924 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //练习题
        //打印小拐杖
        //控制行数
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 7; j++) {
                //第4列打印#；或者第2行，第5、6列打印#
                if (j == 4 || (i == 2 && (j == 5 || j == 6))) {
                    System.out.print("#");
                } else {
                    //其他都打印空格
                    System.out.print(" ");
                }
            }
            //打印完每一行最后一个#换行
            System.out.println();
        }
        //打印三角形
        //控制行数
        for (int i = 1; i <= 4; i++) {
            //每一行的空格数
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            //每一行的星星数
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("#");
            }
            //打印完每一行最后一个星星换行
            System.out.println();
        }
    }

}
