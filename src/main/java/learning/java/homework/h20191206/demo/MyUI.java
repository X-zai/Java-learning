/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.homework.h20191206.demo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * 饮水机界面
 * 
 * @author Rayliu40k
 * @version $Id: MyUI.java, v 0.1 Dec 11, 2019 11:24:19 AM Rayliu40k Exp $
 */
public class MyUI {

    public static void main(String[] args) {

        //创建窗口
        JFrame jf = new JFrame("全国驰名品牌-小仔饮水机");
        jf.setSize(300, 400);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        //创建布局01
        GridLayout layout01 = new GridLayout(2, 2);
        //创建面板01
        JPanel panel01 = new JPanel(layout01);
        //创建按钮
        JButton unlock = new JButton("解锁");
        JButton coldWater = new JButton("冷水");
        JButton warmWater = new JButton("温水");
        JButton hotWater = new JButton("热水");
        JButton start = new JButton("开始出水");
        JButton stop = new JButton("停止出水");
        //添加按钮到面板01
        panel01.add(unlock);
        panel01.add(coldWater);
        panel01.add(warmWater);
        panel01.add(hotWater);
        panel01.add(start);
        panel01.add(stop);

        //创建布局02
        FlowLayout layout02 = new FlowLayout();
        //创建面板02
        JPanel panel02 = new JPanel(layout02);
        //创建标签
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(300, 100));
        //添加标签到面板02
        panel02.add(label);

        //创建箱式布局
        Box box = Box.createVerticalBox();
        //添加面板01、面板02
        box.add(panel01);
        box.add(panel02);

        jf.setContentPane(box);
        jf.setVisible(true);

        //饮水机后台程序
        WaterDrinking wd = new WaterDrinking();

        //开始监听事件
        //解锁
        unlock.addActionListener(e -> {
            wd.unlock(label);
        });

        //冷水
        coldWater.addActionListener(e -> {
            wd.selectWaterCategory("cold", e.getActionCommand(), label);
        });

        //温水
        warmWater.addActionListener(e -> {
            wd.selectWaterCategory("warm", e.getActionCommand(), label);
        });

        //热水
        hotWater.addActionListener(e -> {
            wd.selectWaterCategory("hot", e.getActionCommand(), label);
        });

        //出水
        start.addActionListener(e -> {
            new Thread(() -> {
                try {
                    wd.start(label);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        });

        //停止
        stop.addActionListener(e -> {
            wd.stop();
        });

    }

}
