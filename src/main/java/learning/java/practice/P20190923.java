/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.practice;

/**
 * 
 * 题目：打印以下图形
 * 
 *    12345
 * 1    #  
 * 2  # # #
 * 3    #  
 * 
 * @author Rayliu40k
 * @version $Id: P20190923.java, v 0.1 Sep 3, 2019 3:43:19 PM Rayliu40k Exp $
 */
public class P20190923 {

    /**
     * 
     * @param args
     */
	public static void main(String[] args) throws Exception {
		// 练习题
		for (int i = 1; i <= 3; i++) {
			for (int o = 1; o <= 5; o++) {
				if ((i == 1) && (o == 3)) {
					System.out.print("#");
				} else if ((i == 2) && (o == 1 || o == 3 || o == 5)) {
					System.out.print("#");
				} else if ((i == 3) && (o == 3)) {
					System.out.print("#");
				} else {
					Thread.sleep(500);
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
