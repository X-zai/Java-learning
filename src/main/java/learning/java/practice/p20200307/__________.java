package learning.java.practice.p20200307;

import java.util.Calendar;
import java.util.Date;

public class __________ {
	public static int a = 7 + 8 + 5 + 1;
	public static int d = 0;

	public static void main(String[] args) throws Exception {
		int days = 0;
		while (true) {
			System.out.println("开始接收病人...");
			int weekday = getWeekday(new Date(), days);
			System.out.println("今天是星期" + (weekday - 1 == 0 ? "7" : weekday - 1));
			int patientNumber = getPatientNumber(weekday);
			System.out.println("今天入院：" + patientNumber + "人");
			d = d + patientNumber;
			System.out.println("当前总共空病房：" + a + "个");
			days++;
			Thread.sleep(100);
			System.out.println("第" + days + "天，过去了......");
			if (a == 0) {
				System.out.println("过了" + days + "天，医院住满了");
				System.exit(0);
			}
		}
	}

	private static int getWeekday(Date date, int nextDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, nextDay);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		return weekday;
	}

	private static int getPatientNumber(int weekDay) {
		if (weekDay == 2 || weekDay == 3 || weekDay == 4) {
			a--;
			return 4;
		} else if (weekDay == 5 || weekDay == 6) {
			a--;
			return 6;
		} else if (weekDay == 7 || weekDay == 1) {
			a--;
			return 8;
		} else {
			throw new RuntimeException("星期格式错误");
		}
	}
}
