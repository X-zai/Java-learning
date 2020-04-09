/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.homework;

/**
 * 
 * 题目：写一个方法，两次打印空心正方形

 *     123456    
 *  1  ######
 *  2  #    #
 *  3  #    #
 *  4  #    #
 *  5  ######
 *     
 * 提示：
 * 1、嵌套循环，外层循环控制行数，内层循环控制#个数。
 * 2、第1、5行全部打印#，第2、3、4行有的打印#、有的打印空格。
 * 
 * @author Rayliu40k
 * @version $Id: H20190917.java, v 0.1 Sep 3, 2019 3:43:19 PM Rayliu40k Exp $
 */
public class H20190917 {

    /**
     * 
     * @param args
     */
	public static void main(String[] args) throws Exception {
		// 作业
		for (int i = 1; i <= 5; i++) {
			for (int o = 1; o <= 6; o++) {
				if ((i == 2 || i == 3 || i == 4) && (o == 2 || o == 3 || o == 4 || o == 5)) {
					System.out.print(" ");
				} else {
					System.out.print("#");
					Thread.sleep(300);
				}
			}
			System.out.println();
		}
	}
}
