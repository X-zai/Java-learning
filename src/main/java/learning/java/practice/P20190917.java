/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.practice;

/**
 * 
 * 题目：写一个方法，两次打印三角形
 * 
 *         *      
 *        ***     
 *       *****    
 *      *******
 *     
 * 提示：
 * 1、控制空格的个数
 *     |123*      第1行3个空格
 *     |12***     第2行2个空格
 *     |1*****    第3行1个空格
 *     |*******   第4行0个空格
 * 规律是什么？
 *    
 * 2、控制星星的个数
 *     |   *      第1行1个星星
 *     |  ***     第2行3个星星
 *     | *****    第3行5个星星
 *     |*******   第4行7个星星
 * 规律是什么？
 * 
 * @author Rayliu40k
 * @version $Id: P20190917.java, v 0.1 Sep 3, 2019 3:43:19 PM Rayliu40k Exp $
 */
public class P20190917 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        //练习题
    	drawRec();
    }
    
	public static void drawRec() {
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
