/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import java.io.File;

/**
 * 扫描磁盘下面所有文件
 * 
 * @author Rayliu40k
 * @version $Id: 扫描文件夹.java, v 0.1 Jan 2, 2020 9:24:07 AM Rayliu40k Exp $
 */
public class 扫描文件 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        //参数
        int[] stat = new int[] { 0, 0 };
        String path = "/usr/local";
        String suffix = ".ini";
        //扫描
        long start = System.currentTimeMillis();
        findFiles(path, suffix, stat);
        long end = System.currentTimeMillis();
        //统计
        System.out.println("############");
        System.out.println("耗时：" + (end - start) + " ms");
        System.out.println("共扫描：" + stat[0] + "个文件");
        System.out.println("共找到：" + stat[1] + "个目标文件");
    }

    /**
     * 递归查找文件
     * 
     * @param path 文件路径
     * @param suffix 后缀
     */
    public static void findFiles(String path, String suffix, int[] stat) {

        File file = new File(path);
        //文件是否存在
        if (file.exists()) {
            //列出所有文件
            File[] files = file.listFiles();
            //文件夹是否是空的
            if (null == files || files.length == 0) {
                System.out.println("空文件夹：" + path);
                return;
            } else {
                for (int i = 0; i < files.length; i++) {
                    //文件是否是目录
                    if (files[i].isDirectory()) {
                        //是，继续递归调用
                        findFiles(files[i].getAbsolutePath(), suffix, stat);
                    } else {
                        //统计文件总数
                        stat[0]++;
                        //否，打印文件
                        String fileName = files[i].getName();
                        //文件名是否包括后缀
                        if (fileName.contains(suffix)) {
                            //统计目标文件总数
                            stat[1]++;
                            System.out.println("-----------------");
                            System.out.println("文件类型：" + suffix);
                            System.out.println("文件名：" + fileName);
                            System.out.println("文件路径：" + files[i].getPath());
                            System.out.println("文件大小：" + files[i].length() + "B");
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在");
        }
    }
}
