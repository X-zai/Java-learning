/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar.oop;

/**
 * 电脑类
 * 
 * @author Rayliu40k
 * @version $Id: Computer.java, v 0.1 Nov 21, 2019 4:35:16 PM Rayliu40k Exp $
 */
public class Computer {

    /**
     * ********************定义属性********************
     */

    /** 类型 */
    private String type;

    /** 品牌 */
    private String brand;

    /** 价格 */
    private double price;

    /** 颜色 */
    private String color;

    /** 英寸 */
    private double inch;

    /**
     * 构造方法
     * 
     */
    public Computer(String type, String brand, double price, String color, double inch) {
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.inch = inch;
    }

    /**
     * ********************定义行为********************
     */

    /**
     * 开机
     * public表示：公有方法，可以在类里面或外面使用
     */
    public void open() {
        //初始化电脑
        this.bios();
        System.out.println("主人，你好。我是您刚买的" + this.type + "电脑");
        System.out.println("我的信息如下：");
        System.out.println("品牌：" + this.brand);
        System.out.println("价格：" + this.price);
        System.out.println("颜色：" + this.color);
        System.out.println("尺寸：" + this.inch);
        System.out.println("正在为您开机，请耐心等待...");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("欢迎来到操作系统!");
    }

    /**
     * 关机
     * 
     * @param waitToClose 等待多久关机(s)
     */
    public void close(int waitToClose) {
        System.out.println(waitToClose + "s后关机...");
        try {
            Thread.sleep(1000 * waitToClose);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("正在关机...");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("黑屏");
    }

    /**
     * 初始化电脑
     * private表示：私有方法，只能在类里面使用
     */
    private void bios() {
        System.out.println("正在通过BIOS初始化电脑...");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("初始化成功!");
    }
}
