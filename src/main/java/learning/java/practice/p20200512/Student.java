package learning.java.practice.p20200512;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Xzai
 *
 */
public class Student {
	/**
	 * @param args
	 * @notes null
	 */
	public static void main(String[] args) {
		//
		List<Stu> allStudent = new ArrayList<Stu>();
		//
		Stu student01 = new Stu("小王", 89, 90, 91, "王芳");
		Stu student02 = new Stu("小李", 65, 88, 83, "李海");
		Stu student03 = new Stu("小宋", 78, 65, 89, "宋阳");
		Stu student04 = new Stu("小明", 93, 88, 92, "张大明");
		Stu student05 = new Stu("小芳", 67, 87, 76, "夏芳");
		Stu student06 = new Stu("小秦", 85, 95, 80, "秦岚");
		Stu student07 = new Stu("小刘", 90, 90, 86, "刘东");
		//
		allStudent.add(student01);
		allStudent.add(student02);
		allStudent.add(student03);
		allStudent.add(student04);
		allStudent.add(student05);
		allStudent.add(student06);
		allStudent.add(student07);
		//
		student(allStudent);
	}

	/**
	 * @param null
	 * @notes null
	 */
	private static void student(List<Stu> allStudent) {
		//
		List<Integer> chinese = new ArrayList<Integer>();
		//
		for (Stu stu : allStudent) {
			//
			chinese.add(stu.getCh());
		}
		//
		chinese.sort(Comparator.reverseOrder());
		//
		System.out.println(chinese);
	}
}
