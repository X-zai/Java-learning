/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar.oop;

/**
 * 
 * @author Rayliu40k
 * @version $Id: Test.java, v 0.1 Nov 21, 2019 4:55:37 PM Rayliu40k Exp $
 */
public class Test {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        //创建Computer对象
        Computer mac = new Computer("笔记本", "Mac", 18900, "深空灰", 15.5);
        //开机
        mac.open();
        //模拟工作
        work();
        //关机
        mac.close(3);

        Computer ibm = new Computer("笔记本", "IBM", 8500, "黑色", 16);
        //开机
        mac.open();
        //模拟工作
        work();
        //关机
        ibm.close(5);
    }

    /**
     * 模拟工作
     */
    public static void work() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                
            }
            System.out.println("工作中...");
        }
    }
}
