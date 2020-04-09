/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 
 * 方法定义：代码的集合，它们在一起执行一个功能，可以反复使用。
 * 
 * 方法格式：
 * 
 * 修饰符 返回值类型 方法名(参数类型 参数名){ ... 代码的集合 ... return 返回值; }
 * 
 * 修饰符：static、public、protected、private
 * 返回值类型：byte、short、int，long、float，double、boolean、char...
 * 方法名：任意取名，和变量名一样，需要清楚表示这个方法要做的事情
 * 参数类型：byte、short、int，long、float，double、boolean、char... 参数名：和变量名一样
 * 
 * @author Rayliu40k
 * @version $Id: 方法.java, v 0.1 Aug 25, 2019 8:37:36 PM Rayliu40k Exp $
 */
public class 方法 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 使用方法
		 */
		int a = 12;
		int b = 3;
		// 使用方法
		int c = max(a, b);
		System.out.println("较大值为：" + c);

		String feature = "有胡子";
		// 使用方法
		String result = manOrWoman(feature);
		System.out.println(result);

		// 使用方法
		drawRec(50, 100);
	}

	/**
	 * 例子1
	 * 
	 * 返回两个整型变量中较大值
	 * 
	 * @param num1 第一个数字
	 * @param num2 第二个数字
	 * @return 返回较大值
	 * 
	 */
	public static int max(int num1, int num2) {
		int max = 0;
		if (num1 > num2) {
			max = num1;
		} else {
			max = num2;
		}
		return max;
	}

	/**
	 * 例子2
	 * 
	 * 根据特征判断性别
	 * 
	 * @param feature 特征
	 * @return 性别结果
	 */
	public static String manOrWoman(String feature) {
		System.out.println("-------华丽的分割线-------");
		String result = "";
		switch (feature) {
		case "有喉结":
		case "有胡子":
		case "爱抽烟":
			// 当特征值满足喉结、胡子、抽烟中任意一个，执行分支语句1
			// 分支语句1
			result = "男人";
			// 结束switch语句
			break;
		case "长头发":
		case "戴耳环":
		case "爱化妆":
			// 当特征满足值长头发、戴耳环、化妆中任意一个时，执行分支语句2
			// 分支语句2
			result = "女人";
			// 结束switch语句
			break;
		}
		return "可能是个" + result;
	}

	/**
	 * 例子3
	 * 
	 * 打印长方形
	 * 
	 * @param line 行数
	 * @param row  列数
	 */
	public static void drawRec(int line, int row) {
		System.out.println("-------华丽的分割线-------");
		// 外层循环控制行数
		for (int i = 1; i <= line; i++) {
			// 内层循环控制列数
			for (int j = 1; j <= 2 * i - 1; j++) {
				// 每循环一次打一个💢
				System.out.print("💢");
			}
			// 每打完一行就换行
			System.out.println();
		}
	}
}
