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
 * 题目：走出5步迷宫 定义(随机定义)一个迷宫的5步方向，比如：起点 -> 前 -> 前 -> 左 -> 右 -> 左 -> 出口，
 * 如果5步的顺序和方向完全一样，提示走出迷宫；如果超过3分钟，还未走出迷宫，游戏结束。
 * 
 * 
 * @author Rayliu40k
 * @version $Id: P20191008.java, v 0.1 Oct 8, 2019 3:53:50 PM Rayliu40k Exp $
 */
public class P20191008 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 练习题
		loadGame();
		int o = 0;
		String[] fx = new String[5];
		for (int i = 0; i < fx.length; i++) {
			Random r = new Random();
			int step = r.nextInt(4);
			// 0代表前
			if (step == 0) {
				fx[i] = "w";
			} else if (step == 1) {
				fx[i] = "s";
			} else if (step == 2) {
				fx[i] = "a";
			} else {
				fx[i] = "d";
			}
		}

		Timer timer = new Timer(true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("The correct answer is:" + fx[0] + fx[1] + fx[2] + fx[3] + fx[4]);
				System.out.println("<<<Time's up.>>>");
				System.exit(0);
			}
		}, 20 * 1000, 8 * 1000);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("🐱‍🚀: 👇");
			String input = br.readLine();
			if (!input.equals("w") && !input.equals("s") && !input.equals("a") && !input.equals("d")) {
				System.out.println("[Warning] Please enter w, s, a, d.");
				continue;
			}
			if (input.equals(fx[0]) && o == 0) {
				o++;
				System.out.println("Please next step.");
				continue;
			} else if (input.equals(fx[1]) && o == 1) {
				o++;
				System.out.println("Please next step.");
				continue;
			} else if (input.equals(fx[2]) && o == 2) {
				o++;
				System.out.println("Please next step.");
				continue;
			} else if (input.equals(fx[3]) && o == 3) {
				o++;
				System.out.println("Please next step.");
				continue;
			} else if (input.equals(fx[4]) && o == 4) {
				System.out.println("<<<You win>>>");
				return;
			} else {
				System.out.println("[Warning] please retry once");
			}
		}

	}

	public static void loadGame() throws Exception {
		System.out.println("Game Loading......");
		System.out.println("Sorry, but this game is not available in Chinese (People's Republic of China) at this time.");
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
				Thread.sleep(20);
			}
			System.out.println();
		}
		System.out.println("Please enter w, s, a, d.");
	}
}
