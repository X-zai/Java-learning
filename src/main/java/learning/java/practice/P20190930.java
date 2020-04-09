/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 游戏：猜数字
 * 
 * 游戏规则：随便输入一个整数，计算机会提示你，当前的数字和目标数字之间的关系： 
 * 1、当前的数字 大于 目标数字 
 * 2、当前的数字 小于 目标数字
 * 3、当前的数字 等于 目标数字（猜中了） 如果没有猜中，计算机会继续提示你，你总共有5次机会，机会用完还没有猜中，游戏结束。
 * 
 * @author Rayliu40k
 * @version $Id: P20190930.java, v 0.1 Sep 3, 2019 3:43:19 PM Rayliu40k Exp $
 **/
public class P20190930 {

	// 游戏重试机会
	private static int retryChance = 5;
	// 游戏求助机会
	private static int helpChance = 3;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 加载游戏
		loadGame();
		// 目标数字
		Random r = new Random();
		int target = r.nextInt(70);
		// 标记用户上次是否求助成功
		boolean lastOperationIsHelp = false;
		// 保存用户输入的整数的变量
		int num = 0;

		// 打开控制台输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 计时器
		Timer timer = new Timer(true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				retryChance++;
				helpChance++;
			}
		}, 0, 20 * 1000);

		Timer time = new Timer(true);
		time.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("The correct answer is:" + target + ".");
				System.out.println("<<<Time's up.>>>");
				System.exit(0);
			}
		}, 60 * 1000, 5 * 1000);

		// 游戏开始
		while (retryChance > 0) {

			System.out.print("Please input integer within 70,if you need help please input ?：");
			// 接受输入
			String input = br.readLine();

			// 校验输入是否合法(只能是数字或问号)
			if (!isNumber(input) && !input.equals("?") && !input.equals("？")) {
				System.out.println("[Warning] Only integer or ?");
				continue;
			}

			// 未输入数字之前，不能输入问号
			if (num == 0 && (input.equals("?") || input.equals("？"))) {
				System.out.println("[Warning] You should input integer first.");
				continue;
			}

			// 求助逻辑
			// 1.上次求助成功，不能连续求助
			if ((input.equals("?") || input.equals("？")) && lastOperationIsHelp) {
				System.out.println("[Warning] Sorry,you can't ask for help twice.");
				continue;
			} else if ((input.equals("?") || input.equals("？")) && helpChance <= 0) {
				// 2.输入问号，但已经没有机会
				System.out.println("[Warning] Sorry,you have no chance.");
				continue;
			} else if (input.equals("?") || input.equals("？") && helpChance > 0) {
				// 3.输入问号，还有机会
				// 执行帮助
				// 解释：Math.abs(num - target)方法，作用：求 num - target 绝对值
				if (Math.abs(num - target) <= 5) {
					System.out.println("within 5");
				} else if (Math.abs(num - target) <= 10) {
					System.out.println("within 10");
				} else {
					System.out.println("too far");
				}
				helpChance--;
				System.out.println("You have " + helpChance + " chances to help.");
				// 标记上次求助成功
				lastOperationIsHelp = true;
				// 求助完毕，重新输入
				continue;
			}

			// 游戏判断逻辑
			// 标记用户上次是游戏操作
			lastOperationIsHelp = false;
			num = Integer.valueOf(input).intValue();
			if (num > target) {
				System.out.println(num + " > target number");
				retryChance--;
				if (retryChance != 0) {
					System.out.println("You have " + retryChance + " chances to play.");
				}
				continue;
			} else if (num < target) {
				System.out.println(num + " < target number");
				retryChance--;
				// 如果已经没有机会了，就不显示还剩多少次机会
				if (retryChance != 0) {
					System.out.println("You have " + retryChance + " chances to play.");
				}
				continue;
			} else {
				System.out.println("The target number is " + target + ".");
				System.out.println("<<<You Win>>>");
				return;
			}

		}
		// 关闭控制台
		br.close();
		// 公布答案
		System.out.println("The target number is " + target + ".");
		System.out.println("<<<Game Over>>>");
	}

	/**
	 * 加载游戏
	 */
	public static void loadGame() throws Exception {
		System.out.println("Game Loading......");
		System.out
				.println("Sorry, but this game is not available in Chinese (People's Republic of China) at this time.");
		String[] text = { "Resist bad games and refuse pirated games",
				"Pay attention to self-protection and guard against being deceived",
				"Moderate games benefit the brain, indulge in games injure the body",
				"Reasonable arrangement of time and enjoyment of healthy life" };
		// 外层循环打印每一行
		for (int i = 0; i < text.length; i++) {
			String line = text[i];
			// 内层循环打印每一个字
			char[] chars = line.toCharArray();
			for (int j = 0; j < chars.length; j++) {
				System.out.print(chars[j]);
				Thread.sleep(10);
			}
			System.out.println();
		}
	}

	/**
	 * 判断是否是整数
	 */
	public static boolean isNumber(String input) {
		boolean isNumber = true;
		try {
			Integer.valueOf(input).intValue();
		} catch (Exception e) {
			isNumber = false;
		}
		return isNumber;
	}

}
