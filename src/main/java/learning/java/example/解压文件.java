/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 
 * @author Rayliu40k
 * @version $Id: 解压文件.java, v 0.1 Aug 31, 2020 9:45:09 AM Rayliu40k Exp $
 */
public class 解压文件 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        //Zip源文件
        File srcFile = new File(
            "C:/Users/Xzai/Downloads/eclipse-java-2020-06-R-win32-x86_64.zip");
        //解压后的目标文件夹
        String destDirPath = "C:/Users/Xzai/Desktop/xxx";
        unZip(srcFile, destDirPath);
    }

    /**
     * Zip解压  
     * @param srcFile        Zip源文件
     * @param destDirPath     解压后的目标文件夹
     * @throws RuntimeException 解压失败会抛出运行时异常
     */
    public static void unZip(File srcFile, String destDirPath) throws RuntimeException {

        //开始时间
        long start = System.currentTimeMillis();

        //判断Zip源文件是否存在
        if (!srcFile.exists()) {
            throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
        }

        //开始解压
        ZipFile zipFile = null;
        try {
            //构造ZipFile对象
            zipFile = new ZipFile(srcFile);
            //获取Zip源文件的实体列表
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                //获取每一个实体
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println("解压" + entry.getName());
                //如果是文件夹，就创建个文件夹
                if (entry.isDirectory()) {
                    String dirPath = destDirPath + File.separator + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    //如果是文件，就先创建一个文件，然后用I/O流把内容copy过去
                    File targetFile = new File(destDirPath + File.separator + entry.getName());
                    //保证这个文件的父文件夹必须要存在
                    if (!targetFile.getParentFile().exists()) {
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    //将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    //第一种写法(每次读1个字节)
                    //                    int len = 0;
                    //                    while ((len = is.read()) != -1) {
                    //                        fos.write(len);
                    //                    }
                    //第二种写法(每次读1024个字节)
                    byte[] buffer = new byte[1024* 10];
                    while (is.read(buffer) != -1) {
                        fos.write(buffer);
                    }
                    //关流顺序，先打开的后关闭
                    fos.close();
                    is.close();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("解压完成，耗时：" + (end - start) + " ms");
        } catch (Exception e) {
            throw new RuntimeException("unzip error from ZipUtils", e);
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
