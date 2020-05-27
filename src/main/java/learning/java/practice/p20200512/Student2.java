package learning.java.practice.p20200512;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import learning.java.practice.p20200512.ray.Student;

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
		// 准备数据
		List<Student> students = new ArrayList<Student>();
		Student student01 = new Student("小王", "王芳", 89, 90, 91);
		Student student02 = new Student("小李", "李海", 65, 88, 83);
		Student student03 = new Student("小宋", "宋阳", 78, 65, 89);
		Student student04 = new Student("小明", "张大明", 93, 88, 92);
		Student student05 = new Student("小芳", "夏芳", 67, 87, 76);
		Student student06 = new Student("小秦", "秦岚", 85, 95, 80);
		Student student07 = new Student("小刘", "刘东", 90, 90, 86);
		students.add(student01);
		students.add(student02);
		students.add(student03);
		students.add(student04);
		students.add(student05);
		students.add(student06);
		students.add(student07);

		top3InCourses(students);
	}

	/**
	 * 找出单科成绩最高的前3名，并发送钉钉消息给他的家长
	 * 
	 * @param students 所有学生
	 */
	public static void top3InCourses(List<Student> students) {
		List<Integer> allChineseScore = new ArrayList<>();
		for (Student student : students) {
			allChineseScore.add(student.getChineseScore());
		}
		allChineseScore.sort(Comparator.reverseOrder());
		List<Integer> top3ChineseScore = allChineseScore.subList(0, 3);
		System.out.println(top3ChineseScore);

		List<Student> top3ChineseScoreStudents = new ArrayList<Student>();
		for (Student student : students) {
			if (top3ChineseScore.contains(student.getChineseScore())) {
				top3ChineseScoreStudents.add(student);
			}
		}
		top3ChineseScoreStudents.sort(Comparator.comparing(Student::getChineseScore).reversed());

		top3ChineseScoreStudents.forEach(student -> {
			System.out.println("-----");
			System.out.println(student.getName());
			System.out.println(student.getChineseScore());
			System.out.println(student.getParent());
		});

		int rank = 0;
		for (Student student : top3ChineseScoreStudents) {
			rank++;
			String contenet = "家长【" + student.getParent() + "】您好，您的孩子【" + student.getName() + "】在本次期末考试中，【语文】获得"
					+ student.getChineseScore() + "分，排名全班第【" + rank + "】，恭喜您。";
			System.out.println(contenet);
		}

	}
}
