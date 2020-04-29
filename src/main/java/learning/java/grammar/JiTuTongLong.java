package learning.java.grammar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JiTuTongLong {

	public static void main(String[] args) {
		System.out.println("##########鸡兔同笼##########");
		for (int i = 3; i > 0; i--) {
			try {
				System.out.print("头__________________:");
				BufferedReader brm = new BufferedReader(new InputStreamReader(System.in));
				String inputm = brm.readLine();
				System.out.print("脚__________________:");
				BufferedReader brn = new BufferedReader(new InputStreamReader(System.in));
				String inputn = brn.readLine();
				// 头
				int m = Integer.valueOf(inputm);
				// 脚
				int n = Integer.valueOf(inputn);
				if (m <= 0) {
					System.err.println("未知错误!!!");
					System.exit(0);
				} else if (n <= 0) {
					System.err.println("未知错误!!!");
					System.exit(0);
				}
				int r = (4 * m - n) / 2;
				int j = (n - 2 * m) / 2;
				if (r < 0) {
					System.err.println("未知错误!!!");
					System.exit(0);
				} else if (j < 0) {
					System.err.println("未知错误!!!");
					System.exit(0);
				}
				System.out.println("笼子里有" + r + "只鸡，" + j + "只兔。");
				System.out.println("还有" + i + "次结束...             #");
				System.out.println("###########################");
			} catch (Exception e) {
				System.err.println("未知错误!!!");
				System.exit(0);
			}
		}
	}
}
