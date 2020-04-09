/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.practice.p20200307;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Rayliu40k
 * @version $Id: Demo.java, v 0.1 Mar 10, 2020 2:39:14 PM Rayliu40k Exp $
 */
public class Demo {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {

        //总病人数
        int totalPatientNumber = 0;
        //总病床数量
        int totalPatientBed = 4 * 7 + 6 * 8 + 8 * 5;
        int days = 0;
        //只要总病人数 < 总病床数量，可以接收病人
        while (totalPatientNumber < totalPatientBed) {
            System.out.println("开始接收病人...");
            //获取当天是星期几
            int weekday = getWeekday(new Date(), days);
            System.out.println("今天是星期" + (weekday - 1 == 0 ? "日" : weekday - 1));
            //当天入院人数
            int patientNumber = getPatientNumber(weekday);
            System.out.println("今天入院：" + patientNumber + "人");
            //计算当前总病人数
            totalPatientNumber = totalPatientNumber + patientNumber;
            System.out.println("当前总病人：" + totalPatientNumber + "人");
            days++;
            Thread.sleep(100);
            System.out.println("第" + days + "天，过去了......");
        }
        System.out.println("过了" + days + "天，医院住满了");

    }

    /**
     * 获取当天是星期几
     * 
     * @param date 当天日期
     * @param nextDay 当天以后几天
     * @return 星期几
     */
    private static int getWeekday(Date date, int nextDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, nextDay);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    /**
     * 当天入院人数
     * 
     * @param weekDay 星期几
     * @return 入院人数
     */
    private static int getPatientNumber(int weekDay) {
        if (weekDay == 2 || weekDay == 3 || weekDay == 4) {
            //星期1、2、3，入院4人
            return 4;
        } else if (weekDay == 5 || weekDay == 6) {
            //星期4、5，入院6人
            return 6;
        } else if (weekDay == 7 || weekDay == 1) {
            //星期6、7，入院8人
            return 8;
        } else {
            throw new RuntimeException("星期格式错误");
        }
    }
}
