package learning.java.homework.h20200414;

import java.util.ArrayList;
import java.util.List;

import learning.java.practice.p20200331.Person;

public class H3 {
/**
 * @author Xzai
 * @return main
 * @param args
 */
	public static void main(String[] args) {
		ArrayList<Person> h003 = new ArrayList<Person>();
		Person patient01 = new Person("510103198403254118", "小王", 28, 37.4, "中坝社区");
        Person patient02 = new Person("510104196507218121", "小美", 28, 38.3, "黄忠社区");
        Person patient03 = new Person("510102199511023322", "小刘", 55, 36.9, "蓓蕾社区");
        Person patient04 = new Person("510106195509225413", "小张", 67, 37.2, "苏坡社区");
        Person patient05 = new Person("510104198507212114", "小宋", 18, 37.5, "芳草社区");
        Person patient06 = new Person("510107199507213115", "小李", 14, 37.6, "中坝社区");
        Person patient07 = new Person("510104197507214126", "小明", 78, 36.8, "芳草社区");
        Person patient08 = new Person("510109199801115123", "小杨", 55, 36.9, "蓓蕾社区");
        Person patient09 = new Person("510104197603217112", "小秦", 25, 38.5, "芳草社区");
		h003.add(patient01);
		h003.add(patient02);
		h003.add(patient03);
		h003.add(patient04);
		h003.add(patient05);
		h003.add(patient06);
		h003.add(patient07);
		h003.add(patient08);
		h003.add(patient09);
	}
/**
 * 
 * @param h003
 * @return 社区
 */
	public static String sq(List<Integer> h003) {
		ArrayList<String> sq = new ArrayList<String>();
		return null;
	}
}
