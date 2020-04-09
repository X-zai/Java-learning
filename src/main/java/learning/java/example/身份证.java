/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

/**
 * 解析身份证号
 * 
 * @author Rayliu40k
 * @version $Id: 身份证.java, v 0.1 Mar 30, 2020 1:40:46 PM Rayliu40k Exp $
 */
public class 身份证 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        //身份证号码，格式：区域编码 + 出生年月日 + 性别
        String cardNo = "510104198403254118";

        String area = "";
        //1-6位：区域编码
        area = cardNo.substring(0, 6);
        System.out.println("区域编码：" + area);

        //6-14位：出生年月日
        String birthday = "";
        birthday = cardNo.substring(6, 14);
        System.out.println("出生年月日：" + birthday);

        //年
        int year;
        year = Integer.parseInt(birthday.substring(0, 4));
        System.out.println("年：" + year);

        //月
        int month;
        month = Integer.parseInt(birthday.substring(4, 6));
        System.out.println("月：" + month);

        //日
        int day;
        day = Integer.parseInt(birthday.substring(6));
        System.out.println("日：" + day);

        //17位：性别，单数为男,双数为女
        String sex = "";
        sex = cardNo.substring(cardNo.length() - 2, cardNo.length() - 1);
        if (Integer.valueOf(sex) % 2 != 0) {
            System.out.println("性别：男");
        } else {
            System.out.println("性别：女");
        }

    }

}
