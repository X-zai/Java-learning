/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

/**
 * 文件操作
 * 
 * @author Rayliu40k
 * @version $Id: 文件.java, v 0.1 Dec 30, 2019 2:15:23 PM Rayliu40k Exp $
 */
public class 文件 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        create();
        write();
        other();
    }

    /**
     * 创建文件
     */
    public static void create() {
        //文件夹路径
        String filePath = "/Users/Rayliu40k/eclipse-workspace/java-learning/src/main/java/learning/java/grammar";
        //文件名
        String fileName = "myfile.txt";
        //文件完整路径(File.separator根据操作系统自动选择文件分隔符)
        String fullPath = filePath + File.separator + fileName;
        //创建一个File对象，告诉他文件完整路径
        File file = new File(fullPath);
        try {
            //创建一个新文件
            file.createNewFile();
            System.out.println("创建文件成功");
        } catch (IOException e) {
            System.out.println("创建文件失败");
            //捕捉创建文件过程中的异常
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     */
    public static void delete() {
        //文件夹路径
        String filePath = "/Users/Rayliu40k/eclipse-workspace/java-learning/src/main/java/learning/java/grammar";
        //文件名
        String fileName = "myfile.txt";
        //文件完整路径(File.separator根据操作系统自动选择文件分隔符)
        String fullPath = filePath + File.separator + fileName;
        File file = new File(fullPath);
        //删除一个文件
        file.delete();
    }

    /**
     * 写文件
     */
    public static void write() {
        //文件夹路径
        String filePath = "/Users/Rayliu40k/eclipse-workspace/java-learning/src/main/java/learning/java/grammar";
        //文件名
        String fileName = "myfile.txt";
        //文件完整路径(File.separator根据操作系统自动选择文件分隔符)
        String fullPath = filePath + File.separator + fileName;
        File file = new File(fullPath);
        try {
            //判断文件是否存在
            if (file.exists()) {
                //文件写入器
                //FileWriter fw = new FileWriter(file); 从文件开头写
                FileWriter fw = new FileWriter(file, true);//从最后写
                fw.write("This is my file,");
                //把缓存数据刷到文件
                fw.flush();
                //关闭资源
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读文件1
     */
    public static void read1() {
        //文件夹路径
        String filePath = "/Users/Rayliu40k/eclipse-workspace/java-learning/src/main/java/learning/java/grammar";
        //文件名
        String fileName = "myfile.txt";
        //文件完整路径(File.separator根据操作系统自动选择文件分隔符)
        String fullPath = filePath + File.separator + fileName;
        File file = new File(fullPath);

        try {
            //文件阅读器
            FileReader fr = new FileReader(file);
            //每次读到多少个字符
            char[] buf = new char[4];
            int num = 0;
            while ((num = fr.read(buf)) != -1) {
                System.out.println("这次读到" + num + "字符");
                System.out.println(buf);
            }
            //关闭资源
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 读文件2
     */
    public static void read2() {
        //文件夹路径
        String filePath = "/Users/Rayliu40k/eclipse-workspace/java-learning/src/main/java/learning/java/grammar";
        //文件名
        String fileName = "myfile.txt";
        //文件完整路径(File.separator根据操作系统自动选择文件分隔符)
        String fullPath = filePath + File.separator + fileName;
        File file = new File(fullPath);
        try {
            //带缓存的文件阅读器
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            //每次读一行
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            //关闭资源
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 其他功能
     */
    public static void other() {
        //文件夹路径
        String filePath = "/Users/Rayliu40k/eclipse-workspace/java-learning/src/main/java/learning/java/grammar";
        //文件名
        String fileName = "myfile.txt";
        //文件完整路径(File.separator根据操作系统自动选择文件分隔符)
        String fullPath = filePath + File.separator + fileName;
        File file = new File(fullPath);
        //是否存在
        System.out.println("是否存在:" + file.exists());
        //是否可读
        System.out.println("是否可读:" + file.canRead());
        //是否可写
        System.out.println("是否可写:" + file.canWrite());
        //是否可执行
        System.out.println("是否可执行:" + file.canExecute());
        //是否是文件
        System.out.println("是否是文件:" + file.isFile());
        //是否是目录
        System.out.println("是否是目录:" + file.isDirectory());
        //是否是隐藏文件
        System.out.println("是否是隐藏文件:" + file.isHidden());
        //得到文件名
        System.out.println("文件名:" + file.getName());
        //得到文件大小
        System.out.println("文件大小:" + file.length() + "B");
        //得到文件上层目录
        System.out.println("文件上层目录:" + file.getParent());
        //得到文件最后修改时间
        System.out.println("最后修改时间:" + new Date(file.lastModified()));
        //列出文件夹下面所有文件
        System.out.println("文件夹下面所有文件:");
        File parentFile = file.getParentFile();
        //如果是目录
        if (parentFile.isDirectory()) {
            File[] files = parentFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        }
    }

}
