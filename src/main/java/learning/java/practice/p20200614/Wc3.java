/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package learning.java.practice.p20200614;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author Rayliu40k
 * @version $Id: Wc3.java, v 0.1 Jul 19, 2020 9:38:27 AM Rayliu40k Exp $
 */
public class Wc3 {
    public static void main(String[] args) throws Exception {
        Map<Integer, Wc_cs> wc = new HashMap<Integer, Wc_cs>();
        Wc_cs w1 = new Wc_cs(1, 1930, "乌拉圭", "乌拉圭");
        Wc_cs w2 = new Wc_cs(2, 1934, "意大利", "意大利");
        Wc_cs w3 = new Wc_cs(3, 1938, "法国", "意大利");
        Wc_cs w4 = new Wc_cs(4, 1950, "巴西", "乌拉圭");
        Wc_cs w5 = new Wc_cs(5, 1954, "瑞士", "西德");
        Wc_cs w6 = new Wc_cs(6, 1958, "瑞典", "巴西");
        Wc_cs w7 = new Wc_cs(7, 1962, "智利", "巴西");
        Wc_cs w8 = new Wc_cs(8, 1966, "英格兰", "英格兰");
        Wc_cs w9 = new Wc_cs(9, 1970, "墨西哥", "巴西");
        Wc_cs w10 = new Wc_cs(10, 1974, "前西德", "西德");
        Wc_cs w11 = new Wc_cs(11, 1978, "阿根廷", "阿根廷");
        Wc_cs w12 = new Wc_cs(12, 1982, "西班牙", "意大利");
        Wc_cs w13 = new Wc_cs(13, 1986, "墨西哥", "阿根廷");
        Wc_cs w14 = new Wc_cs(14, 1990, "意大利", "西德");
        Wc_cs w15 = new Wc_cs(15, 1994, "美国", "巴西");
        Wc_cs w16 = new Wc_cs(16, 1998, "法国", "法国");
        Wc_cs w17 = new Wc_cs(17, 2002, "韩日", "巴西");
        Wc_cs w18 = new Wc_cs(18, 2006, "德国", "意大利");
        Wc_cs w19 = new Wc_cs(19, 2010, "南非", "西班牙");
        Wc_cs w20 = new Wc_cs(20, 2014, "巴西", "德国");
        Wc_cs w21 = new Wc_cs(21, 2018, "俄罗斯", "法国");
        wc.put(w1.jvBanNianShu, w1);
        wc.put(w2.jvBanNianShu, w2);
        wc.put(w3.jvBanNianShu, w3);
        wc.put(w4.jvBanNianShu, w4);
        wc.put(w5.jvBanNianShu, w5);
        wc.put(w6.jvBanNianShu, w6);
        wc.put(w7.jvBanNianShu, w7);
        wc.put(w8.jvBanNianShu, w8);
        wc.put(w9.jvBanNianShu, w9);
        wc.put(w10.jvBanNianShu, w10);
        wc.put(w11.jvBanNianShu, w11);
        wc.put(w12.jvBanNianShu, w12);
        wc.put(w13.jvBanNianShu, w13);
        wc.put(w14.jvBanNianShu, w14);
        wc.put(w15.jvBanNianShu, w15);
        wc.put(w16.jvBanNianShu, w16);
        wc.put(w17.jvBanNianShu, w17);
        wc.put(w18.jvBanNianShu, w18);
        wc.put(w19.jvBanNianShu, w19);
        wc.put(w20.jvBanNianShu, w20);
        wc.put(w21.jvBanNianShu, w21);
        Set<Entry<Integer, Wc_cs>> entrys = wc.entrySet();
        for (Entry<Integer, Wc_cs> entry : entrys) {
            if (entry.getValue().getJvBanDiDian().equals(entry.getValue().getGuanJvn())) {
                System.out
                    .println(entry.getValue().getJieShu() + "," + entry.getValue().getJvBanNianShu()
                             + "," + entry.getValue().getJvBanDiDian() + ","
                             + entry.getValue().getGuanJvn());
            }
        }
    }
}
