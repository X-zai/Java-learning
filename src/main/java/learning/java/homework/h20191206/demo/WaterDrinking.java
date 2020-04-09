/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.homework.h20191206.demo;

import javax.swing.JLabel;

/**
 * 饮水机后台程序
 * 
 * @author Rayliu40k
 * @version $Id: WaterDrinking.java, v 0.1 Dec 11, 2019 9:51:07 AM Rayliu40k Exp $
 */
public class WaterDrinking {

    /** 最大温水量 */
    private static final int MAX_WARM_WATER = 5000;

    /** 最大热水量 */
    private static final int MAX_HOT_WATER  = 5000;

    /** 是否锁住 */
    private boolean          locked         = true;

    /**
     * 饮水机工作状态
     * 
     * starting：出水中
     * boiling：烧水中
     * stopped：停止出水
     */
    private String           status         = "locked";

    /** 出水类型
     *  
     *  cold：冷水(默认)
     *  warm：温水
     *  hot：热水
     */
    private String           waterCategory  = "cold";

    /** 当前剩余温水量(ml) */
    private int              warmWater      = MAX_WARM_WATER;

    /** 当前剩余热水量(ml) */
    private int              hotWater       = MAX_HOT_WATER;

    /**
     * 解锁
     */
    public void unlock(JLabel label) {
        //只有当饮水机是锁住状态才能解锁
        if (this.locked) {
            //锁住状态 -> 解锁状态
            this.locked = false;
            label.setText("解锁成功");
        }
    }

    /**
     * 选择出水类型
     */
    public void selectWaterCategory(String waterCategory, String categoryDesc, JLabel label) {
        //如果饮水机不在解锁状态，不能选择出水类型
        if (this.locked) {
            label.setText("请先解锁");
            return;
        }
        //设置出水类型
        this.waterCategory = waterCategory;
        label.setText("选择" + categoryDesc);
    }

    /**
     * 出水
     */
    public void start(JLabel label) throws Exception {
        //如果饮水机在锁住状态，不能出水
        if (this.locked) {
            label.setText("请先解锁");
            return;
        }

        //如果正在烧水，也不能出水,显示正在烧水
        if (this.status.equals("boiling")) {
            label.setText("正在烧水，请耐心等待");
            return;
        }

        //如果正在出水，显示正在出水
        if (this.status.equals("starting")) {
            label.setText("正在出水");
            return;
        }
        //出水中
        this.status = "starting";
        if (this.waterCategory.equals("cold")) {
            //冷水
            String text = "冷水";
            //无限供应
            while (this.status.equals("starting")) {
                Thread.sleep(500);
                text += ">";
                label.setText(text);
            }
        } else if (this.waterCategory.equals("warm")) {
            //温水
            String warm = "";
            while (this.status.equals("starting") && this.warmWater > 0) {
                Thread.sleep(500);
                this.warmWater = this.warmWater - 100;
                warm += ">";
                label.setText("温水还剩" + this.warmWater + "ml" + warm);
            }
            //烧水
            this.status = "boiling";
            String boil = "";
            if (this.status.equals("boiling")) {
                //温水只要小于最大温水量就开始烧水
                while (this.warmWater < MAX_WARM_WATER) {
                    Thread.sleep(500);
                    this.warmWater = this.warmWater + 100;
                    boil += ">";
                    label.setText("温水不够了，开始自动烧水" + this.warmWater + "ml" + boil);
                }
                label.setText("温水准备好了，请享用");
                //停止出水
                this.status = "stopped";
                //锁住饮水机
                this.locked = true;
            }
        } else {
            //热水
            String hot = "";
            while (this.status.equals("starting") && this.hotWater > 0) {
                Thread.sleep(500);
                this.hotWater = this.hotWater - 100;
                hot += ">";
                label.setText("热水还剩" + this.hotWater + "ml" + hot);
            }
            //烧水
            this.status = "boiling";
            String boil = "";
            //热水只要小于最大热水量就开始烧水
            if (this.status.equals("boiling")) {
                while (this.hotWater < MAX_HOT_WATER) {
                    Thread.sleep(500);
                    this.status = "boiling";
                    this.hotWater = this.hotWater + 50;
                    boil += ">";
                    label.setText("热水不够了，开始自动烧水" + this.hotWater + "ml" + boil);
                }
                label.setText("热水准备好了，请享用");
                //停止出水
                this.status = "stopped";
                //锁住饮水机
                this.locked = true;
            }
        }
    }

    /**
     * 停止出水
     */
    public void stop() {
        //如果饮水机在出水中，才能停止出水
        if (this.status.equals("starting")) {
            this.status = "stopped";
        }
    }

}
