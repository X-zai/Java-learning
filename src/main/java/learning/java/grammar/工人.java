/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.grammar;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rayliu40k
 * @version $Id: 工人.java, v 0.1 Sep 13, 2020 10:57:23 AM Rayliu40k Exp $
 */
public class 工人 {

    public static void main(String[] args) throws Exception {
        mainPrint();
    }

    /**
     * 工人干活
     */
    public static void work() throws Exception {
        while (true) {
            System.out.println("管家：" + Thread.currentThread().getName() + "，开始分配工作...");
            //招一个新工人
            new Thread(() -> {
                //工人开始干活
                System.out.println("工人：" + Thread.currentThread().getName() + "你去干xxx");
                try {
                    Thread.sleep(((int) (Math.random() * 10) + 1) * 1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("管家：我(工人" + Thread.currentThread().getName() + ")的活干完了");
            }).start();
            Thread.sleep(3000);
        }
    }

    /**
     * 主管一人打印
     */
    public static void mainPrint() throws Exception {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(54);
        nums.add(55);
        nums.add(57);
        nums.add(58);
        nums.add(59);
        nums.add(60);
        for (Integer n : nums) {
            try {
                System.out.println("打印：" + n + "，主管：" + Thread.currentThread().getName() + "，开始工作");
                System.out.println("我累了，休息一下...");
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("活终于干完了");
    }

    /**
     * 多个工人打印
     */
    public static void workerPrint() throws Exception {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(54);
        nums.add(55);
        nums.add(57);
        nums.add(58);
        nums.add(59);
        nums.add(60);
        for (Integer n : nums) {
            new Thread(() -> {
                try {
                    System.out.println("打印" + n + "，工人：" + Thread.currentThread().getName());
                    System.out.println("我累了，休息一下...");
                    Thread.sleep(2147483647);
                    System.out.println("工人：" + Thread.currentThread().getName() + "，干完了");
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }).start();
        }
    }
}
