/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * 异常是程序中的一些错误。
 * 
 * 异常发生的原因有很多，通常包含以下几大类：
 * 1、用户输入了非法数。
 * 2、要打开的文件不存在。
 * 3、网络通信时连接中断，或者JVM内存溢出。
 * 
 * @author Rayliu40k
 * @version $Id: 异常.java, v 0.1 Aug 25, 2019 5:37:42 PM Rayliu40k Exp $
 */
public class 异常 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 语法
         */
        try {
            //代码
        } catch (Exception e) {
            //捕获异常，并处理
            //处理异常的代码
            //打印异常信息
            e.printStackTrace();
        }

        /**
         * 例子1
         * 
         * 用户输入了非法数据
         */
        System.out.print("请输入一个整数：");
        try {
            //获取控制台的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //读取一行
            String input = br.readLine();
            int num = Integer.valueOf(input).intValue();
            System.out.println("这是一个整数：" + num);
        } catch (Exception e) {
            //处理异常，仅仅打印错误提示信息
            System.out.println("⚠️请输入整数");
            e.printStackTrace();
        }

        /**
         * 例子2
         * 
         * 要打开的文件不存在
         */
        System.out.print("请输入文件路径：");
        try {
            //获取控制台的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //读取一行
            String filePath = br.readLine();
            //读取文件内容
            BufferedReader fr = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            while ((line = fr.readLine()) != null) {
                System.out.println(line);
            }
            //关闭文件
            fr.close();
        } catch (Exception e) {
            //处理异常，仅仅打印错误提示信息
            System.out.println("要打开的文件不存在");
            e.printStackTrace();
        }

        /**
         * 例子3
         * 
         * 判断接收数据类型
         */
        System.out.print("请输入：");

        try {
            //获取控制台的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //读取一行
            String line = br.readLine();
            //先判断输入的是否等于@符号，注意：判断String类型是否相等用 变量.equals(xxx)，不能用 变量 == xxx
            if (line.equals("@")) {
                System.out.println("接收到：@");
                //做你想要的操作
            } else {
                //把String类型转换成Int类型(获取输入的整数)
                int num = Integer.valueOf(line).intValue();
                System.out.println("接收到整数：" + num);
                //做你想要的操作
            }
            //关闭流
            br.close();
        } catch (Exception e) {
            //处理异常，仅仅打印错误提示信息
            System.out.println("⚠️请输入整数");
            e.printStackTrace();
        }

    }

}
