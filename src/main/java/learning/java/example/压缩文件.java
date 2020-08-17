/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件
 * 
 * @author Rayliu40k
 * @version $Id: 压缩文件.java, v 0.1 Aug 17, 2020 2:17:19 PM Rayliu40k Exp $
 */
public class 压缩文件 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        zipFile(
            "/Users/Rayliu40k/eclipse-workspace/Java-learning_github/src/main/java/learning/java/example/README.txt",
            "/tmp/README.zip");
    }

    /**
     * 压缩文件(ZIP)
     * 
     * @param filePath 原文件路径
     * @param zipPath 压缩文件路径
     */
    public static void zipFile(String filePath, String zipPath) throws Exception {
        //读取源文件
        File file = new File(filePath);
        InputStream input = new FileInputStream(file);
        //指定压缩文件
        File zipFile = new File(zipPath);
        //开始压缩文件
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        int temp = 0;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }
        //关闭文件流
        input.close();
        zipOut.close();
    }

}
