/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.homework;

/**
 * 
 * 题目：打印一个房子

 *     1234567891111
 *              0123
 *  1   ###########
 *  2  ####     ####
 *  3  #############       
 *  4  #           #
 *  5  #           #
 *  6  #           #
 *  7  #############           
 * 
 * @author Rayliu40k
 * @version $Id: H20190924.java, v 0.1 Sep 3, 2019 3:43:19 PM Rayliu40k Exp $
 */
public class H20190924 {

    /**
     * 
     * @param args
     */
	public static void main(String[] args) throws Exception {
		// 作业
		for (int i = 1; i <= 2; i++) {
			for (int o = 1; o <= 13; o++) {
				if ((i == 1 && o == 1) || (i == 1 && o == 13)) {
					System.out.print(" ");
				} else if ((i == 2) && (o == 5 || o == 6 || o == 7 || o == 8 || o == 9)) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		for (int i = 1; i <= 5; i++) {
			for (int o = 1; o <= 13; o++) {
				if ((i == 2 || i == 3 || i == 4) && (o == 2 || o == 3 || o == 4 || o == 5 || o == 6 || o == 7 || o == 8
						|| o == 9 || o == 10 || o == 11 || o == 12)) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}
}
