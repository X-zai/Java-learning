/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.grammar.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * List(列表)，列表是Collection的一种，列表中的元素是有序的，且允许重复。
 * 
 * @author Rayliu40k
 * @version $Id: 列表.java, v 0.1 Feb 26, 2020 10:42:53 AM Rayliu40k Exp $
 */
public class 列表 {

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		add();
		sort();
	}

	/**
	 * 添加元素
	 */
	public static void add() {
		// 整形列表，存放整形变量
		List<Integer> ages = new ArrayList<Integer>();
		ages.add(88);
		ages.add(18);
		ages.add(25);
		int[] a = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;

		// 不能写int，因为容器只能存放类类型，不能存放基本类型，如：short，int，long，float，double，char，boolean
		// 错误写法：List<int> ages = new ArrayList<int>();
		// 基本类型对应的类类型
		// short -> Short
		// int -> Integer
		// long -> Long
		// float -> Float
		// double -> Double
		// char -> Char
		// boolean -> Boolean
	}

	/**
	 * 取元素
	 */
	public static void get() {
		List<Integer> ages = new ArrayList<Integer>();
		ages.add(88);
		ages.add(18);
		ages.add(25);
		// 取第1个元素
		Integer age1 = ages.get(0);
		System.out.println(age1);
		// 取第2个元素
		Integer age2 = ages.get(1);
		System.out.println(age2);
		// 取第3个元素
		Integer age3 = ages.get(2);
		System.out.println(age3);
	}

	/**
	 * 循环列表
	 */
	public static void print() {
		List<Integer> ages = new ArrayList<Integer>();
		ages.add(88);
		ages.add(18);
		ages.add(25);
		// 1.原始写法
		for (int i = 0; i < ages.size(); i++) {
			System.out.println(ages.get(i));
		}
		// 2.现代版本
		for (Integer age : ages) {
			System.out.println(age);
		}
		// 3.流式写法
		ages.stream().forEach(age -> {
			System.out.println(age);
		});
	}

	/**
	 * 删除元素
	 */
	public static void remove() {
		List<Integer> ages = new ArrayList<Integer>();
		ages.add(88);
		ages.add(18);
		ages.add(25);

		// 删除第1个元素，88
		ages.remove(0);
		// 直接删除25这个元素
		ages.remove(new Integer(25));

		ages.stream().forEach(age -> {
			System.out.println(age);
		});
	}

	/**
	 * 列表排序
	 */
	public static void sort() {
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(88);
		scores.add(18);
		scores.add(25);
		scores.add(39);
		scores.add(77);
		scores.add(89);

		// 正序
		scores.sort(Comparator.naturalOrder());
		System.out.println("正序：" + scores);

		// 倒序
		scores.sort(Comparator.reverseOrder());
		System.out.println("倒序：" + scores);
	}

	/**
	 * 是否包含某元素
	 */
	public static void contains() {
		List<String> students = new ArrayList<String>();
		students.add("小张");
		students.add("小仔");
		students.add("小林");

		// 是否包含某元素
		if (students.contains("小仔")) {
			System.out.println("小仔在里面");
		} else {
			System.out.println("小仔不在里面");
		}
	}

	/**
	 * 列表数组互转
	 */
	public static void toArray() {
		List<String> students = new ArrayList<String>();
		students.add("小张");
		students.add("小仔");
		students.add("小林");

		// 列表转数组
		String[] studentsArray = students.toArray(new String[students.size()]);
		for (String student : studentsArray) {
			System.out.println(student);
		}

		// 数组转列表
		String[] colors = new String[] { "red", "green", "blue" };
		List<String> colorsList = Arrays.asList(colors);
		colorsList.stream().forEach(color -> {
			System.out.println(color);
		});
	}
}
