/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.example;

/**
 * 
 * @author Rayliu40k
 * @version $Id: 记时操作.java, v 0.1 Oct 8, 2019 4:16:34 PM Rayliu40k Exp $
 */
public class 计时操作 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //开始时间
        long startTime = System.currentTimeMillis();

        //模拟程序耗时
        Thread.sleep(2000);

        //结束时间
        long endTime = System.currentTimeMillis();

        //程序耗时
        long usedTime = (endTime - startTime) / 1000;
        System.out.println(usedTime + "s");
    }

}
