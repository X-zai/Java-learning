package learning.java.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 北京时间 {

    public static void main(String[] args) throws Exception {
        System.out.println(getNextDay(0));
    }

    /**
     * 获得当前日期
     */
    private static void getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd号 HH时mm分ss秒");
        System.out.println("当前时间为：" + sdf.format(new Date()));
    }

    /**
     * 获得当前是星期几
     */
    private static String getWeek() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        int weekday = cal.get(Calendar.DAY_OF_WEEK);
        String week = "";
        if (weekday == 1) {
            week = "周日";
        } else if (weekday == 2) {
            week = "周一";
        } else if (weekday == 3) {
            week = "周二";
        } else if (weekday == 4) {
            week = "周三";
        } else if (weekday == 5) {
            week = "周四";
        } else if (weekday == 6) {
            week = "周五";
        } else if (weekday == 7) {
            week = "周六";
        }
        return week;
    }

    /**
     * 获取几天以后是星期几
     */
    public static String getNextDay(int nextDay) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, nextDay);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        String week = "";
        if (weekday == 1) {
            week = "周日";
        } else if (weekday == 2) {
            week = "周一";
        } else if (weekday == 3) {
            week = "周二";
        } else if (weekday == 4) {
            week = "周三";
        } else if (weekday == 5) {
            week = "周四";
        } else if (weekday == 6) {
            week = "周五";
        } else if (weekday == 7) {
            week = "周六";
        }
        return week;
    }

}
