package learning.java.practice.p20200614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Wc1 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Wc_cs> wc = new HashMap<String, Wc_cs>();
		Wc_cs w1 = new Wc_cs("第1届", "1930", "乌拉圭", "乌拉圭");
		Wc_cs w2 = new Wc_cs("第2届", "1934", "意大利", "意大利");
		Wc_cs w3 = new Wc_cs("第3届", "1938", "法国", "意大利");
		Wc_cs w4 = new Wc_cs("第4届", "1950", "巴西", "乌拉圭");
		Wc_cs w5 = new Wc_cs("第5届", "1954", "瑞士", "西德");
		Wc_cs w6 = new Wc_cs("第6届", "1958", "瑞典", "巴西");
		Wc_cs w7 = new Wc_cs("第7届", "1962", "智利", "巴西");
		Wc_cs w8 = new Wc_cs("第8届", "1966", "英格兰", "英格兰");
		Wc_cs w9 = new Wc_cs("第9届", "1970", "墨西哥", "巴西");
		Wc_cs w10 = new Wc_cs("第10届", "1974", "前西德", "西德");
		Wc_cs w11 = new Wc_cs("第11届", "1978", "阿根廷", "阿根廷");
		Wc_cs w12 = new Wc_cs("第12届", "1982", "西班牙", "意大利");
		Wc_cs w13 = new Wc_cs("第13届", "1986", "墨西哥", "阿根廷");
		Wc_cs w14 = new Wc_cs("第14届", "1990", "意大利", "西德");
		Wc_cs w15 = new Wc_cs("第15届", "1994", "美国", "巴西");
		Wc_cs w16 = new Wc_cs("第16届", "1998", "法国", "法国");
		Wc_cs w17 = new Wc_cs("第17届", "2002", "韩日", "巴西");
		Wc_cs w18 = new Wc_cs("第18届", "2006", "德国", "意大利");
		Wc_cs w19 = new Wc_cs("第19届", "2010", "南非", "西班牙");
		Wc_cs w20 = new Wc_cs("第20届", "2014", "巴西", "德国");
		Wc_cs w21 = new Wc_cs("第21届", "2018", "俄罗斯", "法国");
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
		System.err.println("欢迎来到世界杯查询软件");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			System.out.print("请输入:");
			String input = br.readLine();
			Wc_cs old = wc.get(input);
			if (old == null) {
				System.out.println("[没有举办世界杯]");
				System.out.print("是否继续(y/n):");
				String input1 = br.readLine();
				if (input1.equals("y")) {
					main(args);
				} else {
					System.err.print("已退出");
					System.exit(0);
				}
			} else {
				System.out.println("[冠军:" + old.guanJvn + "],[举办地点:" + old.jvBanDiDian + "]");
			}
		}
	}
}
