/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package learning.java.grammar;

/**
 * 条件判断2
 * 
 * @author Rayliu40k
 * @version $Id: 条件判断2.java, v 0.1 Aug 25, 2019 10:03:26 PM Rayliu40k Exp $
 */
public class 条件判断2 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 定义条件判断(变量)
         */
        //定义变量name，支持类型：short、int、char、String
        int name = 'o';
        //当变量的值与某个case匹配，执行那个case的分支语句，如果遇到break，则结束switch语句，否者继续向下执行
        switch (name) {
            case 'a':
                //分支语句1
                break; //可选
            case 'b':
                //分支语句2
                break; //可选
            case 'c':
                //分支语句3
                break; //可选
            //你可以有任意数量的case语句
            default: //可选
                //分支语句4
        }

        /**
         * 例子1
         * 选择星期几
         */
        int day = 5;
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期天");
                break;
            default:
                System.out.println("输入的数字不正确...");
        }

        /**
         * 例子2
         * 选择工作日
         */
        System.out.println("-------华丽的分割线-------");
        int workday = 2;
        switch (workday) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                //当workday满足值1、2、3、4、5中任意一个，执行分支语句1
                //分支语句1
                System.out.println("今天是工作日");
                break;
            case 6:
            case 7:
                //当workday满足值6、7中任意一个时，执行分支语句2
                //分支语句2
                System.out.println("今天是休息日");
                break;
        }
    }

}
