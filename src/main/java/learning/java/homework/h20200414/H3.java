package learning.java.homework.h20200414;

import java.util.ArrayList;
import java.util.List;


public class H3 {
/**
 * @author Xzai
 * @return main
 * @param args
 */
	public static void main(String[] args) {
		ArrayList<Person> h003 = new ArrayList<Person>();
		Person patient01 = new Person("小王","中坝社区");
        Person patient02 = new Person("小美","黄忠社区");
        Person patient03 = new Person("小刘","蓓蕾社区");
        Person patient04 = new Person("小张","苏坡社区");
        Person patient05 = new Person("小宋","芳草社区");
        Person patient06 = new Person("小李","中坝社区");
        Person patient07 = new Person("小明","芳草社区");
        Person patient08 = new Person("小杨","蓓蕾社区");
        Person patient09 = new Person("小秦","芳草社区");
		h003.add(patient01);
		h003.add(patient02);
		h003.add(patient03);
		h003.add(patient04);
		h003.add(patient05);
		h003.add(patient06);
		h003.add(patient07);
		h003.add(patient08);
		h003.add(patient09);
		String sq1 = sq("小宋", h003);
		System.out.println(sq1);
	}
/**
 * 
 * @param h003
 * @return 社区
 */
	public static String sq(String getMc,List<Person> h003) {
		String sq = null;
		for(Person r:h003) {
			if(getMc.equals("小宋")) {
				sq=r.getMc();
			}
		}
		return sq;
	}
}
