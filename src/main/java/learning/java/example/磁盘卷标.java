/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.example;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * 获取磁盘卷标
 * 
 * @author Rayliu40k
 * @version $Id: Test.java, v 0.1 Sep 20, 2020 9:25:44 AM Rayliu40k Exp $
 */
public class 磁盘卷标 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        //当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] fs = File.listRoots();
        //显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
        }
    }

}
