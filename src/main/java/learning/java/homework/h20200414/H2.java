/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.homework.h20200414;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Rayliu40k
 * @version $Id: H2.java, v 0.1 Apr 21, 2020 8:09:38 PM Rayliu40k Exp $
 */
public class H2 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> h001 = new ArrayList<Integer>();
        int i01 = 28;
        int i02 = 28;
        int i03 = 55;
        int i04 = 67;
        int i05 = 18;
        int i06 = 14;
        int i07 = 78;
        int i08 = 55;
        int i09 = 25;
        h001.add(i01);
        h001.add(i02);
        h001.add(i03);
        h001.add(i04);
        h001.add(i05);
        h001.add(i06);
        h001.add(i07);
        h001.add(i08);
        h001.add(i09);
        List<Integer> xxx = h02(h001);
        System.out.println(xxx);
    }

    public static List<Integer> h02(List<Integer> h001) {
        ArrayList<Integer> dy28 = new ArrayList<Integer>();
        for (Integer dy_28 : h001) {
            if (dy_28 > 28) {
                dy28.add(dy_28);
            }
        }
        return dy28;
    }
}
