/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Rayliu40k
 * @version $Id: 接收输入.java, v 0.1 Oct 8, 2019 4:39:52 PM Rayliu40k Exp $
 */
public class 接收输入 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        showInfoAndUserInput();
    }

    /**
     * 显示界面和用户选择
     */
    public static void showInfoAndUserInput() {
        String[] funcs = new String[] { "#1# 选择水类型：", "#1.1# 冷水", "#1.2# 热水", "#1.3# 温水", "#2# 解锁",
                                        "#3# 开始出水", "#4# 停止出水" };
        try {
            System.out.println("欢迎使用沁园饮水机，饮水机有如下功能：");
            for (int i = 0; i < funcs.length; i++) {
                System.out.println(funcs[i]);
            }
            System.out.println("请输入#之间的数字，选择功能：");

            //打开输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //读取一行
            String input = br.readLine();
            boolean selected = false;
            //判断选择的功能是什么
            for (int i = 0; i < funcs.length; i++) {
                if (funcs[i].split("#")[1].equals(input)) {
                    System.out.println("你选择的功能是：" + funcs[i]);
                    selected = true;
                    break;
                }
            }
            //判断是否选中
            if (!selected) {
                System.out.println("输入错误，请输入正确数字！");
            }
            //关闭输入流
            br.close();
        } catch (Exception e) {
            //处理异常
            e.printStackTrace();
        }
    }

}
