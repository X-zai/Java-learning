package learning.java.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class H20191108 {

	public static void main(String[] args) {
		for (;;) {
			System.out.println("🐱‍🚀Please enter a number of palindromes and 5 digits👇：");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = 0;
			try {
				String input = br.readLine();
				input = input.replaceAll("	", "");
				input = input.replaceAll(" ", "");
				num = Integer.valueOf(input).intValue();
			} catch (Exception e) {
				System.out.println("❌");
				continue;
			}
			int gewei = num % 10;
			int shiwei = (num / 10) % 10;
			int qianwei = (num / 1000) % 10;
			int wanwei = (num / 10000) % 10;
			if (gewei == wanwei && shiwei == qianwei) {
				System.out.println("✔");
			} else {
				System.out.println("❌");
			}
		}

	}
}
