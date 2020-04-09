package learning.java.practice.p20200307;

import java.util.Calendar;
import java.util.Date;

public class PatientRoom {

	public static void main(String[] args) throws Exception {
		int a = 7;
		int b = 8;
		int c = 5;
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		String week = "";
		int peple = 0;
		for (;;) {
			if (weekday == 1) {
				week = "周日";
				peple = 8;
				weekday = 2;
			} else if (weekday == 2) {
				week = "周一";
				peple = 4;
				weekday = 3;
			} else if (weekday == 3) {
				week = "周二";
				peple = 4;
				weekday = 4;
			} else if (weekday == 4) {
				week = "周三";
				peple = 4;
				weekday = 5;
			} else if (weekday == 5) {
				week = "周四";
				peple = 6;
				weekday = 6;
			} else if (weekday == 6) {
				week = "周五";
				peple = 6;
				weekday = 7;
			} else if (weekday == 7) {
				week = "周六";
				peple = 8;
				weekday = 1;
			}
			System.out.println("今天是" + week);
			Thread.sleep(100);
		}

	}
}
