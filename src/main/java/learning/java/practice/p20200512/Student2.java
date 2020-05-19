package learning.java.practice.p20200512;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Xzai
 *
 */
public class Student2 {
	/**
	 * @param args
	 * @notes null
	 */
	public static void main(String[] args) {
		// 添加List(class调用类型)
		List<Stu> allStudents = new ArrayList<Stu>();
		// 把参数传到Stu的文件里
		Stu student01 = new Stu("小王", 89, 90, 91, "王芳");
		Stu student02 = new Stu("小李", 65, 88, 83, "李海");
		Stu student03 = new Stu("小宋", 78, 65, 89, "宋阳");
		Stu student04 = new Stu("小明", 93, 88, 92, "张大明");
		Stu student05 = new Stu("小芳", 67, 87, 76, "夏芳");
		Stu student06 = new Stu("小秦", 85, 95, 80, "秦岚");
		Stu student07 = new Stu("小刘", 90, 90, 86, "刘东");
		// 把Stu文件里的参数添加到allStudents
		allStudents.add(student01);
		allStudents.add(student02);
		allStudents.add(student03);
		allStudents.add(student04);
		allStudents.add(student05);
		allStudents.add(student06);
		allStudents.add(student07);
		// 调用方法+传参数
		student(allStudents);
	}

	/**
	 * @param null
	 * @notes null
	 */
	private static void student(List<Stu> allStudents) {
		int ch = 0;
		int ma = 0;
		int en = 0;
		String name = "";
		for (Stu Stu : allStudents) {
			if (ch < Stu.getCh() && en < Stu.getEn() && ma < Stu.getMa()) {
				ch = Stu.getCh();
				en = Stu.getEn();
				ma = Stu.getMa();
				name =Stu.getPa();
			}
		}
		System.out.println(name);
	}
}